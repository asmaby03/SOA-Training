package webservices;

import metiers.UniteEnseignementBusiness;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
@Path("/ue")
public class UniteENSRestapi {
    //helper: instance that will helop this class to manipulate data:CRUD
    UniteEnseignementBusiness helper=
            new UniteEnseignementBusiness();
    //get List UEs
    @Path("/List")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUEs() {
        return  Response
                .status(200)
                .entity(helper.getListeUE())
                .build();

    }
}
