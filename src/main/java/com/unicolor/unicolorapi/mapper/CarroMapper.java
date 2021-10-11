package com.unicolor.unicolorapi.mapper;

import com.unicolor.unicolorapi.dto.CarroDTO;
import com.unicolor.unicolorapi.entity.Carro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarroMapper {

    CarroMapper INSTANCE = Mappers.getMapper(CarroMapper.class);

    Carro toModel(CarroDTO carroDTO);

    CarroDTO toDTO(Carro carro);
}
