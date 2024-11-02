package co.edu.usbcali.storeusb.service;

import co.edu.usbcali.storeusb.dto.CategoriaDTO;
import co.edu.usbcali.storeusb.dto.request.CreateCategoriaRequest;

public interface CategoriaService {

    public CategoriaDTO crearCategoria(CreateCategoriaRequest createCategoriaRequest) throws Exception;

}
