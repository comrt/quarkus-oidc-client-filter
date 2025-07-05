package com.rt.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class ExampleResource {

  @RestClient
  ApiClient apiClient;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    try {
      apiClient.getMessage();
    } catch (Exception exception) {
      return "Error calling API: " + exception.getMessage();
    }
    return "Hello RESTEasy";
  }
}
