package co.edu.usbcali.storeusb.service;

import co.edu.usbcali.storeusb.dto.CategoriaDTO;
import co.edu.usbcali.storeusb.dto.request.CreateCategoriaRequest;
import co.edu.usbcali.storeusb.dto.request.UpdateCategoriaRequest;
import co.edu.usbcali.storeusb.dto.response.CategoriaConProductos;

public interface CategoriaService {

    CategoriaDTO crearCategoria(CreateCategoriaRequest createCategoriaRequest) throws Exception;

    CategoriaConProductos consultarCategoriaConProductos(Integer categoriaId) throws Exception;

    CategoriaDTO inactivarCategoria(Integer categoriaId) throws Exception;

    CategoriaDTO activarCategoria(Integer categoriaId) throws Exception;

    CategoriaDTO actualizarCategoria(Integer id, UpdateCategoriaRequest updateCategoriaRequest) throws Exception;
}
