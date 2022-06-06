package Rest;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import Entities.User;


@RequestScoped
@Path("/")
@Produces("application/json")
@Consumes("application/json")
public class UserRest {
	@PersistenceContext(unitName = "Ecommerce")
	private EntityManager em;
	
	@Resource
	private UserTransaction ut;
	
	@POST
	@Path("/user")
	public Response create(final User user) throws IllegalStateException, SecurityException, SystemException {		
		try {
			ut.begin();
			em.persist(user);
			ut.commit();
		}catch (Exception e) {
			ut.rollback();
		}
		
		return Response
				.created(UriBuilder.fromResource(UserRest.class).path(String.valueOf(user.getId())).build())
				.build();
	}
	
	
	@POST
	@Path("login")
	public String login(User user) throws IllegalStateException, SecurityException, SystemException {
		
			TypedQuery<User> query = em.createQuery("SELECT i FROM User i" , User.class);
			List<User> users = query.getResultList();
			boolean flag=false;
			for(int i=0;i<users.size();i++) {
				
				if(user.getUsername().equals(users.get(i).getUsername())  && user.getPassword().equals(users.get(i).getPassword())) {
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				return "logged in";
			}
			else
			{
				return "Not succesfully logged";
			}
				
	}
	
	
	
	@GET
	@Path("/getAlluserTrips")
	public List<User> getAllUserTrips() throws IllegalStateException, SecurityException, SystemException {	
		List<User> users = null;
		try {
			ut.begin();
			TypedQuery<User> query = em.createQuery("SELECT i FROM User i", User.class);
			users = query.getResultList();
			
			ut.commit();
		}catch (Exception e) {
			ut.rollback();
		}	
		return users;
		
	}
	
	@GET
	@Path("/getAllUser")
	public List<User> getAllUsers() throws IllegalStateException, SecurityException, SystemException {	
		List<User> users = null;
		try {
			ut.begin();
			TypedQuery<User> query = em.createQuery("SELECT i FROM User i", User.class);
			users = query.getResultList();
			
			ut.commit();
		}catch (Exception e) {
			ut.rollback();
		}	
		return users;
		
	}
	
}
