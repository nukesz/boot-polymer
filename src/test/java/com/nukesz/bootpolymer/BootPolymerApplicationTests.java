package com.nukesz.bootpolymer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootPolymerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BootPolymerApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnOKResponseWithTwoEntities() {
        String allTodosUrl = "http://localhost:" + port + "/resources/todos";
        ResponseEntity<List> entity = testRestTemplate.getForEntity(allTodosUrl, List.class);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody()).hasSize(2);
    }

}
