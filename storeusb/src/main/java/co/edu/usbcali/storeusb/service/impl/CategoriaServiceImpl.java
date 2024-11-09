package co.edu.usbcali.storeusb.service.impl;

import co.edu.usbcali.storeusb.domain.Categoria;
import co.edu.usbcali.storeusb.dto.CategoriaDTO;
import co.edu.usbcali.storeusb.dto.request.CreateCategoriaRequest;
import co.edu.usbcali.storeusb.dto.response.CategoriaConProductos;
import co.edu.usbcali.storeusb.dto.response.ProductoResponseCategoriaConProductos;
import co.edu.usbcali.storeusb.mapper.CategoriaMapper;
import co.edu.usbcali.storeusb.mapper.ProductoMapper;
import co.edu.usbcali.storeusb.repository.CategoriaRepository;
import co.edu.usbcali.storeusb.service.CategoriaService;
import co.edu.usbcali.storeusb.utils.Constants;
import co.edu.usbcali.storeusb.utils.validation.CategoriaMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
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
    @Transactional(readOnly = true)
    public CategoriaConProductos consultarCategoriaConProductos(Integer categoriaId) throws Exception {
        // Consultar la categoría y si no la encuentra, lanza excepcion
        Categoria categoria =
                categoriaRepository.findById(categoriaId)
                        .orElseThrow(
                                () -> new Exception(
                                        String.format(CategoriaMessage.NO_EXISTE_CATEGORIA_POR_ID, categoriaId)
                                )
                        );

        // Mapear la respuesta de Categoría con los Productos
        List<ProductoResponseCategoriaConProductos> productosResponse =
                ProductoMapper.domainToProductoResponseCategoriaConProductosList(
                        categoria.getProductos());

        return CategoriaMapper.domainToCategoriaConProductos(categoria,
                productosResponse);
    }

}
