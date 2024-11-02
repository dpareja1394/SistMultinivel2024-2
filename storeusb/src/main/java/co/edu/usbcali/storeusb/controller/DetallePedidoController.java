package co.edu.usbcali.storeusb.controller;

import co.edu.usbcali.storeusb.dto.DetallePedidoDTO;
import co.edu.usbcali.storeusb.mapper.DetallePedidoMapper;
import co.edu.usbcali.storeusb.repository.DetallePedidoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalle-pedido")
public class DetallePedidoController {

    private final DetallePedidoRepository detallePedidoRepository;
    public DetallePedidoController(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping("/all")
    public List<DetallePedidoDTO> getDetallePedidos() {
        return DetallePedidoMapper.domainToDTOList(detallePedidoRepository.findAll());
    }

}
