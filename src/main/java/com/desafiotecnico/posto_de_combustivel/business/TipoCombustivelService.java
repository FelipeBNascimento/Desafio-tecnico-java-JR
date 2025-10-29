package com.desafiotecnico.posto_de_combustivel.business;

import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.TipoCombustivel;
import com.desafiotecnico.posto_de_combustivel.infrastructure.repositorios.TipoCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoCombustivelService {

    private final TipoCombustivelRepository tipoCombustivelRepository;

    public void criar(TipoCombustivel combustivel){

        tipoCombustivelRepository.save(combustivel);
    }

    public List<TipoCombustivel> mostrarTiposCombustivel(){

        return tipoCombustivelRepository.findAll();
    }

    @Transactional
    public void deletarTipoDeCombustivel (Long id){

        tipoCombustivelRepository.deleteById(id);

    }


}
