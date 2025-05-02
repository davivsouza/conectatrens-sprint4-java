package org.conectatrens.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.conectatrens.entity.ReclamacaoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ReclamacaoRepository implements PanacheRepository<ReclamacaoEntity> {
}