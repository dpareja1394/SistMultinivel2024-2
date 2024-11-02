package co.edu.usbcali.storeusb.controller;

import co.edu.usbcali.storeusb.dto.CategoriaDTO;
import co.edu.usbcali.storeusb.dto.request.CreateCategoriaRequest;
import co.edu.usbcali.storeusb.mapper.CategoriaMapper;
import co.edu.usbcali.storeusb.repository.CategoriaRepository;
import co.edu.usbcali.storeusb.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaRepository categoriaRepository,
                               CategoriaService categoriaService) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping("/all")
    public List<CategoriaDTO> getCategorias() {
        return CategoriaMapper.domainToDTOList(categoriaRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<CategoriaDTO> crearCategoria(@RequestBody CreateCategoriaRequest createCategoriaRequest) throws Exception{
        CategoriaDTO categoriaResponse =
                categoriaService.crearCategoria(createCategoriaRequest);
        return ResponseEntity.ok(categoriaResponse);
    }
}
