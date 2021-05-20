package br.com.zupedu.ranyell.transacao.mensageiro;

import br.com.zupedu.ranyell.transacao.transacao.Estabelecimento;

public class EventoDeEstabelecimento {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EventoDeEstabelecimento() {
    }

    public EventoDeEstabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
