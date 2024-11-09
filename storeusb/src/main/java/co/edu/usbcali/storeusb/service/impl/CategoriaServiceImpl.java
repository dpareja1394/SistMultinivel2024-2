package co.edu.usbcali.storeusb.service.impl;

import co.edu.usbcali.storeusb.domain.Categoria;
import co.edu.usbcali.storeusb.domain.Producto;
import co.edu.usbcali.storeusb.dto.CategoriaDTO;
import co.edu.usbcali.storeusb.dto.request.CreateCategoriaRequest;
import co.edu.usbcali.storeusb.dto.response.CategoriaConProductos;
import co.edu.usbcali.storeusb.dto.response.ProductoResponseCategoriaConProductos;
import co.edu.usbcali.storeusb.mapper.CategoriaMapper;
import co.edu.usbcali.storeusb.mapper.ProductoMapper;
import co.edu.usbcali.storeusb.repository.CategoriaRepository;
import co.edu.usbcali.storeusb.repository.ProductoRepository;
import co.edu.usbcali.storeusb.service.CategoriaService;
import co.edu.usbcali.storeusb.utils.Constants;
import co.edu.usbcali.storeusb.utils.validation.CategoriaMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository,
                                ProductoRepository productoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public CategoriaDTO crearCategoria(CreateCategoriaRequest createCategoriaRequest) throws Exception {

        // Validar si ya existe una Categoria con el nombre
        if (categoriaRepository.existsByNombreAndEstado(
                createCategoriaRequest.getNombre().toUpperCase(),
                Constants.ESTADO_ACTIVO)) {
            throw new Exception(
                    String.format(
                            CategoriaMessage.EXISTE_CATEGORIA_POR_NOMBRE_ESTADO_ACTIVO,
                            createCategoriaRequest.getNombre()));
        }

        Categoria categoria = CategoriaMapper.createCategoriaRequestToDomain(createCategoriaRequest);

        categoria = categoriaRepository.save(categoria);

        return CategoriaMapper.domainToDTO(categoria);
    }

    @Override
    public CategoriaConProductos consultarCategoriaConProductos(Integer categoriaId) throws Exception {
        // Consultar la categoría
        Optional<Categoria> categoriaOptional =
                categoriaRepository.findById(categoriaId);
        // Si no encuentra la Categoria se indica que existe
        if(categoriaOptional.isEmpty()) {
            throw new Exception(String.format(CategoriaMessage.NO_EXISTE_CATEGORIA_POR_ID, categoriaId));
        }

        // Consultar los productos que pertenecen a esa categoría
        List<Producto> productos = productoRepository.findAllByCategoriaId(categoriaId);


        // Mapear la respuesta de Categoría con los Productos
        List<ProductoResponseCategoriaConProductos> productosResponse =
                ProductoMapper.domainToProductoResponseCategoriaConProductosList(productos);

        return CategoriaMapper.domainToCategoriaConProductos(categoriaOptional.get(),
                productosResponse);
    }

}
