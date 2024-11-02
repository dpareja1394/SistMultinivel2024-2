package co.edu.usbcali.storeusb.controller;

import co.edu.usbcali.storeusb.dto.TipoDocumentoDTO;
import co.edu.usbcali.storeusb.mapper.TipoDocumentoMapper;
import co.edu.usbcali.storeusb.repository.TipoDocumentoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo-documento")
public class TipoDocumentoController {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoController(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<TipoDocumentoDTO> getTipoDocumentos() {
        /*List<TipoDocumentoDTO> tiposDocumentosDTO;
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        tiposDocumentosDTO = TipoDocumentoMapper.domainToDTOList(tipoDocumentos);
        return tiposDocumentosDTO;*/

        return TipoDocumentoMapper.domainToDTOList(tipoDocumentoRepository.findAll());
    }


}
