package com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses;

import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.BombaCombustivel;
import jakarta.persistence.*;
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

// Classe para fazer response (DTO) usamos para fazer a interação com banco sem usar a entities
public class AbastecimentoCombustivelResponse {

    private Long id;
    private LocalDate data;
    private Double quantidade_valores;
    private Double litragem;
    private BombaCombustivel bombaCombustivel;
}
