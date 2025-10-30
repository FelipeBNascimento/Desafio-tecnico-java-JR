package com.desafiotecnico.posto_de_combustivel.controller;

import com.desafiotecnico.posto_de_combustivel.business.BombaCombustivelService;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.requests.BombaCombustivelRequest;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses.BombaCombustivelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Anotação para mostrar ao spring que essa e uma classe controller
@RestController

//Anotação usada para injeção de dependencia
@RequiredArgsConstructor

// Anotação para colocar o caminho da api URI
@RequestMapping("/bombacombustivel")
public class BombaCombustivelController {

    // classe injetadas
    private final BombaCombustivelService service;

    // Verbo POST para criação de objeto informado no corpo
    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody BombaCombustivelRequest request){

        service.salvarBomba(request);
        return ResponseEntity.ok().build();
    }

    // Verbo GET para visualização de um objeto usando id como paràmetro
    @GetMapping
    public ResponseEntity<BombaCombustivelResponse> visualizarBombaPeloId(@RequestParam Long id){

        return ResponseEntity.ok(service.visualizarBombaPeloId(id));
    }


    // Verbo PUT para atualização de um objeto usando id como parâmetro e no corpo passando o que quer atualizar
    @PutMapping
    public ResponseEntity<Void> atualizarBomba(@RequestParam Long id,
                                               @RequestBody BombaCombustivelRequest request){
        service.atualizarBomba(request, id);
        return ResponseEntity.ok().build();
    }

    // Verbo DELETE para deletar objeto deletando pelo id como parâmetro
    @DeleteMapping
    public ResponseEntity<Void> deletarBombaPeloId (@RequestParam Long id){

        service.apagarBombaPeloId(id);

        return ResponseEntity.ok().build();
    }
}
