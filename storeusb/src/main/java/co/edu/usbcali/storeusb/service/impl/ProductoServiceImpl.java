package co.edu.usbcali.storeusb.service.impl;

import co.edu.usbcali.storeusb.domain.Categoria;
import co.edu.usbcali.storeusb.domain.Producto;
import co.edu.usbcali.storeusb.dto.ProductoDTO;
import co.edu.usbcali.storeusb.dto.request.CreateProductoRequest;
import co.edu.usbcali.storeusb.mapper.ProductoMapper;
import co.edu.usbcali.storeusb.repository.CategoriaRepository;
import co.edu.usbcali.storeusb.repository.ProductoRepository;
import co.edu.usbcali.storeusb.service.ProductoService;
import co.edu.usbcali.storeusb.utils.validation.CategoriaMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ProductoDTO crearProducto(CreateProductoRequest createProductoRequest) throws Exception {
        // Validacion de los campos
        if (createProductoRequest == null) {
            throw new Exception("No ha llegado el Objeto Producto para crear");
        }
        if (createProductoRequest.getReferencia() == null ||
                createProductoRequest.getReferencia().trim().equals("")) {
            throw new Exception("La referencia no puede ser nula ni vacía");
        }
        if (createProductoRequest.getReferencia().length() > 10) {
            throw new Exception("La referencia no puede superar el tamaño de 10 caracteres");
        }

        if (createProductoRequest.getNombre() == null ||
                createProductoRequest.getNombre().trim().equals("")) {
            throw new Exception("El nombre no puede ser nulo ni vacío");
        }
        if (createProductoRequest.getNombre().length() > 50) {
            throw new Exception("El nombre no puede superar el tamaño de 50 caracteres");
        }

        // Descripción solo se valida si supera los 255 caracteres
        if (createProductoRequest.getDescripcion() != null && createProductoRequest.getDescripcion().length() > 255) {
            throw new Exception("La descripción de la Categoría no puede exceder los 255 caracteres");
        }

        if (createProductoRequest.getPrecioUnitario() == null) {
            throw new Exception("El precio unitario no puede ser nulo");
        }

        if (createProductoRequest.getUnidadesDisponibles() == null) {
            throw new Exception("Las unidades disponibles no puede ser nulas");
        }

        // Validar que la categoría exista
        Categoria categoria = categoriaRepository.findById(createProductoRequest.getCategoriaId())
                .orElseThrow(
                        () -> new Exception(String.format(CategoriaMessage.NO_EXISTE_CATEGORIA_POR_ID,
                                createProductoRequest.getCategoriaId()))
                );

        Producto producto = ProductoMapper.createProductoRequestToDomain(createProductoRequest);
        producto.setCategoria(categoria);

        producto = productoRepository.save(producto);

        return ProductoMapper.domainToDTO(producto);
    }
}
