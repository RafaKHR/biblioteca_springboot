package local.api.controller;

import local.api.dto.CategoriaDTO;
import local.api.model.CategoriaEntity;
import local.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.net.URI;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<CategoriaEntity>> listarTodos() {
        List<CategoriaEntity> lista = categoriaService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/categoria/{id}")
    public ResponseEntity<CategoriaEntity> findById(@PathVariable("id") Long id) {
        CategoriaEntity entity = categoriaService.findById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<CategoriaEntity> incluir(@RequestBody CategoriaDTO request) {
        CategoriaEntity categoriaEntity = categoriaService.incluir(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriaEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/alterar/{id}")
    public ResponseEntity<CategoriaEntity> alterar(@PathVariable Long id, @RequestBody
CategoriaDTO request) {
        CategoriaEntity lista = categoriaService.alterar(id, request);
        return ResponseEntity.ok().body(lista);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<ResponseEntity> deletar(@PathVariable Long id) {
        ResponseEntity lista = categoriaService.deletar(id);
        return ResponseEntity.ok().body(lista);
    }
}
