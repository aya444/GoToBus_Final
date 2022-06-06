package Rest;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import Entities.Reserve;
import Entities.TripN;
import Entities.User;

@Stateless
@Path("/")
@Produces("application/json")
@Consumes("application/json")
public class TripRest {
	@PersistenceContext(unitName = "Ecommerce")
	private EntityManager em;
	
	
	
	@POST
	@Path("/trip")
	public Response create(final TripN trip){		
		
			em.persist(trip);
		
		
		return Response
				.created(UriBuilder.fromResource(TripRest.class).path(String.valueOf(trip.getId())).build())
				.build();
	}

	@GET
	@Path("/getAllTrips")
	public List<TripN> getAllTrips()  {	
		List<TripN> trips = null;
			TypedQuery<TripN> query = em.createQuery("SELECT i FROM TripN i", TripN.class);
			trips = query.getResultList();		

		return trips;
		
	}
	@POST
	@Path("/reserve")
	public String reserve(final Reserve reserve)  {	
		int number = 0 ;
			em.persist(reserve);
			User user = em.find(User.class, reserve.getUser_id());
			System.out.println(reserve.getUser_id());
			TripN trip = em.find(TripN.class, reserve.getTrip_id());
			System.out.println(reserve.getTrip_id());
			number = trip.getAvailable_seats();
			System.out.println("number");
			if(number>0)
			{
				user.addusertrip(trip);
				trip.addtripuser(user);
				number=number-1;
				trip.setAvailable_seats(number);
				
				return "reserved";
				
			}
			else
			{
			
				return "cannot reserve";
			}
			

	}

}
