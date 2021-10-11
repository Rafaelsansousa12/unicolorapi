package com.unicolor.unicolorapi.controller;

import com.unicolor.unicolorapi.dto.CorDTO;
import com.unicolor.unicolorapi.dto.response.MessageReponseDTO;
import com.unicolor.unicolorapi.exception.NotFoundException;
import com.unicolor.unicolorapi.service.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/color")
public class CorController {

    private CorService corService;

    @Autowired
    public CorController(CorService corService){
        this.corService = corService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageReponseDTO createCor(@RequestBody @Valid CorDTO corDTO){
        return corService.createColor(corDTO);
    }

    @GetMapping
    public List<CorDTO> listColor(){
        return corService.listAll();
    }

    @GetMapping("/{id}")
    public CorDTO getColorById(@PathVariable Long id) throws NotFoundException {
        return corService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws NotFoundException {
        corService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageReponseDTO updateColorById(@PathVariable Long id, @RequestBody @Valid CorDTO corDTO) throws NotFoundException {
        return corService.updateById(id, corDTO);
    }
}
