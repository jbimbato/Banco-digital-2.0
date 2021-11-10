package br.com.wine.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.wine.domain.aplicacaofinanceira.AplicacaoFinanceira;
import br.com.wine.domain.aplicacaofinanceira.impl.AplicacaoCDBCorrente;
import br.com.wine.domain.aplicacaofinanceira.impl.AplicacaoPoupanca;
import br.com.wine.domain.cliente.*;
import br.com.wine.domain.conta.*;
import br.com.wine.domain.conta.impl.ContaCorrente;
import br.com.wine.domain.conta.impl.ContaPoupanca;
import br.com.wine.utils.ConsoleScanner;

public class Banco implements BancoInterface{
	
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	private static List<Conta> contas = new ArrayList<Conta>();

	//Metodos
	public Cliente cadastraCliente() {
		String resposta="1";
		
		//Inicio menu cadastra clientes
			resposta = ConsoleScanner.getConsoleInput("CADASTRO DE CLIENTES\n\nEscolha a opção:\n\n1.Pessoa Física\n2.Pessoa Jurídica.\n0.Cancela tudo\n\nDigite sua escolha:");
			
			//cliente PF
			if(resposta.equals("1")) {
				Cliente cliente = cadastraClientePF();
				this.getClientes().add(cliente);
				System.out.println("Cliente criado com sucesso\n");
			}
			
			//Cliente PJ
			else if(resposta.equals("2")) {
				
				return cadastraClientePJ();
			}
			//Se responder 0 no primeiro menu retorna nulo e termina metodo
			else if(resposta.equals("0")) {
				return null;
			}
		
		return null;
	}

	private Cliente cadastraClientePF() {
		
		//Pega CPF
		String cpf = ConsoleScanner.getConsoleInput("Digite o CPF ou 0 pra cancelar:");
		if(cpf.equals("0")) {
			return null;
		}
		
		//Checa se ja tem um CPF igual
		if(findClienteByDocumento(cpf)!=null) {
			System.out.println("Esse CPF já está cadastrado no sistema. Voltando ao menu anterior\n");
			return null;
		}
		
		//Pega nome
		String nome = ConsoleScanner.getConsoleInput("Digite o nome ou 0 pra cancelar:");
		if (nome.equals("0")) {
			return null;
		} 
		
		//Tudo ok? Blz, cria cliente
		Cliente cliente = new ClientePF();
		cliente.setNome(nome);
		cliente.setDocumento(cpf);
		

		return cliente;
	}
	
	private Cliente cadastraClientePJ(){
		//Pega CPF
		String cnpj = ConsoleScanner.getConsoleInput("Digite o CNPJ ou 0 pra cancelar:");
		if(cnpj.equals("0")) {
			return null;
		}
		
		//Checa se ja tem igual
		if(findClienteByDocumento(cnpj)!=null) {
			System.out.println("Esse CNPJ já está cadastrado no sistema. Voltando ao menu anterior\n");
			return null;
		}

		//Pega nome
		String nome = ConsoleScanner.getConsoleInput("Digite o nome ou 0 pra cancelar:");
		if (nome.equals("0")) {
			return null;
		} 
		
		//Tudo ok? Blz, cria cliente PJ
		Cliente cliente = new ClientePJ();
		cliente.setNome(nome);
		cliente.setDocumento(cnpj);
		
		return cliente;
	}
	
	public Conta criarConta() {

		String resposta = ConsoleScanner.getConsoleInput("CRIAÇÃO DE CONTA\n\nEscolha a opção:\n\n1.Conta poupança\n2.Conta Corrente.\n0.Cancela tudo\n\nDigite sua escolha:");
		if (resposta.equals("0")) {
			return null;
		}
		
		String doc = ConsoleScanner.getConsoleInput("Digite seu documento ou 0 pra cancelar:");
		if(findClienteByDocumento(doc)!=null) {
			if(resposta.equals("1")) {
				Conta conta = new ContaPoupanca(findClienteByDocumento(doc));
				findClienteByDocumento(doc).getContas().add(conta);
				contas.add(conta);
				System.out.println("Aí sim," +findClienteByDocumento(doc).getNome()+"! Conta criada com sucesso!");
			}
			
			//Conta corrente
			else if(resposta.equals("2")) {
				Conta conta = new ContaCorrente(findClienteByDocumento(doc));
				findClienteByDocumento(doc).getContas().add(conta);
				contas.add(conta);
				System.out.println("Aí sim," +findClienteByDocumento(doc).getNome()+"! Conta criada com sucesso!");					
			}
		}
		

		return null;	
	}

