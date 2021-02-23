package com.bazlur.downtime.monitor.handlers;

import com.bazlur.downtime.monitor.dto.WebsiteDTO;
import com.bazlur.downtime.monitor.services.WebsiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class WebsiteHandler {

  private final WebsiteService websiteService;

  public WebsiteHandler(final WebsiteService websiteService) {
    this.websiteService = websiteService;
  }

  public Mono<ServerResponse> addWebsite(ServerRequest request) {
    var websiteDTOMono = websiteService.addWebsite(request.bodyToMono(WebsiteDTO.class));

    return ServerResponse.ok()
                         .contentType(MediaType.APPLICATION_JSON)
                         .body(BodyInserters.fromProducer(websiteDTOMono, WebsiteDTO.class));
  }

}
