package br.com.wine.domain.aplicacaofinanceira.impl;

import br.com.wine.domain.aplicacaofinanceira.AplicacaoFinanceira;
import br.com.wine.domain.conta.Conta;

public abstract class AbstractAplicacaoFinanceira implements AplicacaoFinanceira {


    @Override
    public String getDescricao() {
        return null;
    }

    @Override
    public String getDescricaoRendimento() {
        return null;
    }

    public abstract double calculaRendimento(Conta conta);
}
