package br.com.wine.domain.aplicacaofinanceira;

import br.com.wine.domain.conta.Conta;

public interface AplicacaoFinanceira {

    String getDescricao();
    String getDescricaoRendimento();
    double calculaRendimento(Conta conta);

}
