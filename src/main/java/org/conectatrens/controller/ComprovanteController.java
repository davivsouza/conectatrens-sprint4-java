package org.conectatrens.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.conectatrens.entity.ComprovanteEntity;
import org.conectatrens.service.ComprovanteService;

import java.util.List;

@Path("/api/comprovantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComprovanteController {

    @Inject
    ComprovanteService comprovanteService;

    @GET
    public List<ComprovanteEntity> listAll() {
        return comprovanteService.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getComprovante(@PathParam("id") Long id) {
        try {
            ComprovanteEntity comprovanteEntity = comprovanteService.findById(id);
            return Response.ok(comprovanteEntity).build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @POST
    @Transactional
    public Response createComprovante(ComprovanteEntity comprovanteEntity) {
        return Response.ok(comprovanteService.createComprovante(comprovanteEntity)).build();
    }
}