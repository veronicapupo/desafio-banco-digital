package com.dio.projetobanco;

import lombok.ToString;

import java.util.Random;

@ToString
public class CartaoDeCredito {
    private double valorDoLimite;
    private int agencia;
    private int conta;
    private String nomeCliente;
    private String numeroDoCartao;

    public CartaoDeCredito(double valorDoLimite, int agencia, int conta, Cliente cliente) {
        this.valorDoLimite = valorDoLimite;
        this.agencia = agencia;
        this.conta = conta;
        this.nomeCliente = cliente.getNome();
        geraNumeroDoCartao();
    }

    private void geraNumeroDoCartao() {
        int digito = 0;
        Random rnd = new Random();
        numeroDoCartao ="";
        for (int i = 0; i < 16; i++) {
            digito = rnd.nextInt(9);
            this.numeroDoCartao += digito;
        }
    }
}
