package br.com.zupedu.ranyell.transacao.mensageiro;

import br.com.zupedu.ranyell.transacao.cartao.Cartao;
import br.com.zupedu.ranyell.transacao.cartao.CartaoRepository;
import br.com.zupedu.ranyell.transacao.transacao.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private TransacaoRepository transacaoRepository;
    private CartaoRepository cartaoRepository;

    @Autowired
    public ListenerDeTransacao(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @KafkaListener(topics = "${topic.kafka.name}")
    void ouvir(EventoDeTransacao evento) {
        Cartao cartao;
        if(cartaoRepository.existsById(evento.getCartao().getId())) {
            cartao = cartaoRepository.getOne(evento.getCartao().getId());
        } else {
            cartao = cartaoRepository.save(evento.getCartao().toModel());
        }
        transacaoRepository.save(evento.toModel(cartao));
        logger.info("Transacao id = {} e  cartao = {} efetudada", evento.getId(), evento.getCartao().getId());
    }
}
