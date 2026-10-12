package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
@Path("/ue")
public class UniteENSRestapi {
    //helper: instance that will helop this class to manipulate data:CRUD
    static UniteEnseignementBusiness helper=
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
    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUe(UniteEnseignement unite){
        if (helper.addUniteEnseignement(unite)){
            return Response.status(201).entity("ok").build();
        }
        else{
            return Response.status(400).entity("Erreur").build();
        }
    }
//getUEbycode
    @Path("/{inputCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getUE(@PathParam("inputCode") int code){
        return Response.ok(helper.getUEByCode(code)).build();
    }
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@GET
public Response getUEBysemestre(@QueryParam("semestre")int semestre){
        return Response.ok(helper.getUEBySemestre(semestre)).build();
}
@Path("/")
@DELETE
public Response deleteByCode(@QueryParam("code")int code){
        if (helper.deleteUniteEnseignement(code)){
            return Response.status(200).build();
        }
        else return Response.status(400).build();
}
}