package br.com.wine.domain.cliente;

import java.util.Scanner;

public abstract class AbstractCliente implements Cliente {

//	@Override
	
	public Cliente cadastrarCliente() {
		System.out.println("O cliente é:\n\n1.Pessoa Física\n2.Pessoa Jurídica.\n\nDigite sua escolha:");
		Scanner ler = new Scanner(System.in);
		String resposta = ler.nextLine();
		if(resposta=="1") {
			System.out.println("Você escolheu pessoa física. Digite o CPF:");
		}
		return null;
	}
	
	public String getDocumento() {
		return null;
	}

}
