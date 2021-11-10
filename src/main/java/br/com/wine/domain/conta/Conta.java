package br.com.wine.domain.conta;

import br.com.wine.domain.aplicacaofinanceira.AplicacaoFinanceira;
import br.com.wine.domain.cliente.Cliente;

public interface Conta {

    String getNumero();
    void setNumero(String numero);
    double getSaldo();
    void setSaldo(double saldo);
    Cliente getCliente();
    void setCliente(Cliente cliente);
    AplicacaoFinanceira getAplicacaoFinanceira();
    void setAplicacaoFinanceira(AplicacaoFinanceira aplicacaoFinanceira);
    void processaRendimentos();

}
