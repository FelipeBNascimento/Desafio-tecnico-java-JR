package com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.requests;

import lombok.*;

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

// Classe para fazer request (DTO) usamos para fazer a interação com banco sem usar a entities
public class TipoCombustivelRequest {

    private String nome;
    private Double preco_litro;

}
