package com.unicolor.unicolorapi.mapper;

import com.unicolor.unicolorapi.dto.CorDTO;
import com.unicolor.unicolorapi.entity.Cor;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper
public interface CorMapper {

    CorMapper INSTANCE = Mappers.getMapper(CorMapper.class);

    Cor toModel(CorDTO corDTO);

    CorDTO toDTO(Cor cor);
}
