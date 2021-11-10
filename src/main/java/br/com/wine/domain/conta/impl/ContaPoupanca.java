package br.com.wine.domain.conta.impl;

import br.com.wine.domain.aplicacaofinanceira.AplicacaoFinanceira;
import br.com.wine.domain.aplicacaofinanceira.impl.AplicacaoPoupanca;
import br.com.wine.domain.cliente.Cliente;

public class ContaPoupanca extends AbstractConta{
	

    public ContaPoupanca(Cliente cliente){
        super(cliente);
        this.setAplicacaoFinanceira(getAplicacaoFinanceira());
    }


    @Override
    public void processaRendimentos() {
    	

    }
}
