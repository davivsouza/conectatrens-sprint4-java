package org.conectatrens.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.conectatrens.entity.UsuarioEntity;
import org.conectatrens.service.UsuarioService;

import java.util.List;

@Path("/api/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {

  @Inject
  UsuarioService usuarioService;

  @GET
  public List<UsuarioEntity> listarTodos() {
    return usuarioService.listAll();
  }

  @POST
  @Transactional
  public Response criarUsuario(UsuarioEntity usuario) {
    try {
      return Response.ok(usuarioService.criarUsuario(usuario)).build();
    } catch (Exception e) {
      return Response.status(Response.Status.BAD_REQUEST)
          .entity("Erro ao criar usuário: " + e.getMessage()).build();
    }
  }

  @GET
  @Path("/{id}")
  public Response buscarUsuario(@PathParam("id") Long id) {
    try {
      UsuarioEntity usuario = usuarioService.buscarPorId(id);
      return Response.ok(usuario).build();
    } catch (NotFoundException e) {
      return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }
  }

  @PUT
  @Path("/{id}")
  @Transactional
  public Response atualizarUsuario(@PathParam("id") Long id, UsuarioEntity usuario) {
    try {
      UsuarioEntity existente = usuarioService.buscarPorId(id);
      existente.nome = usuario.nome;
      existente.email = usuario.email;
      // Atualize outros campos conforme necessário

      usuarioService.atualizarUsuario(existente);
      return Response.ok(existente).build();
    } catch (NotFoundException e) {
      return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }
  }

  @DELETE
  @Path("/{id}")
  @Transactional
  public Response deletarUsuario(@PathParam("id") Long id) {
    try {
      usuarioService.deletarUsuario(id);
      return Response.noContent().build();
    } catch (Exception e) {
      return Response.status(Response.Status.BAD_REQUEST)
          .entity("Erro ao deletar usuário: " + e.getMessage()).build();
    }
  }
}