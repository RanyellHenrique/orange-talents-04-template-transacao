package br.com.zupedu.ranyell.transacao.compartilhado.excecoes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class TratamentoDeExcecoes {


    @ExceptionHandler(ApiExcecao.class)
    public ResponseEntity<ErroPadrao> erro(ApiExcecao e, HttpServletRequest request) {
        var status = e.getStatus();
        ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
