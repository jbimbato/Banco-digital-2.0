package br.com.wine.controller;

import br.com.wine.domain.cliente.*;
import br.com.wine.domain.conta.*;


public interface BancoInterface {
	public Cliente cadastraCliente();
	public Conta criarConta();
	public Conta realizarAplicacao();
	public Conta sacar();
	public Conta depositar();
	public Conta transferir();
	public double consultaSaldo();
	
}
