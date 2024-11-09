package co.edu.usbcali.storeusb.service;

import co.edu.usbcali.storeusb.dto.CategoriaDTO;
import co.edu.usbcali.storeusb.dto.request.CreateCategoriaRequest;
import co.edu.usbcali.storeusb.dto.response.CategoriaConProductos;

public interface CategoriaService {

    CategoriaDTO crearCategoria(CreateCategoriaRequest createCategoriaRequest) throws Exception;

    CategoriaConProductos consultarCategoriaConProductos(Integer categoriaId) throws Exception;
}
