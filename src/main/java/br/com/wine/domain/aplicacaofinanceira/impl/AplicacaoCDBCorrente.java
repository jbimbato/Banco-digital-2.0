package br.com.wine.domain.aplicacaofinanceira.impl;

import br.com.wine.domain.conta.Conta;

public class AplicacaoCDBCorrente extends AbstractAplicacaoFinanceira {

    private final double taxaRendimento = 0.001;

    @Override
    public double calculaRendimento(Conta conta) {
        return conta.getSaldo() * taxaRendimento;
    }
}
