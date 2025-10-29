package com.desafiotecnico.posto_de_combustivel.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

// Anotações do lombok

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

//Essa anotação monstra para o spring que é uma tabela
@Entity

//Essa anotação cria o nome da tabela
@Table(name = "tipo_combustivel")

public class TipoCombustivel {

    //Essa anotação seria do id
    @Id
    // Essa anotação faz com que o id seja gerado automático em sequencia
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anotação para criar o nome da coluna
    @Column(name = "nome")
    private String nome;

    // Anotação para criar o nome da coluna
    @Column(name = "preco_litro")
    private Double preco_litro;

}
