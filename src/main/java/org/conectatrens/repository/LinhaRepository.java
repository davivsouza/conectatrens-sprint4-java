package org.conectatrens.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.conectatrens.entity.LinhaEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;



@ApplicationScoped
public class LinhaRepository implements PanacheRepository<LinhaEntity> {

}