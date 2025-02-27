package br.com.zupedu.ranyell.transacao.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findFirst10ByCartaoIdOrderByEfetivadaEmDesc(String id);
}
