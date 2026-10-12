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

}
