package com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses;

import jakarta.persistence.Column;
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

// Classe response (DTO) usamos para não fazer a interação direto com banco
public class TipoCombustivelResponse {

    // Atributo somente para visualização
    private Long id;
    private String nome;
    private Double preco_litro;

}
