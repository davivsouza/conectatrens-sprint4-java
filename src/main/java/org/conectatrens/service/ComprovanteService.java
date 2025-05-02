package org.conectatrens.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.conectatrens.entity.ComprovanteEntity;
import org.conectatrens.repository.ComprovanteRepository;

import java.util.List;

@ApplicationScoped
public class ComprovanteService {

    @Inject
    ComprovanteRepository comprovanteRepository;

    public ComprovanteEntity findById(Long id) {
        return comprovanteRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Comprovante não encontrado"));
    }

    public List<ComprovanteEntity> listAll() {
        return comprovanteRepository.findAll().list();
    }

    public ComprovanteEntity createComprovante(ComprovanteEntity comprovanteEntity) {
        comprovanteRepository.persist(comprovanteEntity);
        return comprovanteEntity;
    }
}