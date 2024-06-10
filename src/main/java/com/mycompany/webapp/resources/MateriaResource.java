/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.webapp.resources;

import com.mycompany.webapp.entidades.Materia;
import com.mycompany.webapp.negocio.DataService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/materias")
public class MateriaResource {

    @EJB
    DataService servicio;

    @GET
    public Response getMaterias() {
        List<Materia> materias = servicio.getMaterias();
        return Response.ok(materias).build();
    }

    @POST
    public Response saveMateria(Materia materia) {
        servicio.saveMateria(materia);
        return Response.ok("Materia creada exitosamente").build();
    }

    @PUT
    public Response editMateria(Materia materia) {
        servicio.editMateria(materia);
        return Response.ok("Materia editada exitosamente").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMateria(@PathParam("id") Integer id) {
        servicio.deleteMateria(new Materia(id));
        return Response.ok("Materia eliminada exitosamente").build();
    }
}
