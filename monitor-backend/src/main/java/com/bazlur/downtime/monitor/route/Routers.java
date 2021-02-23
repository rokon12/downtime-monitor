package com.bazlur.downtime.monitor.route;

import com.bazlur.downtime.monitor.handlers.WebsiteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.bazlur.downtime.monitor.constant.ApiEndpoints.ADD_WEBSITE_ENDPOINT;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Routers {

  @Bean
  public RouterFunction<ServerResponse> route(WebsiteHandler handlers) {

    return RouterFunctions
               .route(POST(ADD_WEBSITE_ENDPOINT).and(accept(MediaType.APPLICATION_JSON)), handlers::addWebsite);
  }
}
