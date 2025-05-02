package org.conectatrens.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.conectatrens.entity.ComprovanteEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ComprovanteRepository implements PanacheRepository<ComprovanteEntity> {
}