package com.unicolor.unicolorapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CorDTO {

    @NotEmpty
    private Long id;

    @NotEmpty
    private String classe;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private Long lazzurilCode;

    @NotEmpty
    private Long uniCode;

    @NotEmpty
    private byte[] imagem;
}
