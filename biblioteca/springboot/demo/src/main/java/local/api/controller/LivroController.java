package local.api.controller;

import local.api.dto.LivroDTO;
import local.api.model.LivroEntity;
import local.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.net.URI;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<LivroEntity>> listarTodos() {
        List<LivroEntity> lista = livroService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/livro/{id}")
    public ResponseEntity<LivroEntity> findById(@PathVariable("id") Long id) {
        LivroEntity entity = livroService.findById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<LivroEntity> incluir(@RequestBody LivroDTO request) {
        LivroEntity entity = livroService.incluir(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/alterar/{id}")
    public ResponseEntity<LivroEntity> alterar(@PathVariable Long id, @RequestBody
LivroDTO request) {
        LivroEntity entity = livroService.alterar(id, request);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<ResponseEntity> deletar(@PathVariable Long id) {
        ResponseEntity lista = livroService.deletar(id);
        return ResponseEntity.ok().body(lista);
    }
}
