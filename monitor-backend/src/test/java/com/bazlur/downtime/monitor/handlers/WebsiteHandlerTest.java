package com.bazlur.downtime.monitor.handlers;

import com.bazlur.downtime.monitor.constant.ApiEndpoints;
import com.bazlur.downtime.monitor.dto.WebsiteDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebsiteHandlerTest {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void testAddWebsite() {
    var websiteDto = WebsiteDTO.builder()
                               .url("https://bazlur.com/")
                               .build();

    var responseBody = webTestClient.post()
                                    .uri(ApiEndpoints.ADD_WEBSITE_ENDPOINT)
                                    .body(BodyInserters.fromValue(websiteDto))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .exchange()
                                    .expectStatus().isOk()
                                    .expectBody()
                                    .jsonPath("uuid").isNotEmpty()
                                    .jsonPath("url", websiteDto.getUrl());
  }
}
