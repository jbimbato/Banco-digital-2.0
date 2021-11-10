package br.com.wine.domain.conta.impl;

import br.com.wine.domain.aplicacaofinanceira.AplicacaoFinanceira;
import br.com.wine.domain.cliente.Cliente;

public class ContaCorrente extends AbstractConta{

    public ContaCorrente(Cliente cliente){
        super(cliente);
        this.setAplicacaoFinanceira(getAplicacaoFinanceira());
    }
    
	@Override
	public AplicacaoFinanceira getAplicacaoFinanceira() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAplicacaoFinanceira(AplicacaoFinanceira aplicacaoFinanceira) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processaRendimentos() {
		// TODO Auto-generated method stub
		
	}
	
}
