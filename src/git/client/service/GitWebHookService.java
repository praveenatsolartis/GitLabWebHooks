package git.client.service;

import java.io.File;
import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.beans.PropertyReaderSingleton;
import com.beans.RepoSynchronizer;

import git.client.hooks.PushHookV2;
import git.client.utility.MailComposer;
import git.client.utility.PostDriverChecker;
import git.client.utility.ResponseDetail;

@Path("/webhookservice")
public class GitWebHookService {

	private PushHookV2 pushHook;

	@POST
	@Path("/event")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response testMethod(String data, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest) {
		Response.ResponseBuilder rBuilder = null;
		Response response = null;
		ResponseDetail responseDetail = new ResponseDetail();
		responseDetail.setId("2");
		responseDetail.setStatus("Sucess");
		ObjectMapper objectMapper = new ObjectMapper();
		String systemPath = "D:\\Praveen\\GitLabHooks\\";
		pushHook = null;
		try {
			pushHook = objectMapper.readValue(data, git.client.hooks.PushHookV2.class);

			System.out.println(pushHook.getUserEmail());
			RepoSynchronizer.synchronize(pushHook);
			objectMapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
			objectMapper.writeValue(new File(systemPath + "receivedRequest" + System.currentTimeMillis() + ".json"),
					pushHook);
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		rBuilder = Response.ok(responseDetail).type(MediaType.APPLICATION_JSON);
		response = rBuilder.build();
		return response;
	}

	@GET
	@Path("/bean/{key}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response invokePropertyReaderSingleton(@PathParam("key") String key) {
		String value = "";
		try {
			InitialContext ic = new InitialContext();
			PropertyReaderSingleton propertyReaderSingleton = null;
			propertyReaderSingleton = (PropertyReaderSingleton) ic
					.lookup("java:module/PropertyReaderSingleton!com.beans.PropertyReaderSingleton");
			value = (String) propertyReaderSingleton.getValue(key);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Inside Service Layer " + value);
		return Response.status(200).entity("Value " + value).build();
	}

	@GET
	@Path("/reloadConfigurations")
	@Produces(MediaType.TEXT_PLAIN)
	public Response reload() throws NamingException {
		InitialContext ic = new InitialContext();
		PropertyReaderSingleton propertyReaderSingleton = null;
		propertyReaderSingleton = (PropertyReaderSingleton) ic
				.lookup("java:module/PropertyReaderSingleton!com.beans.PropertyReaderSingleton");
		propertyReaderSingleton.reloadProperty();
		System.out.println("Inside reload");
		return Response.status(200).entity("Reload Sucessfully!!!").build();
	}

	@POST
	@Path("/sendMail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String send(String data) {
		String status = "true";
		pushHook = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			pushHook = objectMapper.readValue(data, git.client.hooks.PushHookV2.class);
			MailComposer mailComposer = new MailComposer();
			mailComposer.sendMail(pushHook);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;

	}

}
