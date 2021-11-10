package br.com.wine.domain.cliente;

import java.util.ArrayList;

import br.com.wine.domain.conta.Conta;

public interface Cliente {
	public String getOpt();
	public void setOpt(String opt);
	public String getNome();
	public String getDocumento();
	public ArrayList<Conta> getContas();
	public void setNome(String nome);
	public void setDocumento(String documento);
	//Acho que não precisa, basta dar um .add
	//public void setContas(Conta conta);
	
}
