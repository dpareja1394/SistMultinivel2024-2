package co.edu.usbcali.storeusb.service.impl;

import co.edu.usbcali.storeusb.domain.Categoria;
import co.edu.usbcali.storeusb.dto.CategoriaDTO;
import co.edu.usbcali.storeusb.dto.request.CreateCategoriaRequest;
import co.edu.usbcali.storeusb.mapper.CategoriaMapper;
import co.edu.usbcali.storeusb.repository.CategoriaRepository;
import co.edu.usbcali.storeusb.service.CategoriaService;
import co.edu.usbcali.storeusb.utils.Constants;
import co.edu.usbcali.storeusb.utils.validation.CategoriaMessage;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
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
}
