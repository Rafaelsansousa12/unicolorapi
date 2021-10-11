package com.unicolor.unicolorapi.dto;

import com.unicolor.unicolorapi.entity.Cor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    @NotEmpty
    private Long id;

    @NotEmpty
    private String fabricante;

    @NotEmpty
    private String modelo;

    @NotEmpty
    private String ano;

    @NotEmpty
    private Cor cor;

}
