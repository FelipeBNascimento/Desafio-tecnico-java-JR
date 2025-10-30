package com.desafiotecnico.posto_de_combustivel.infrastructure.exceptions;

// classe criada extendo a RuntimeException para fazer tratamento de erro
public class IdNaoEncontrado extends RuntimeException{
    public IdNaoEncontrado(String message) {
        super(message);
    }

    public IdNaoEncontrado(String message, Throwable cause) {
        super(message, cause);
    }
}
