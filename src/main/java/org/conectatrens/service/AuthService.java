package org.conectatrens.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.conectatrens.entity.UsuarioEntity;
import org.conectatrens.repository.UsuarioRepository;

@ApplicationScoped
public class AuthService {

  @Inject
  UsuarioRepository usuarioRepository;

  public boolean validarLogin(String email, String senha) {
    UsuarioEntity usuario = usuarioRepository.findByEmail(email);

    if (!usuario.email.equals(email) || !usuario.senha.equals(senha)) {
      return false;
    }

    if (usuario.senha.equals(senha) && usuario.email.equals(email)) {
      return true;
    }
    return false;

  }

}
