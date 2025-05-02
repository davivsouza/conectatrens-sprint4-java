package org.conectatrens.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.conectatrens.entity.ReclamacaoEntity;
import org.conectatrens.service.ReclamacaoService;

import java.util.List;

@Path("/api/reclamacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReclamacaoController {

    @Inject
    ReclamacaoService reclamacaoService;

    @GET
    public List<ReclamacaoEntity> listAll() {
        return reclamacaoService.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getReclamacao(@PathParam("id") Long id) {
        try {
            ReclamacaoEntity reclamacaoEntity = reclamacaoService.findById(id);
            return Response.ok(reclamacaoEntity).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @POST
    @Transactional
    public Response createReclamacao(ReclamacaoEntity reclamacaoEntity) {
        return Response.ok(reclamacaoService.createReclamacao(reclamacaoEntity)).build();
    }
}