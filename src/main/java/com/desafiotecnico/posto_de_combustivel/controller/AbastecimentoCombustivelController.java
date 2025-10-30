package com.desafiotecnico.posto_de_combustivel.controller;

import com.desafiotecnico.posto_de_combustivel.business.AbastecimentoCombustivelService;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses.AbastecimentoCombustivelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Anotação para mostrar ao spring que essa e uma classe controller
@RestController

//Anotação usada para injeção de dependencia
@RequiredArgsConstructor

// Anotação para colocar o caminho da api URI
@RequestMapping("/abastecimentocombustivel")
public class AbastecimentoCombustivelController {

    // classe injetadas
    private final AbastecimentoCombustivelService service;

    // Verbo POST para criação de objeto passando dois parametros um id da bomba e outro a quantidade em litros
    @PostMapping
    public ResponseEntity<Void> abastecer(@RequestParam("idBomba") Long idBomba,
                                          @RequestParam("litros") double litros) {

        service.criarAbastecimento(idBomba, litros);

        return ResponseEntity.ok().build();

    }

    // Verbo GET para visualização de um objeto usando id como paràmetro
    @GetMapping
    public ResponseEntity<AbastecimentoCombustivelResponse> visualizarAbastecimento(@RequestParam long id) {

        return ResponseEntity.ok(service.visualizarAbastecimentoPorId(id));
    }


}
