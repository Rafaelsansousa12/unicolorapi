
create table cor (
    ID    bigint auto_increment primary key,
    CLASSE varchar(255) null,
    DESCRICAO  varchar(255) null,
    CODIGO_LAZZURIL  bigint null,
    CODIGO_UNIVERSAL  bigint(255) null,
    IMAGEM blob null
);

create table carro (
    ID    bigint auto_increment primary key,
    FABRICANTE varchar(255) null,
    MODELO  varchar(255) null,
    ANO  bigint null,
    COR_ID bigint null,
    constraint FK_CARRO_COR foreign key (COR_ID) references cor(id)
);


drop table cor;


INSERT INTO cor (classe_cor, desc_cor, ano, lazzuril_code, uni_code, fabricante, modelo)
VALUES ('amarelo', 'Chevrolet Goldenrod yellow', '2012', 1, 'WA3893', 'Chevrolet', 'Camaro');


INSERT INTO carro (classe_cor, desc_cor, ano, lazzuril_code, uni_code, fabricante, modelo)
VALUES ('amarelo', 'Chevrolet Goldenrod yellow', '2012', 1, 'WA3893', 'Chevrolet', 'Camaro');