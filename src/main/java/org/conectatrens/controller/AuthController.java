package org.conectatrens.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.conectatrens.entity.UsuarioEntity;
import org.conectatrens.repository.UsuarioRepository;
import org.conectatrens.service.AuthService;

@Path("/api/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {

  @Inject
  AuthService authService;

  @Inject
  UsuarioRepository usuarioRepository;

  @POST
  @Path("/login")
  public Response login(UsuarioEntity user) {
    try {
      boolean loginValido = authService.validarLogin(user.email, user.senha);
      if (loginValido) {
        UsuarioEntity usuario = usuarioRepository.findByEmail(user.email);

        return Response.ok(usuario)
            .build();
      } else {
        return Response.status(Response.Status.UNAUTHORIZED)
            .entity("{\"erro\": \"Credenciais inválidas\"}")
            .build();
      }
    } catch (NotFoundException e) {
      return Response.status(Response.Status.NOT_FOUND)
          .entity("{\"erro\": \"Usuário não encontrado\"}")
          .build();
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity("{\"erro\": \"Erro ao processar login\"}")
          .build();
    }
  }

}