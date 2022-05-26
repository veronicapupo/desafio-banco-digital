package com.dio.projetobanco;

public class Main {
    public static void main(String[] args) {
        Cliente veronica = new Cliente();
        veronica.setNome("Veronica");
        Conta cc = new ContaCorrente(veronica);
        cc.depositar(100);
        Conta poupanca = new ContaPoupanca(veronica);
        cc.transferir(100, poupanca);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        cc.solicitarCartaoDeCredito(522);
        cc.visualizarCartaoDeCredito();
    }
}
