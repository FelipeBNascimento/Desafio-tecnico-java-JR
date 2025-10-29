package com.desafiotecnico.posto_de_combustivel.infrastructure.entities;

// Anotações do lombok

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Essa anotação cria automático os métodos getters para os atributos
@Getter
// Essa anotação cria automático os metodos setters para os atributos
@Setter
//Essa anotação cria construtores sem parâmetros
@NoArgsConstructor
//Essa anotação cria construtores com todos os parâmetros
@AllArgsConstructor

//Essa anotação monstra para o spring que é uma tabela
@Entity

//Essa anotação cria o nome da tabela
@Table(name = "bomba_combustivel")

public class BombaCombustivel {

    //Essa anotação seria do id
    @Id
    // Essa anotação faz com que o id seja gerado automático em sequencia
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anotação para criar o nome da coluna
    @Column(name = "nome")
    private String nome;

    // Anotação para fazer a ligação das tabelas
    //A anotação ManyToOne significa que varios tipos de combustivel na mesma bomba
    //exemplo gasolina, gasolina aditivada, etanol, diesel
    @ManyToOne
    @JoinColumn(name = "id_combustivel")
    private TipoCombustivel tipoCombustivel;
}
