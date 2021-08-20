package at.htl;

import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

  @Inject
  SecurityIdentity identity;

  @GET
  @RolesAllowed("user")
  @NoCache
  public Response getUserInfo() {
    return Response.ok(Map.of("username", identity.getPrincipal().getName())).build();
  }

  @GET
  @Path("/admin")
  @RolesAllowed("admin")
  public Response getAdmin() {
    return Response.ok(Map.of("role","I am admin")).build();
  }
}

