package se.jensenyh.javacourse.saltmerch.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IntegrationTest
{
    @LocalServerPort
    private int urlPort;

    @Autowired
    private TestRestTemplate restTemplate;
    private String BaseUrl()
    {
        return "http://localhost:" + urlPort + "/api/v1/";
    }

    @org.junit.jupiter.api.Test
    public void GetAllProducts() throws Exception
    {
        ResponseEntity<String> res = restTemplate.getForEntity(BaseUrl() + "products", String.class);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @org.junit.jupiter.api.Test
    public void WhenGetCartItemsEqualsNull_HttpResponseIs400() throws Exception
    {
        ResponseEntity<String> res = restTemplate.getForEntity(BaseUrl() + "carts/1", String.class);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
