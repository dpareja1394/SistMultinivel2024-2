package co.edu.usbcali.storeusb.service.impl;

import co.edu.usbcali.storeusb.domain.Categoria;
import co.edu.usbcali.storeusb.domain.Producto;
import co.edu.usbcali.storeusb.dto.ProductoDTO;
import co.edu.usbcali.storeusb.dto.request.CreateProductoRequest;
import co.edu.usbcali.storeusb.mapper.ProductoMapper;
import co.edu.usbcali.storeusb.repository.CategoriaRepository;
import co.edu.usbcali.storeusb.repository.ProductoRepository;
import co.edu.usbcali.storeusb.service.ProductoService;
import co.edu.usbcali.storeusb.utils.Constants;
import co.edu.usbcali.storeusb.utils.validation.CategoriaMessage;
import co.edu.usbcali.storeusb.utils.validation.ProductoMessage;
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
        // Validar que la categoría exista
        Categoria categoria = categoriaRepository.findById(createProductoRequest.getCategoriaId())
                .orElseThrow(
                        () -> new Exception(String.format(CategoriaMessage.NO_EXISTE_CATEGORIA_POR_ID,
                                createProductoRequest.getCategoriaId()))
                );

        // Validar si ya existe esa referencia dentro de la Categoria
        Optional.ofNullable(productoRepository.existsByCategoriaIdAndReferenciaAndEstado(categoria.getId(),
                        createProductoRequest.getReferencia().toUpperCase(), Constants.ESTADO_ACTIVO))
                .ifPresent(exists -> { throw new RuntimeException(String.format(
                        ProductoMessage.EXISTE_REFERENCIA_EN_CATEGORIA, createProductoRequest.getReferencia().toUpperCase(),
                        categoria.getId(), categoria.getNombre()));
                        });




        /*if (productoRepository.existsByCategoriaIdAndReferenciaAndEstado(
                categoria.getId(),
                createProductoRequest.getReferencia().toUpperCase(),
                Constants.ESTADO_ACTIVO
        )) {
            throw new Exception(
                    String.format(ProductoMessage.EXISTE_REFERENCIA_EN_CATEGORIA,
                            createProductoRequest.getReferencia().toUpperCase(),
                            categoria.getId(), categoria.getNombre())
            );
        }*/

        Producto producto = ProductoMapper.createProductoRequestToDomain(createProductoRequest);
        producto.setCategoria(categoria);

        producto = productoRepository.save(producto);

        return ProductoMapper.domainToDTO(producto);
    }
}
