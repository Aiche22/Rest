package org.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/etudiants")
public class EtudiantResource {

    private EtudiantDao etudiantDao;

    public EtudiantResource() {
        etudiantDao = new EtudiantDaoImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Etudiant> getAllEtudiants() {
        return etudiantDao.getAllEtudiants();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Etudiant getEtudiantById(@PathParam("id") int id) {
        return etudiantDao.getEtudiantById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEtudiant(Etudiant etudiant) {
        etudiantDao.addEtudiant(etudiant);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEtudiant(@PathParam("id") int id, Etudiant etudiant) {
        etudiant.setId(id);
        etudiantDao.updateEtudiant(etudiant);
    }

    @DELETE
    @Path("/{id}")
    public void deleteEtudiant(@PathParam("id") int id) {
        etudiantDao.deleteEtudiant(id);
    }
}



