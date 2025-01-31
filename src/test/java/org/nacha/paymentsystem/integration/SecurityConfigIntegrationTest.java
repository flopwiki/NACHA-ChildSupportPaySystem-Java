package org.nacha.paymentsystem.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod.*;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration()
@TestPropertySource(properties = {
        "APP_USER_PASSWORD=password", // Test environment credentials
})
class SecurityConfigIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void shouldDenyAccessToSecuredEndpointWithoutAuthentication() {
        // Arrange
        String securedUrl = "http://localhost:5000" + port + "/api/payments/test";

        // Act
        ResponseEntity<String> response = restTemplate.getForEntity(securedUrl, String.class);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    void shouldAllowAccessToUnsecuredEndpoint() {
        // Arrange
        String unsecuredUrl = "http://localhost:5000" + port + "/api/public/test";

        // Act
        ResponseEntity<String> response = restTemplate.getForEntity(unsecuredUrl, String.class);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldGrantAccessToSecuredEndpointWithValidCredentials() {
        // Arrange
        String securedUrl = "http://localhost:" + port + "/api/payments/test";
        HttpHeaders headers = new HttpHeaders();
        //headers.setBasicAuth("username", "password1234"); // Adjust
        // credentials as needed

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        // Act
        ResponseEntity<String> response = restTemplate.exchange(
                securedUrl, org.springframework.http.HttpMethod.GET, requestEntity, String.class
        );

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}