package com.rt.quarkus;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.HashMap;
import java.util.Map;

public class UpstreamServerMocks implements QuarkusTestResourceLifecycleManager {

  @Override
  public Map<String, String> start() {
    Map<String, String> config = new HashMap<>();
    config.put("quarkus.oidc-client.client-id", "custom-oidc-client-id");
    config.put("quarkus.oidc-client.credentials.secret", "custom-secret");
    config.put("quarkus.oidc-client.auth-server-url", "${keycloak.url:replaced-by-test-resource}/realms/test-realm");
    config.put("quarkus.rest-client.\"api-client\".url", "http://localhost:8081");
    return config;
  }

  @Override
  public void stop() {
    //NOOP
  }
}
