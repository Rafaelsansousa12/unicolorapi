package com.unicolor.unicolorapi.service;

import com.unicolor.unicolorapi.dto.CorDTO;
import com.unicolor.unicolorapi.dto.response.MessageReponseDTO;
import com.unicolor.unicolorapi.entity.Cor;
import com.unicolor.unicolorapi.exception.NotFoundException;
import com.unicolor.unicolorapi.mapper.CorMapper;
import com.unicolor.unicolorapi.repository.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorService {

    private CorRepository corRepository;

    private final CorMapper corMapper = CorMapper.INSTANCE;

    @Autowired
    public CorService(CorRepository corRepository){
        this.corRepository = corRepository;
    }

    public MessageReponseDTO createColor(CorDTO corDTO){

        Cor colorToSave = corMapper.toModel(corDTO);
        Cor savedColor = corRepository.save(colorToSave);

        return getMessageReponseDTO(savedColor.getId(), "Created Cor with ID ");
    }

    public List<CorDTO> listAll() {
        List<Cor> colors = corRepository.findAll();
        return colors.stream().map(corMapper::toDTO).collect(Collectors.toList());
    }

    public CorDTO findById(Long id) throws NotFoundException {
        Cor color = verifyIfExists(id);

        return corMapper.toDTO(color);
    }

    public void deleteById(Long id) throws NotFoundException{

        verifyIfExists(id);
        corRepository.deleteById(id);
    }

    public MessageReponseDTO updateById(Long id, CorDTO colorDTO) throws NotFoundException {

        verifyIfExists(id);
        Cor colorToUpdate = corMapper.toModel(colorDTO);
        Cor updatedColor = corRepository.save(colorToUpdate);

        return getMessageReponseDTO(updatedColor.getId(), "Updated Cor with ID ");
    }

    private MessageReponseDTO getMessageReponseDTO(Long id, String message) {
        return MessageReponseDTO
                .builder()
                .message(message + id)
                .build();
    }


    private Cor verifyIfExists(Long id) throws NotFoundException {
        return corRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }
}
