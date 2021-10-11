package com.unicolor.unicolorapi.controller;

import com.unicolor.unicolorapi.dto.CarroDTO;
import com.unicolor.unicolorapi.dto.response.MessageReponseDTO;
import com.unicolor.unicolorapi.exception.NotFoundException;
import com.unicolor.unicolorapi.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarroController {

    private CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService){
        this.carroService = carroService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageReponseDTO createCarro(@RequestBody @Valid CarroDTO carroDTO){
        return carroService.createColor(carroDTO);
    }

    @GetMapping
    public List<CarroDTO> listColor(){
        return carroService.listAll();
    }

    @GetMapping("/{id}")
    public CarroDTO getColorById(@PathVariable Long id) throws NotFoundException {
        return carroService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws NotFoundException {
        carroService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageReponseDTO updateColorById(@PathVariable Long id, @RequestBody @Valid CarroDTO carroDTO) throws NotFoundException {
        return carroService.updateById(id, carroDTO);
    }
}
