package com.unicolor.unicolorapi.repository;

import com.unicolor.unicolorapi.entity.Carro;
import com.unicolor.unicolorapi.entity.Cor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
