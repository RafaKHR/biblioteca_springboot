package local.api.service;

import local.api.dto.AutorDTO;
import local.api.model.AutorEntity;
import local.api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorEntity> listarTodos() {
        return autorRepository.findAll();
    }

    public AutorEntity findById(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado - id: " + id));
    }

    public AutorEntity incluir(AutorDTO dto) {
        AutorEntity entity = AutorEntity.builder()
                .nome(dto.getNome())
                .nacionalidade(dto.getNacionalidade())
                .build();
        return autorRepository.save(entity);
    }

    public AutorEntity alterar(Long id, AutorDTO dto) {
        AutorEntity objeto = findById(id);
        objeto.setNome(dto.getNome());
        objeto.setNacionalidade(dto.getNacionalidade());
        return autorRepository.save(objeto);
    }

    public ResponseEntity deletar(Long id) {
        autorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
