package local.api.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_AUTORES")
public class AutorEntity {

    private static final long serialVersionUID = 6916365966042464265L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "autorSequence")
    @SequenceGenerator(name = "autorSequence", sequenceName = "SEQ_AUTOR",
allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 60)
    private String nome;

    @Column(name = "NACIONALIDADE", nullable = false)
    private String nacionalidade;
}
