package com.dio.projetobanco;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;
    protected CartaoDeCredito cartaoDeCredito;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;

    }

    @Override
    public void solicitarCartaoDeCredito(double valorDoLimite) {
        System.out.println("===CARTAO DE CREDITO===");
        cartaoDeCredito = new CartaoDeCredito(valorDoLimite, agencia, conta, cliente);
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfrosComum() {
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.conta));
        System.out.println(String.format("Saldo %2f ", this.saldo));
        System.out.println(String.format("Titular: %s ", this.cliente.getNome()));

    }

    public void visualizarCartaoDeCredito() {
        System.out.println(cartaoDeCredito);
    }
}