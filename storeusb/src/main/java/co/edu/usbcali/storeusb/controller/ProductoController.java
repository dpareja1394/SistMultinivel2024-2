package co.edu.usbcali.storeusb.controller;

import co.edu.usbcali.storeusb.dto.ProductoDTO;
import co.edu.usbcali.storeusb.dto.request.CreateProductoRequest;
import co.edu.usbcali.storeusb.mapper.ProductoMapper;
import co.edu.usbcali.storeusb.repository.ProductoRepository;
import co.edu.usbcali.storeusb.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoRepository productoRepository;
    private final ProductoService productoService;
    public ProductoController(ProductoRepository productoRepository,
                              ProductoService productoService) {
        this.productoRepository = productoRepository;
        this.productoService = productoService;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping("/all")
    public List<ProductoDTO> getProductos() {
        return ProductoMapper.domainToDTOList(productoRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody CreateProductoRequest createProductoRequest) throws Exception{
        ProductoDTO productoResponse =
                productoService.crearProducto(createProductoRequest);
        return ResponseEntity.ok(productoResponse);
    }

}
