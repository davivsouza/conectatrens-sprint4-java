package org.conectatrens.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.conectatrens.entity.LinhaEntity;
import org.conectatrens.service.LinhaService;

import java.util.List;

@Path("/api/linhas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LinhaController {

    @Inject
    LinhaService linhaService;

    @GET
    public List<LinhaEntity> listAll() {
        return linhaService.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getLinha(@PathParam("id") Long id) {
        try {
            LinhaEntity linhaEntity = linhaService.findById(id);
            return Response.ok(linhaEntity).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @POST
    @Transactional
    public Response createUser(LinhaEntity linhaEntity) {
        return Response.ok(linhaService.createLinha(linhaEntity)).build();
    }



}