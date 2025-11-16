package local.api.controller;

import local.api.dto.AutorDTO;
import local.api.model.AutorEntity;
import local.api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<AutorEntity>> listarTodos() {
        List<AutorEntity> lista = autorService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/autor/{id}")
    public ResponseEntity<AutorEntity> findById(@PathVariable("id") Long id) {
        AutorEntity entity = autorService.findById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<List<AutorDTO>> incluir(@RequestBody AutorDTO request) {
        AutorEntity autorEntity = autorService.incluir(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/alterar/{id}")
    public ResponseEntity<AutorEntity> alterar(@PathVariable Long id, @RequestBody
AutorDTO request) {
        AutorEntity lista = autorService.alterar(id, request);
        return ResponseEntity.ok().body(lista);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<ResponseEntity> deletar(@PathVariable Long id) {
        ResponseEntity lista = autorService.deletar(id);
        return ResponseEntity.ok().body(lista);
    }
}
