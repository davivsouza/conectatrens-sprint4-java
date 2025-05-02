package org.conectatrens.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.conectatrens.entity.EstacaoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EstacaoRepository implements PanacheRepository<EstacaoEntity> {
}