package webservices;
import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/module")
public class ModuleRestapi {
    static ModuleBusiness helper = new ModuleBusiness();

@Path("/List")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getListModule()
{
    return Response.status(200).entity(helper.getAllModules()).build();
}

    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createModule(Module module) {
        if (helper.addModule(module)) {
            return Response.status(201).entity("ok").build();
        }
        return Response.status(400).entity("Erreur").build();
    }

    @Path("/{matricule}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModule(@PathParam("matricule") String matricule) {
        Module m = helper.getModuleByMatricule(matricule);
        if (m == null) {
            return Response.status(404).entity("Introuvable").build();
        }
        return Response.ok(m).build();
    }
}
