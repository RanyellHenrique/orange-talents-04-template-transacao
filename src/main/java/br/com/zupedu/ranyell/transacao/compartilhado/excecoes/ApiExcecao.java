package br.com.zupedu.ranyell.transacao.compartilhado.excecoes;

import org.springframework.http.HttpStatus;

public class ApiExcecao extends RuntimeException{

    private HttpStatus status;

    public ApiExcecao(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
