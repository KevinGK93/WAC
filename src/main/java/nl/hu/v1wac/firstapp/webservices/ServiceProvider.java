package nl.hu.v1wac.firstapp.webservices;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

@Path("/countries")
public class ServiceProvider {
	private static WorldService worldService = new WorldService();

	public static WorldService getWorldService() {
		return worldService;
	}
	
	@GET
	@RolesAllowed("user")
	@Produces("application/json")
	public String getCounties() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : worldService.getAllCountries()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("surface", c.getSurface());
			job.add("government", c.getGovernment());
			job.add("lat", c.getLatitude());
			job.add("long", c.getLongitude());
			job.add("population", c.getPopulation());
			job.add("region", c.getRegion());
			
			jab.add(job);
		}
		
		JsonArray array = jab.build();	
		return array.toString();
    }
	
	@GET
	@RolesAllowed("user")
	@Path("{code}")
	@Produces("application/json")
	public String getCounty(@PathParam("code") String code) {
		Country c = worldService.getCountryByCode(code);
		
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("code", c.getCode());
		job.add("name", c.getName());
		job.add("capital", c.getCapital());
		job.add("surface", c.getSurface());
		job.add("government", c.getGovernment());
		job.add("lat", c.getLatitude());
		
		return job.build().toString();
	}
	
	@GET
	@RolesAllowed("user")
	@Path("/largestsurfaces")
	@Produces("application/json")
	public String getCountiesLargesSurface() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : worldService.get10LargestSurfaces()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("surface", c.getSurface());
			job.add("government", c.getGovernment());
			job.add("lat", c.getLatitude());
			
			jab.add(job);
		}
		
		JsonArray array = jab.build();	
		return array.toString();
	}
	
	@GET
	@RolesAllowed("user")
	@Path("/largestpopulations")
	@Produces("application/json")
	public String getCountiesLargestPopulation() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : worldService.get10LargestPopulations()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("code", c.getCode());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("surface", c.getSurface());
			job.add("government", c.getGovernment());
			job.add("lat", c.getLatitude());
			
			jab.add(job);
		}
		
		JsonArray array = jab.build();	
		return array.toString();
	}
}