package br.com.wine.domain.cliente;

import java.util.Scanner;

public abstract class AbstractCliente implements Cliente {

//	@Override
	
	public Cliente cadastrarCliente() {
		System.out.println("O cliente �:\n\n1.Pessoa F�sica\n2.Pessoa Jur�dica.\n\nDigite sua escolha:");
		Scanner ler = new Scanner(System.in);
		String resposta = ler.nextLine();
		if(resposta=="1") {
			System.out.println("Voc� escolheu pessoa f�sica. Digite o CPF:");
		}
		return null;
	}
	
	public String getDocumento() {
		return null;
	}

}
