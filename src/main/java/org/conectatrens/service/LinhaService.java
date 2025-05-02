package org.conectatrens.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.conectatrens.entity.LinhaEntity;
import org.conectatrens.repository.LinhaRepository;

import java.util.List;


@ApplicationScoped
public class LinhaService {

    @Inject
    LinhaRepository linhaRepository;

    public LinhaEntity findById(Long id) {
        return linhaRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    public List<LinhaEntity> listAll() {
        return linhaRepository.findAll().list();
    }


    @Transactional
    public LinhaEntity createLinha(LinhaEntity linhaEntity) {
        linhaRepository.persist(linhaEntity);
        return linhaEntity;
    }

}

