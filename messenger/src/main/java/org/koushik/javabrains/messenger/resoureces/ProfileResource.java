package org.koushik.javabrains.messenger.resoureces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.model.Profile;
import org.koushik.javabrains.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService ps=new ProfileService();
	
	@GET	
	public List<Profile> getProfiles()
	{
		
		return ps.getAllProfile();
	}
	
	@POST	
	public Profile addProfile(Profile profile)
	{
		return ps.addProfile(profile);
	}
	
	@GET
	@Path("/{profilename}")	
	public Profile getProfile(@PathParam("profilename") String profileName)
	{
		return ps.getProfile(profileName);
	}
	
	@PUT
	@Path("/{profilename}")	
	public Profile updateProfile(@PathParam("profilename") String profileName, Profile profile)
	{
		profile.setProfileName(profileName);
		return ps.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profilename}")	
	public void deleteProfile(@PathParam("profilename") String profileName)
	{
		ps.removeProfile(profileName);
	}
}
