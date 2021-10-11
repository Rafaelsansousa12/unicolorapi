package com.unicolor.unicolorapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CLASSE", nullable = false)
    private String classe;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "CODIGO_LAZZURIL", nullable = false)
    private Long lazzurilCode;

    @Column(name = "CODIGO_UNIVERSAL", nullable = false)
    private Long uniCode;

    @Column(name = "IMAGEM")
    private byte[] imagem;

}
