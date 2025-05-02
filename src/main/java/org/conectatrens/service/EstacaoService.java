package org.conectatrens.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.conectatrens.entity.EstacaoEntity;
import org.conectatrens.repository.EstacaoRepository;

import java.util.List;

@ApplicationScoped
public class EstacaoService {

    @Inject
    EstacaoRepository estacaoRepository;

    public EstacaoEntity findById(Long id) {
        return estacaoRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Estação não encontrada"));
    }

    public List<EstacaoEntity> listAll() {
        return estacaoRepository.findAll().list();
    }

    public EstacaoEntity createEstacao(EstacaoEntity estacaoEntity) {
        estacaoRepository.persist(estacaoEntity);
        return estacaoEntity;
    }
}