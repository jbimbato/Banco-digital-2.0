package br.com.wine.domain.aplicacaofinanceira.impl;

import br.com.wine.domain.aplicacaofinanceira.AplicacaoFinanceira;
import br.com.wine.domain.conta.Conta;

public class AplicacaoPoupanca extends AbstractAplicacaoFinanceira implements AplicacaoFinanceira {

    private final double taxaRendimento = 0.005;
    private final String descricao = ("Aplicacao do tipo poupan�a com rendimento de " +taxaRendimento+ " ao m�s");
    private Double descricaoRendimento;
    
    @Override
    public double calculaRendimento(Conta conta) {
        return conta.getSaldo() * taxaRendimento;
    }
}
