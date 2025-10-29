package com.desafiotecnico.posto_de_combustivel.infrastructure.repositorios;

import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.AbastecimentoCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// essa anotação mostra ao spring que é uma classe repositorio
@Repository

// Extende a classe JpaRepository para usar varios metodos implementados
public interface AbastecimentoCombustivelRepository extends JpaRepository<AbastecimentoCombustivel, Long> {
}
