package br.com.wine.domain.cliente;

import java.util.ArrayList;

import br.com.wine.domain.conta.Conta;

public class ClientePF extends AbstractCliente {
	
	private String nome;
	private String documento;
	private ArrayList<Conta> contas = new ArrayList();
	private String opt;
		
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

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

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

}
