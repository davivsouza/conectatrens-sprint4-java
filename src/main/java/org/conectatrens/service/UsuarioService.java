package org.conectatrens.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

import org.conectatrens.entity.UsuarioEntity;
import org.conectatrens.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioService {

  @Inject
  UsuarioRepository usuarioRepository;

  public List<UsuarioEntity> listAll() {
    return usuarioRepository.findAll().list();
  }


  @Transactional
  public UsuarioEntity criarUsuario(UsuarioEntity usuario) {
    usuarioRepository.persist(usuario);
    return usuario;
  }

  public UsuarioEntity buscarPorId(Long id) {
    return usuarioRepository.findByIdOptional(id)
        .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
  }

  @Transactional
  public void atualizarUsuario(UsuarioEntity usuario) {
    usuarioRepository.persist(usuario);
  }

  @Transactional
  public void deletarUsuario(Long id) {
    usuarioRepository.deleteById(id);
  }

  public UsuarioEntity buscarPorEmail(String email) {
    return usuarioRepository.findByEmail(email);
  }
}