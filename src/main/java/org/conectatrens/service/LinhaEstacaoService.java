package org.conectatrens.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.conectatrens.entity.LinhaEstacaoEntity;
import org.conectatrens.repository.LinhaEstacaoRepository;

import java.util.List;

@ApplicationScoped
public class LinhaEstacaoService {

    @Inject
    LinhaEstacaoRepository linhaEstacaoRepository;

    public LinhaEstacaoEntity findById(Long id) {
        return linhaEstacaoRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Relação Linha-Estação não encontrada"));
    }

    public List<LinhaEstacaoEntity> listAll() {
        return linhaEstacaoRepository.findAll().list();
    }

    public LinhaEstacaoEntity createLinhaEstacao(LinhaEstacaoEntity linhaEstacaoEntity) {
        linhaEstacaoRepository.persist(linhaEstacaoEntity);
        return linhaEstacaoEntity;
    }
}