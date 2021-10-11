package com.unicolor.unicolorapi.service;

import com.unicolor.unicolorapi.dto.CarroDTO;
import com.unicolor.unicolorapi.dto.response.MessageReponseDTO;
import com.unicolor.unicolorapi.entity.Carro;
import com.unicolor.unicolorapi.exception.NotFoundException;
import com.unicolor.unicolorapi.mapper.CarroMapper;
import com.unicolor.unicolorapi.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    private CarroRepository carroRepository;

    private final CarroMapper carroMapper = CarroMapper.INSTANCE;

    @Autowired
    public CarroService(CarroRepository carroRepository){
        this.carroRepository = carroRepository;
    }

    public MessageReponseDTO createColor(CarroDTO carroDTO){

        Carro carToSave = carroMapper.toModel(carroDTO);
        Carro savedCar = carroRepository.save(carToSave);

        return getMessageReponseDTO(savedCar.getId(), "Created Carro with ID ");
    }

    public List<CarroDTO> listAll() {
        List<Carro> cars = carroRepository.findAll();
        return cars.stream().map(carroMapper::toDTO).collect(Collectors.toList());
    }

    public CarroDTO findById(Long id) throws NotFoundException {
        Carro car = verifyIfExists(id);

        return carroMapper.toDTO(car);
    }

    public void deleteById(Long id) throws NotFoundException{

        verifyIfExists(id);
        carroRepository.deleteById(id);
    }

    public MessageReponseDTO updateById(Long id, CarroDTO carroDTO) throws NotFoundException {

        verifyIfExists(id);
        Carro carToUpdate = carroMapper.toModel(carroDTO);
        Carro updatedCar = carroRepository.save(carToUpdate);

        return getMessageReponseDTO(updatedCar.getId(), "Updated Carro with ID ");
    }

    private MessageReponseDTO getMessageReponseDTO(Long id, String message) {
        return MessageReponseDTO
                .builder()
                .message(message + id)
                .build();
    }


    private Carro verifyIfExists(Long id) throws NotFoundException {
        return carroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }
}
