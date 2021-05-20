package br.com.zupedu.ranyell.transacao.transacao;

import br.com.zupedu.ranyell.transacao.estabelecimento.Estabelecimento;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String idTransacao;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private String nome;
    private String cidade;
    private String endereco;


    public TransacaoResponse(Transacao transacao) {
        this.idTransacao = transacao.getIdTransacao();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.nome = transacao.getEstabelecimento().getNome();
        this.cidade = transacao.getEstabelecimento().getCidade();
        this.endereco = transacao.getEstabelecimento().getEndereco();
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

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
