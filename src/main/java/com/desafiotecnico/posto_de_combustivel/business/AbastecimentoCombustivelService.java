package com.desafiotecnico.posto_de_combustivel.business;

import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.Converter;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.requests.AbastecimentoCombustivelRequest;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses.AbastecimentoCombustivelResponse;
import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.AbastecimentoCombustivel;
import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.BombaCombustivel;
import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.TipoCombustivel;
import com.desafiotecnico.posto_de_combustivel.infrastructure.exceptions.IdNaoEncontrado;
import com.desafiotecnico.posto_de_combustivel.infrastructure.repositorios.AbastecimentoCombustivelRepository;
import com.desafiotecnico.posto_de_combustivel.infrastructure.repositorios.BombaCombustivelRepository;
import com.desafiotecnico.posto_de_combustivel.infrastructure.repositorios.TipoCombustivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

// Anotação para mostrar ao spring que essa e uma classe service onde fica a regra de negocio
@Service
//Anotação usada para injeção de dependencia
@RequiredArgsConstructor
public class AbastecimentoCombustivelService {

    // classe injetadas
    private final AbastecimentoCombustivelRepository repository;
    private final Converter converter;
    private final BombaCombustivelRepository bombaCombustivelRepository;

    // metodo para criação de um objeto usando como parametro o idBomba e a quantidade em litros
    public void criarAbastecimento (Long idBomba, double litros){

        // Buscando a bomba pelo id para
        BombaCombustivel bombaCombustivel = bombaCombustivelRepository.findById(idBomba).orElseThrow(
                ()-> new IdNaoEncontrado("Id não encontrado " + idBomba)
        );

        // valculando o valor total em dinheiro pelo valor do combustivel que foi buscado
        // pela bomba e a quantidade em litros passada no parametro
        double valorTotal = bombaCombustivel.getTipoCombustivel().getPreco_litro() * litros;

        // instanciando um novo obejeto
        AbastecimentoCombustivel abastecimentoCombustivel = new AbastecimentoCombustivel();

        // setando a litragem que é igual o paramentro em litros passado
        abastecimentoCombustivel.setLitragem(litros);
        // setando o valor total que foi obtido pela conta
        abastecimentoCombustivel.setQuantidade_valores(valorTotal);
        // setando a data que sempre será data do dia
        abastecimentoCombustivel.setData(LocalDate.now());
        // setando a bom que foi abastecida que é a mesma buscada pelo id
        abastecimentoCombustivel.setBombaCombustivel(bombaCombustivel);

        //Salvando o novo abastecimento no banco de dados
        repository.save(abastecimentoCombustivel);
    }

    // metodo para visualizar a bomba de combustivel usando um id como parâmetro
    public AbastecimentoCombustivelResponse visualizarAbastecimentoPorId(Long id){

        // Buscando o objeto no banco de dados com id
        AbastecimentoCombustivel abastecimentoCombustivel = repository.findById(id).orElseThrow(
                ()-> new IdNaoEncontrado("Id não encontrado " + id)
        );
        // Esta convertendo o objeto entity para um response para visualização
        return converter.paraAbastecimentoCombustivelResponse(abastecimentoCombustivel);
    }

}
