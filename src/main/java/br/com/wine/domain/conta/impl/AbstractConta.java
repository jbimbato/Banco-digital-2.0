package br.com.wine.domain.conta.impl;

import br.com.wine.domain.aplicacaofinanceira.AplicacaoFinanceira;
import br.com.wine.domain.cliente.Cliente;
import br.com.wine.domain.conta.Conta;

public abstract class AbstractConta implements Conta {

    private String numero;
    private double saldo;
    private Cliente cliente;
    private AplicacaoFinanceira aplicacaoFinanceira;

    public AbstractConta(Cliente cliente){
        this.numero = geraNovoNumero();
        this.saldo = 0;
        this.cliente = cliente;
    }

    private String geraNovoNumero(){
        String numeroConta = String.valueOf(Math.floor(Math.random() * 10001));
        return numeroConta;
    }

    @Override
    public String getNumero() {
        return this.numero;
    }

    @Override
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public Cliente getCliente() {
        return this.cliente;
    }

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public AplicacaoFinanceira getAplicacaoFinanceira() {
    	return this.aplicacaoFinanceira;
    };

    public void setAplicacaoFinanceira(AplicacaoFinanceira aplicacaoFinanceira) {
    	this.aplicacaoFinanceira = aplicacaoFinanceira;
    }

    public abstract void processaRendimentos();
}
