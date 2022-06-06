package Rest;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import Entities.Station;
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("station")
public class StationRest {
	@PersistenceContext
    private EntityManager em;
	@POST
	public Response addstation(Station station)
	{
		ResponseBuilder builder=Response.noContent();
		em.persist(station);
		builder = Response.ok();
		return builder.build();
	}
	@GET
	@Path("/{id}")
	public Station getID (@PathParam("id")Integer id)
	{
	 return em.find(Station.class, id);
	}
	
}