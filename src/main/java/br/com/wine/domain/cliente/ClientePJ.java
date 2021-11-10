package br.com.wine.domain.cliente;

import java.util.ArrayList;

import br.com.wine.domain.conta.Conta;

public class ClientePJ extends AbstractCliente {
	
	private String nome;
	private String documento;
	private ArrayList<Conta> contas = new ArrayList();
	private String opt;
	
	@Override
	public String getDocumento() {
		return this.documento;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public ArrayList<Conta> getContas() {
		return this.contas;
	}

	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumento(String documento) {
		// TODO Auto-generated method stub
		
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

}
