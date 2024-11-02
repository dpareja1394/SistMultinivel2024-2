package co.edu.usbcali.storeusb.service;

import co.edu.usbcali.storeusb.dto.ProductoDTO;
import co.edu.usbcali.storeusb.dto.request.CreateProductoRequest;

public interface ProductoService {

    ProductoDTO crearProducto(CreateProductoRequest createProductoRequest) throws Exception;

}
