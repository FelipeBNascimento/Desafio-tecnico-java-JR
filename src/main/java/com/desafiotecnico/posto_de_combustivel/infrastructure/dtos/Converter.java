package com.desafiotecnico.posto_de_combustivel.infrastructure.dtos;

import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.requests.AbastecimentoCombustivelRequest;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.requests.BombaCombustivelRequest;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.requests.TipoCombustivelRequest;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses.AbastecimentoCombustivelResponse;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses.BombaCombustivelResponse;
import com.desafiotecnico.posto_de_combustivel.infrastructure.dtos.responses.TipoCombustivelResponse;
import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.AbastecimentoCombustivel;
import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.BombaCombustivel;
import com.desafiotecnico.posto_de_combustivel.infrastructure.entities.TipoCombustivel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//
@Component
public class Converter {

    //metodo para converter classe request para uma entity para manipular no banco de dados
    public TipoCombustivel paraTipoCombustivel(TipoCombustivelRequest request){

        TipoCombustivel combustivel = new TipoCombustivel();
        combustivel.setNome(request.getNome());
        combustivel.setPreco_litro(request.getPreco_litro());
        return combustivel;
    }

    // metodo para converter uma classeentity para uma response para visualização do cliente
    public TipoCombustivelResponse paraTipoCombustivelResponse(TipoCombustivel  entity){

        TipoCombustivelResponse combustivel = new TipoCombustivelResponse();
        combustivel.setId(entity.getId());
        combustivel.setNome(entity.getNome());
        combustivel.setPreco_litro(entity.getPreco_litro());
        return combustivel;
    }

    //metodo para converter classe request para uma entity para manipular no banco de dados
    public BombaCombustivel paraBombaCombustivel (BombaCombustivelRequest request){

        BombaCombustivel bombaCombustivel = new BombaCombustivel();
        bombaCombustivel.setNome(request.getNome());
        bombaCombustivel.setTipoCombustivel(request.getTipoCombustivel());
        return bombaCombustivel;

    }

    // metodo para converter uma classeentity para uma response para visualização do cliente
    public BombaCombustivelResponse paraBombaCombustivelResponse(BombaCombustivel entity){

        BombaCombustivelResponse bomba = new BombaCombustivelResponse();

        bomba.setId(entity.getId());
        bomba.setNome(entity.getNome());
        bomba.setTipoCombustivel(entity.getTipoCombustivel());
        return bomba;
    }

    //metodo para converter classe request para uma entity para manipular no banco de dados
    public AbastecimentoCombustivel paraAbastecimentoCombustivel(AbastecimentoCombustivelRequest request){

        AbastecimentoCombustivel abastecimento = new AbastecimentoCombustivel();

        abastecimento.setQuantidade_valores(request.getQuantidade_valores());
        abastecimento.setLitragem(request.getLitragem());
        abastecimento.setBombaCombustivel(request.getBombaCombustivel());

        return abastecimento;
    }

    // metodo para converter uma classeentity para uma response para visualização do cliente
    public AbastecimentoCombustivelResponse paraAbastecimentoCombustivelResponse (AbastecimentoCombustivel entity){

        AbastecimentoCombustivelResponse abastecimento = new AbastecimentoCombustivelResponse();

        abastecimento.setId(entity.getId());
        abastecimento.setQuantidade_valores(entity.getQuantidade_valores());
        abastecimento.setData(entity.getData());
        abastecimento.setLitragem(entity.getLitragem());
        abastecimento.setBombaCombustivel(entity.getBombaCombustivel());

        return abastecimento;
    }

    // metodo para converter uma listaentity para uma listaresponse para visualização do cliente
    public List<TipoCombustivelResponse> ListaTipoCombustivelResponse(List<TipoCombustivel> combustiveis) {

        List<TipoCombustivelResponse> combustivelResponses = new ArrayList<>();

        for (TipoCombustivel combustivel : combustiveis) {
            combustivelResponses.add(paraTipoCombustivelResponse(combustivel));
        }
        return combustivelResponses;

    }
}
