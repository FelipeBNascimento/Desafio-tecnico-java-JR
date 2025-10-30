package com.desafiotecnico.posto_de_combustivel.business;

import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.Converter;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.requests.TipoCombustivelRequest;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses.TipoCombustivelResponse;
import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.TipoCombustivel;
import com.desafiotecnico.posto_de_combustivel.infrastructure.exceptions.IdNaoEncontrado;
import com.desafiotecnico.posto_de_combustivel.infrastructure.repositorios.TipoCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Anotação para mostrar ao spring que essa e uma classe service onde fica a regra de negocio
@Service
//Anotação usada para injeção de dependencia
@RequiredArgsConstructor
public class TipoCombustivelService {

    // classe injetadas
    private final TipoCombustivelRepository repository;
    private final Converter converter;


    // metodo para criar um objeto informando os atributos
    public void criar(TipoCombustivelRequest combustivelRequest){

        // Esta convertendo a classe request para entity para pode salvar no banco de dados
        repository.save(converter.paraTipoCombustivel(combustivelRequest));
    }

    // metodo para visualizar uma lista de tipos de combustíveis
    public List<TipoCombustivelResponse> mostrarTiposCombustivel(){

        // Esta convertendo a lista entity para uma response para fazer a visualização
        return converter.ListaTipoCombustivelResponse(repository.findAll());
    }

    // Anotação que garante a integridade e a consistência dos dados
    @Transactional

    // metodo para deletar um objeto
    public void deletarTipoDeCombustivel (Long id){

        repository.deleteById(id);

    }

    // metodo para atualizar um objeto passando um id e o novo objeto atualizado
    public void atualizarTipoCombustivel(TipoCombustivelRequest request, Long id){

        // primeiro busca o objeto no banco para atualizar
       TipoCombustivel combustivelBanco = repository.findById(id).orElseThrow(
               () -> new IdNaoEncontrado("Id não encontrado " + id));

       // converte o objeto novo para uma entity para poder manipular no banco de dados
        TipoCombustivel tipoCombustivelNovo = converter.paraTipoCombustivel(request);

        //Passando novo objeto usando o builder
       TipoCombustivel combustivelAtualizado = TipoCombustivel.builder()

               // sempre vai pegar o id do banco porque é uma atualzação
               .id(combustivelBanco.getId())
               // Aqui usei um ternário porque caso não passe o atributo novo ele pegue o do banco sem deixar nulo
               .nome(tipoCombustivelNovo.getNome() != null ? tipoCombustivelNovo.getNome() : combustivelBanco.getNome())
               // Aqui usei um ternário porque caso não passe o atributo novo ele pegue o do banco sem deixar nulo
               .preco_litro(tipoCombustivelNovo.getPreco_litro() != null ? tipoCombustivelNovo.getPreco_litro() : combustivelBanco.getPreco_litro())
               .build();

       // salvando no banco objeto novo
       repository.save(combustivelAtualizado);

    }

}
