import br.com.wine.domain.cliente.Cliente;
import br.com.wine.domain.conta.Conta;
import br.com.wine.domain.conta.impl.ContaPoupanca;
import br.com.wine.utils.ConsoleScanner;
import br.com.wine.*;
import br.com.wine.controller.Banco;

public class main{
    public static void main (String[] args){
        Banco itau = new Banco();
        String resposta = "1";
        //Menu da main
        
        while(!resposta.equals("0")) {
            System.out.println("Bem vindo ao Banco Itau!\n\nJ� � cliente?");
            resposta = ConsoleScanner.getConsoleInput("1.Sim\n2.N�o\n0.Fechar aplica��o\n\nDigite a op��o desejada:");
            String resposta2 = "0";
            if (resposta.equals("1") || !resposta2.equals("0")) {
            	resposta2 = ConsoleScanner.getConsoleInput("1.Consultar Saldo\n2.Sacar\n3.Depositar\n4.Transferir\n5.Criar nova conta"
            			+ "\n6.Realizar aplica��o em uma conta existente\n0.Voltar menu principal\n\nDigite a op��o desejada:");
            	if (resposta2.equals("1")) {
            		itau.consultaSaldo();
            	}
            	if (resposta2.equals("2")) {
            		itau.sacar();
            	}
            	if(resposta2.equals("3")) {
            		itau.depositar();
            	}
            	if(resposta2.equals("4")) {
            		itau.transferir();
            	}
            	if(resposta2.equals("5")) {
            		itau.criarConta();
            	}
            	if(resposta2.equals("6")) {
            		itau.realizarAplicacao();
            	}
            	
            }
            
            if(resposta.equals("2")) {
            	resposta2 = ConsoleScanner.getConsoleInput("Deseja se cadastrar no nosso banco?\n\n1.Sim\n2.N�o\n\nDigite a op��o desejada:");
            	if (resposta2.equals("1"))
            		itau.cadastraCliente();

//            	if (resposta2.equals("0"))
//            		resposta="0";
            }
        }
        
        
        //Podia pedir o documento aqui logo e a partir dai usar dentro dos meus metodos pra que o cliente n�o precisasse ficar digitando toda hora.
        //Porem meus metodos nao res
        //Seria at� tranquilo pra implementar mas tava pensando em seguir o bootcamp logo
        
        
        
//        Cliente cliente = Itau.cadastraCliente();
//        Itau.criarConta();
//        Itau.realizarAplicacao();
        
    }
}

