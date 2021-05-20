package br.com.zupedu.ranyell.transacao.mensageiro;

import br.com.zupedu.ranyell.transacao.transacao.Cartao;

public class EventoDeCartao {

    private String id;
    private String email;

    @Deprecated
    public EventoDeCartao() {
    }

    public EventoDeCartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }
}
