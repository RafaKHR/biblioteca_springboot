package local.api.service;

import local.api.dto.LivroDTO;
import local.api.model.LivroEntity;
import local.api.model.AutorEntity;
import local.api.model.CategoriaEntity;
import local.api.repository.LivroRepository;
import local.api.repository.AutorRepository;
import local.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<LivroEntity> listarTodos() {
        return livroRepository.findAll();
    }

    public LivroEntity findById(Long id){
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado - id: " + id));
    }

    public LivroEntity incluir(LivroDTO dto) {
        AutorEntity autor = autorRepository.findById(dto.getAutor_id())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado - id: " + dto.getAutor_id()));

        CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoria_id())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada - id: " + dto.getCategoria_id()));

        LivroEntity entity = LivroEntity.builder()
                .titulo(dto.getTitulo())
                .isbn(dto.getIsbn())
                .autor(autor)
                .categoria(categoria)
                .build();
        return livroRepository.save(entity);
    }

    public LivroEntity alterar(Long id, LivroDTO dto) {
        AutorEntity autor = autorRepository.findById(dto.getAutor_id())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado - id: " + dto.getAutor_id()));

        CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoria_id())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada - id: " + dto.getCategoria_id()));

        LivroEntity objeto = findById(id);

        objeto.setTitulo(dto.getTitulo());
        objeto.setIsbn(dto.getIsbn());
        objeto.setAutor(autor);
        objeto.setCategoria(categoria);
        return livroRepository.save(objeto);
    }

    public ResponseEntity deletar(Long id) {
        livroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
