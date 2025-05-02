package org.conectatrens.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.conectatrens.entity.LinhaEstacaoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class LinhaEstacaoRepository implements PanacheRepository<LinhaEstacaoEntity> {
}