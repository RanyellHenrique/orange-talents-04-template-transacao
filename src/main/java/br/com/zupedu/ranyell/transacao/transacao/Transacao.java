package br.com.zupedu.ranyell.transacao.transacao;

import br.com.zupedu.ranyell.transacao.cartao.Cartao;
import br.com.zupedu.ranyell.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idTransacao;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;

    @Embedded
    private Estabelecimento estabelecimento;

    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String idTransacao, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento, Cartao cartao) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
