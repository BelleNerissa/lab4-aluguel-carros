package com.mycompany.alugueis;

public class AluguelNotFoundException extends Throwable {
    public AluguelNotFoundException(String message) {
        super(message);
    }
}