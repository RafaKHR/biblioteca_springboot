package local.api.service;

import local.api.dto.CategoriaDTO;
import local.api.model.CategoriaEntity;
import local.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaEntity> listarTodos(){
        return categoriaRepository.findAll();
    }

    public CategoriaEntity findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada - id: " + id));
    }

    public CategoriaEntity incluir(CategoriaDTO dto) {
        CategoriaEntity entity = CategoriaEntity.builder()
                .nome(dto.getNome())
                .build();
        return categoriaRepository.save(entity);
    }

    public CategoriaEntity alterar(Long id, CategoriaDTO dto) {
        CategoriaEntity objeto = findById(id);
        objeto.setNome(dto.getNome());
        return categoriaRepository.save(objeto);
    }

    public ResponseEntity deletar(Long id) {
        categoriaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
