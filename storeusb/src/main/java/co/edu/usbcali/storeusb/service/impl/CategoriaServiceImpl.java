package co.edu.usbcali.storeusb.service.impl;

import co.edu.usbcali.storeusb.domain.Categoria;
import co.edu.usbcali.storeusb.dto.CategoriaDTO;
import co.edu.usbcali.storeusb.dto.request.CreateCategoriaRequest;
import co.edu.usbcali.storeusb.mapper.CategoriaMapper;
import co.edu.usbcali.storeusb.repository.CategoriaRepository;
import co.edu.usbcali.storeusb.service.CategoriaService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaDTO crearCategoria(CreateCategoriaRequest createCategoriaRequest) throws Exception {

        // Validar que el objeto no sea nulo
        if (createCategoriaRequest == null) {
            throw new Exception("El objeto categoria ha llegado null");
        }

        // Validar que el campo nombre no sea nulo ni sea vacío
        if (createCategoriaRequest.getNombre() == null || createCategoriaRequest.getNombre().equals("")) {
            throw new Exception("El nombre de la categoria es obligatorio");
        }

        // Validar el tamaño si es superior a 10
        if (createCategoriaRequest.getNombre().length() > 10) {
            throw new Exception("El nombre de la Categoría no puede exceder los 10 caracteres");
        }

        // Descripción solo se valida si supera los 255 caracteres
        if (createCategoriaRequest.getDescripcion() != null && createCategoriaRequest.getDescripcion().length() > 255) {
            throw new Exception("La descripción de la Categoría no puede exceder los 255 caracteres");
        }

        Categoria categoria = CategoriaMapper.createCategoriaRequestToDomain(createCategoriaRequest);

        categoria = categoriaRepository.save(categoria);
        CategoriaDTO categoriaDTO = CategoriaMapper.domainToDTO(categoria);

        return categoriaDTO;
    }
}
