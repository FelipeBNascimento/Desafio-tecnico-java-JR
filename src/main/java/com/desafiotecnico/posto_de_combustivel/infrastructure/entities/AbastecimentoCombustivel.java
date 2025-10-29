package com.desafiotecnico.posto_de_combustivel.infrastructure.entities;


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

//Essa anotação monstra para o spring que é uma tabela
@Entity

//Essa anotação cria o nome da tabela
@Table(name = "AbastecimentoCombustivel")

public class AbastecimentoCombustivel {

    //Essa anotação seria do id
    @Id
    // Essa anotação faz com que o id seja gerado automático em sequencia
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anotação para criar o nome da coluna
    @Column(name = "data")
    private LocalDate data;

    // Anotação para criar o nome da coluna
    @Column(name = "quantidade_valores")
    private Double quantidade_valores;

    // Anotação para criar o nome da coluna
    @Column(name = "litragem")
    private Double litragem;

    // Anotação para fazer a ligação das tabelas
    //A anotação OneToONe significa que um abastecimento por bomba
    @OneToOne
    @JoinColumn(name = "id_bomba")
    private BombaCombustivel bombaCombustivel;

}
