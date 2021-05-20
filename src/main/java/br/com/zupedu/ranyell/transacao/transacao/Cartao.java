package br.com.zupedu.ranyell.transacao.transacao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cartao")
public class Cartao {

    @Id
    private String id;
    @NotBlank @Email
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }
}