	public Conta realizarAplicacao() {
		
		//Metodo adiciona uma aplicação financeira em uma conta
		String doc = ConsoleScanner.getConsoleInput("REALIZAR APLICAÇÃO FINANCEIRA EM UMA DE SUAS CONTAS\n\nDigite seu nº de documento ou 0 pra sair:");

		Cliente clienteTemp = listaContasPorDocumentoCliente(doc);
		
		String opcaoConta = ConsoleScanner.getConsoleInput("0. Voltar menu anterior\n\nDigite a opção desejada:");
				
		if(Integer.valueOf(opcaoConta) > Integer.valueOf(clienteTemp.getContas().size())) {
			System.out.println("Valor digitado não corresponde com as opções fornecidas. Tente novamente.");
			return null;
		}
		if(opcaoConta.equals("0")) {
				System.out.println("Voltando ao menu principal");
			return null;		
		}
				
		String opcaoRendimento = ConsoleScanner.getConsoleInput("Deseja aplicar que tipo de aplicação à conta "
				+clienteTemp.getContas().get(Integer.valueOf(opcaoConta)-1).getNumero()+ "?\n"
				+ "1. CBD\n2.Rendimento like poupança\n0.Pra voltar ao menu anterior.\n\n"
				+ "Digite a opção desejada:");
			
		if(opcaoRendimento.equals("1")){
			AplicacaoFinanceira aplicacaoCBD = new AplicacaoCDBCorrente();
			findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1).setAplicacaoFinanceira(aplicacaoCBD);
			System.out.println("Essa conta está configurada pra aplicacao CBD");
			return findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1);
		}
		if(opcaoRendimento.equals("2")) {
			AplicacaoFinanceira aplicacaoPoupanca = new AplicacaoPoupanca();
			findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1).setAplicacaoFinanceira(aplicacaoPoupanca);
			System.out.println("Essa conta está configurada pra aplicacao poupança");
			return findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1);
		}
		if(opcaoRendimento.equals("0")) {
			System.out.println("Voltando ao menu principal");
			return null;
		}
		
		return null;
	}
	
	public Conta sacar() {
		String doc = ConsoleScanner.getConsoleInput("REALIZA SAQUE\n\nDigite o numero do seu documento:");
		Cliente clienteTemp = listaContasPorDocumentoCliente(doc);
		
		
		if (clienteTemp==null || clienteTemp.getOpt()=="0") {
			return null;
		}
		
		if(clienteTemp!=null) {
			String opcaoConta = clienteTemp.getOpt();
			Double valorSacar = Double.valueOf(ConsoleScanner.getConsoleInput("Digite o valor que deseja sacar:"));
			
			if(valorSacar > clienteTemp.getContas().get(Integer.valueOf(opcaoConta)-1).getSaldo()) {
				System.out.println("Não tem saldo suficiente. Voltando ao menu principal (aproveita e consulta seu saldo rs)");
				return null;
			}
			findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1).setSaldo(clienteTemp.getContas().get(Integer.valueOf(opcaoConta)-1).getSaldo()-valorSacar);
			System.out.println("Saque realizado com sucesso. Seu saldo atual é:\n"+findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1).getSaldo()+"\n");
			return findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1);
		} 
		return null;
	}

	@Override
	public Conta transferir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double consultaSaldo() {
		String doc = ConsoleScanner.getConsoleInput("Digite seu documento:");
		Cliente clienteTemp = listaContasPorDocumentoCliente(doc);

		
		if(clienteTemp==null || clienteTemp.getOpt()=="0") {
			System.out.println("Cliente não encontrado. Voltando ao menu anterior");
			return 0;
		}
		else if(clienteTemp!=null) {
			String opcaoConta = clienteTemp.getOpt();
			System.out.println("Seu saldo atual é:\n\n"+findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1).getSaldo()+"\n");
			return findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1).getSaldo();
		}
		
		return 0;
	}

	@Override
	public Conta depositar() {
		String doc = ConsoleScanner.getConsoleInput("Digite seu documento:");
		Cliente clienteTemp = listaContasPorDocumentoCliente(doc);
		
		
		if (clienteTemp==null || clienteTemp.getOpt()=="0") {
			return null;
		}
		
		if(clienteTemp!=null) {
			String opcaoConta = clienteTemp.getOpt();
			Double valorDepositar = Double.valueOf(ConsoleScanner.getConsoleInput("Digite o valor que deseja depositar:"));
			findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1).setSaldo(clienteTemp.getContas().get(Integer.valueOf(opcaoConta)-1).getSaldo()+valorDepositar);
			System.out.println("Deposito realizado com sucesso. Seu saldo atual é:\n"+findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1).getSaldo()+"\n");
			return findClienteByDocumento(doc).getContas().get(Integer.valueOf(opcaoConta)-1);
		} 
		
		return null;
	}
	
	//Utilidades
	private Cliente findClienteByDocumento(String documento) {

		for(int i=0; i < this.getClientes().size(); i++) {
			if (this.getClientes().get(i).getDocumento().equals(documento)) {
				return this.getClientes().get(i);
			}
		}
		return null;
	}

	private Cliente listaContasPorDocumentoCliente(String doc) {
		Cliente clienteTemp = findClienteByDocumento(doc);
		System.out.println("Deseja aplicar a qual das suas contas?\n");
				
		//For so pra escrever todas contas bonitim
		if (clienteTemp!=null) {	
			for(int n=0; n<clienteTemp.getContas().size(); n++) {
				System.out.println(+(n+1)+"."+clienteTemp.getContas().get(n).getNumero());
			}
			
			String opcaoConta = ConsoleScanner.getConsoleInput("0. Voltar menu principal\n\nDigite a opção desejada:");
			clienteTemp.setOpt(opcaoConta);
			
			if(Integer.valueOf(opcaoConta) > Integer.valueOf(clienteTemp.getContas().size())) {
				System.out.println("Valor digitado não corresponde com as opções fornecidas. Voltando ao menu principal.");
				return null;
			}
			if(opcaoConta.equals("0")) {
					System.out.println("Voltando ao menu principal");
				return null;		
			}
			return clienteTemp;
		} 
		
		else return null;
	}
	
	
	//Getters and setters
	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Conta> getContas() {
		return contas;
	}


}
