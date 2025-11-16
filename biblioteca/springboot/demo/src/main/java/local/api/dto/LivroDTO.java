package local.api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO {

    private Long id;
    private String titulo;
    private String isbn;
    private Long autor_id;
    private Long categoria_id;
}
