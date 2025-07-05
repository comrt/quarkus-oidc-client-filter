package com.rt.quarkus;

import io.quarkus.oidc.client.filter.OidcClientFilter;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("api")
@OidcClientFilter
@RegisterRestClient(configKey = "api-client")
public interface ApiClient {

  @GET
  String getMessage();
}
