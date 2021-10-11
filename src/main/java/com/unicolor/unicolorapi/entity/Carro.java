package com.unicolor.unicolorapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FABRICANTE", nullable = false)
    private String fabricante;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @Column(name = "ANO", nullable = false)
    private String ano;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "COR_ID", nullable = false)
    private Cor cor;
}
