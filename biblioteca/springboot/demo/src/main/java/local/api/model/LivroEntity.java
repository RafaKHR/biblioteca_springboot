package local.api.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_LIVROS")
public class LivroEntity {

    private static final long serialVersionUID = 6916365966042464265L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "livroSequence")
    @SequenceGenerator(name = "livroSequence", sequenceName = "SEQ_LIVRO",
allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "ISBN", nullable = false, length = 13)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorEntity autor;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;
}
