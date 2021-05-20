package br.com.zupedu.ranyell.transacao.transacao;

import br.com.zupedu.ranyell.transacao.cartao.CartaoRepository;
import br.com.zupedu.ranyell.transacao.compartilhado.excecoes.ApiExcecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/cartoes")
public class TransacaoController {

    private CartaoRepository cartaoRepository;
    private TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoController(CartaoRepository cartaoRepository, TransacaoRepository transacaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("{id}/transacoes")
    public ResponseEntity<List<TransacaoResponse>> buscarTransacoes(@PathVariable String id) {
        if(!cartaoRepository.existsById(id)) {
            throw new ApiExcecao("Cartão não encontrado", HttpStatus.NOT_FOUND);
        }
        var transacoes = transacaoRepository.findFirst10ByCartaoIdOrderByEfetivadaEmDesc(id);
        var transacoesResponse = transacoes.stream().map(t -> new TransacaoResponse(t)).collect(Collectors.toList());
        return ResponseEntity.ok(transacoesResponse);
    }
}
