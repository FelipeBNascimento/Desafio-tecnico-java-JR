package com.desafiotecnico.posto_de_combustivel.business;

import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.Converter;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.requests.BombaCombustivelRequest;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses.BombaCombustivelResponse;
import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.BombaCombustivel;
import com.desafiotecnico.posto_de_combustivel.infrastructure.exceptions.IdNaoEncontrado;
import com.desafiotecnico.posto_de_combustivel.infrastructure.repositorios.BombaCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Anotação para mostrar ao spring que essa e uma classe service onde fica a regra de negocio
@Service
//Anotação usada para injeção de dependencia
@RequiredArgsConstructor
public class BombaCombustivelService {

    // classe injetadas
    private final BombaCombustivelRepository repository;
    private final Converter converter;

    // metodo para criar um objeto informando os atributos
    public void salvarBomba(BombaCombustivelRequest request) {

        // Esta convertendo a classe request para entity para pode salvar no banco de dados
        repository.save(converter.paraBombaCombustivel(request));
    }

    // metodo para visualizar a bomba de combustivel usando um id como parâmetro
    public BombaCombustivelResponse visualizarBombaPeloId(Long id) {

    // Buscando o objeto no banco de dados com id
        BombaCombustivel bombaNoBanco = repository.findById(id).orElseThrow(
                () -> new IdNaoEncontrado("Id não encontrado " + id)
        );

        // Esta convertendo o objeto entity para um response para visualização
        return converter.paraBombaCombustivelResponse(bombaNoBanco);
    }

    // Anotação que garante a integridade e a consistência dos dados
    @Transactional
    public void apagarBombaPeloId(Long id) {

        // metodo para deletar um objeto
        repository.deleteById(id);
    }

    // metodo para atualizar um objeto passando um id e o novo objeto atualizado
    public void atualizarBomba(BombaCombustivelRequest request, Long id) {

        // primeiro busca o objeto no banco para atualizar
        BombaCombustivel bombaBanco = repository.findById(id).orElseThrow(
                () -> new IdNaoEncontrado("Id não encontrado " + id)
        );

        // converte o objeto novo para uma entity para poder manipular no banco de dados
        BombaCombustivel bombaNova = converter.paraBombaCombustivel(request);

        //Passando novo objeto usando o builder
        BombaCombustivel bombaAtualizada = BombaCombustivel.builder()
                // sempre vai pegar o id do banco porque é uma atualzação
                .id(bombaBanco.getId())
                // Aqui usei um ternário porque caso não passe o atributo novo ele pegue o do banco sem deixar nulo
                .nome(bombaNova.getNome() != null ? bombaNova.getNome() : bombaBanco.getNome())
                // Aqui usei um ternário porque caso não passe o atributo novo ele pegue o do banco sem deixar nulo
                .tipoCombustivel(bombaNova.getTipoCombustivel() != null ? bombaNova.getTipoCombustivel() : bombaBanco.getTipoCombustivel())
                .build();

        // Salvando objeto no banco
        repository.save(bombaAtualizada);
    }
}
