package com.desafiotecnico.posto_de_combustivel.infrastructure.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// essa anotação mostra ao spring que é uma classe repositorio
@Repository
// Extende a classe JpaRepository para usar varios metodos implementados
public interface BombaCombustivel extends JpaRepository<BombaCombustivel, Long> {
}
