package com.desafiotecnico.posto_de_combustivel.controller;

import com.desafiotecnico.posto_de_combustivel.business.TipoCombustivelService;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.requests.TipoCombustivelRequest;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses.TipoCombustivelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Anotação para mostrar ao spring que essa e uma classe controller
@RestController

//Anotação usada para injeção de dependencia
@RequiredArgsConstructor

// Anotação para colocar o caminho da api URI
@RequestMapping("/combustivel")
public class TipoCombustivelController {

    // classe injetadas
    private final TipoCombustivelService service;

    // Verbo POST para criação de objeto informado no corpo
    @PostMapping
    public ResponseEntity<Void> criar (@RequestBody TipoCombustivelRequest request){

        service.criar(request);

        return ResponseEntity.ok().build();
    }

    // Verbo GET para visualização de uma lista de objetos
    @GetMapping
    public ResponseEntity<List<TipoCombustivelResponse>> visualizarListaDeCombustiveis(){

        return ResponseEntity.ok(service.mostrarTiposCombustivel());
    }

    // Verbo DELETE para deletar objeto deletando pelo id como parâmetro
    @DeleteMapping
    public ResponseEntity<Void> deletarTipoCombustivel(@RequestParam Long id){

        service.deletarTipoDeCombustivel(id);

        return ResponseEntity.ok().build();
    }

    // Verbo PUT para atualização de um objeto usando id como parâmetro e no corpo passando o que quer atualizar
    @PutMapping
    public ResponseEntity<Void> atualizarTipoCombustivel(@RequestParam Long id,
                                                         @RequestBody TipoCombustivelRequest request){
        service.atualizarTipoCombustivel(request,id);

        return ResponseEntity.ok().build();
    }

}
