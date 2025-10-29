package com.desafiotecnico.posto_de_combustivel.business;

import com.desafiotecnico.posto_de_combustivel.infrastructure.repositorios.AbastecimentoCombustivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AbastecimentoCombustivelService {

    private final AbastecimentoCombustivelRepository abastecimentoCombustivelRepository;

}
