package co.edu.usbcali.storeusb.controller;

import co.edu.usbcali.storeusb.dto.EstadoPedidoDTO;
import co.edu.usbcali.storeusb.mapper.EstadoPedidoMapper;
import co.edu.usbcali.storeusb.repository.EstadoPedidoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado-pedido")
public class EstadoPedidoController {

    private final EstadoPedidoRepository estadoPedidoRepository;
    public EstadoPedidoController(EstadoPedidoRepository estadoPedidoRepository) {
        this.estadoPedidoRepository = estadoPedidoRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping("/all")
    public List<EstadoPedidoDTO> getEstadoPedidos() {
        return EstadoPedidoMapper.domainToDTOList(estadoPedidoRepository.findAll());
    }

}
