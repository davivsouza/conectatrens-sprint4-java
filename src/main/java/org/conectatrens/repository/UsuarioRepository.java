package org.conectatrens.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.conectatrens.entity.UsuarioEntity;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<UsuarioEntity> {
    
    public UsuarioEntity findByEmail(String email) {
        return find("email", email).firstResult();
    }
}