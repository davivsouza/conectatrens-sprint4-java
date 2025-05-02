package org.conectatrens.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.conectatrens.entity.EstacaoEntity;
import org.conectatrens.service.EstacaoService;

import java.util.List;

@Path("/api/estacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstacaoController {

    @Inject
    EstacaoService estacaoService;

    @GET
    public List<EstacaoEntity> listAll() {
        return estacaoService.listAll();
    }

    @POST
    @Transactional
    public Response createEstacao(EstacaoEntity estacao) {
        try {
            return Response.ok(estacaoService.createEstacao(estacao)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao criar estação: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getEstacao(@PathParam("id") Long id) {
        try {
            EstacaoEntity estacaoEntity = estacaoService.findById(id);
            return Response.ok(estacaoEntity).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }

}