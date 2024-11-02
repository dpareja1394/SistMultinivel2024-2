package co.edu.usbcali.storeusb.controller;

import co.edu.usbcali.storeusb.dto.PedidoDTO;
import co.edu.usbcali.storeusb.mapper.PedidoMapper;
import co.edu.usbcali.storeusb.repository.PedidoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping("/all")
    public List<PedidoDTO> getPedidos() {
        return PedidoMapper.domainToDTOList(pedidoRepository.findAll());
    }

}
