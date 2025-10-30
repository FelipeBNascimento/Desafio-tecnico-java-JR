package com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.requests;

import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.BombaCombustivel;
import lombok.*;

import java.time.LocalDate;

// Essa anotação cria automático os métodos getters para os atributos
@Getter
// Essa anotação cria automático os metodos setters para os atributos
@Setter
//Essa anotação cria construtores sem parâmetros
@NoArgsConstructor
//Essa anotação cria construtores com todos os parâmetros
@AllArgsConstructor
//Anotação Builder para usar nos metodos para atualizar
@Builder

// Classe request (DTO) usamos para não fazer a interação direto com banco
public class AbastecimentoCombustivelRequest {

    // Só atributos que o cliente passe
    private Double quantidade_valores;
    private Double litragem;
    private BombaCombustivel bombaCombustivel;
}
