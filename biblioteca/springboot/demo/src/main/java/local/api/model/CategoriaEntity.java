package local.api.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_CATEGORIAS")
public class CategoriaEntity {

    private static final long serialVersionUID = 6916365966042464265L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "categoriaSequence")
    @SequenceGenerator(name = "categoriaSequence", sequenceName = "SEQ_CATEGORIA",
allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 30)
    private String nome;
}
