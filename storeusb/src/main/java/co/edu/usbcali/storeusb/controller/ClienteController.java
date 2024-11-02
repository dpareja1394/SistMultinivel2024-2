package co.edu.usbcali.storeusb.controller;

import co.edu.usbcali.storeusb.dto.ClienteDTO;
import co.edu.usbcali.storeusb.mapper.ClienteMapper;
import co.edu.usbcali.storeusb.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping("/all")
    public List<ClienteDTO> getClientes() {
        return ClienteMapper.domainToDTOList(clienteRepository.findAll());
    }
}
