package br.com.zupedu.ranyell.transacao.mensageiro;

import br.com.zupedu.ranyell.transacao.transacao.Cartao;
import br.com.zupedu.ranyell.transacao.transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EventoDeEstabelecimento estabelecimento;
    private EventoDeCartao cartao;

    @Deprecated
    public EventoDeTransacao() {
    }

    public EventoDeTransacao(String id, BigDecimal valor, LocalDateTime efetivadaEm, EventoDeEstabelecimento estabelecimento, EventoDeCartao cartao) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public String getId() {
        return id;
    }

    public EventoDeCartao getCartao() {
        return cartao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EventoDeEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Transacao toModel(Cartao cartao) {
        return new Transacao(id, valor, efetivadaEm, estabelecimento.toModel(), cartao);
    }

}
