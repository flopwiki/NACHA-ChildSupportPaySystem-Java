package org.nacha.paymentsystem.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

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
        String securedUrl = "http://localhost:" + port + "/api/payments/test";

        // Act
        ResponseEntity<String> response = restTemplate.getForEntity(securedUrl, String.class);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    void shouldAllowAccessToUnsecuredEndpoint() {
        // Arrange
        String unsecuredUrl = "http://localhost:" + port + "/api/public/test";

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
        headers.setBasicAuth("user", "password");

        // Act
        ResponseEntity<String> response = restTemplate.getForEntity(securedUrl, String.class);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}