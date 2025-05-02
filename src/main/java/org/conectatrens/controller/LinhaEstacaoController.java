package org.conectatrens.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.conectatrens.entity.LinhaEstacaoEntity;
import org.conectatrens.service.LinhaEstacaoService;

import java.util.List;

@Path("/api/linha-estacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LinhaEstacaoController {

    @Inject
    LinhaEstacaoService linhaEstacaoService;

    @GET
    public List<LinhaEstacaoEntity> listAll() {
        return linhaEstacaoService.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getLinhaEstacao(@PathParam("id") Long id) {
        try {
            LinhaEstacaoEntity linhaEstacaoEntity = linhaEstacaoService.findById(id);
            return Response.ok(linhaEstacaoEntity).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @POST
    @Transactional
    public Response createLinhaEstacao(LinhaEstacaoEntity linhaEstacaoEntity) {
        return Response.ok(linhaEstacaoService.createLinhaEstacao(linhaEstacaoEntity)).build();
    }
}