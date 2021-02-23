package com.bazlur.downtime.monitor.services;

import com.bazlur.downtime.monitor.domain.Website;
import com.bazlur.downtime.monitor.dto.WebsiteDTO;
import com.bazlur.downtime.monitor.repository.WebsiteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class WebsiteService {
  private final WebsiteRepository repository;

  public WebsiteService(final WebsiteRepository repository) {
    this.repository = repository;
  }

  public Mono<WebsiteDTO> addWebsite(final Mono<WebsiteDTO> websiteDTO) {

    return websiteDTO.log()
                     .map(websiteDTO1 ->
                              repository.save(Website.builder()
                                                     .uuid(UUID.randomUUID().toString())
                                                     .url(websiteDTO1.getUrl())
                                                     .build()))
                     .map(website -> new WebsiteDTO(website.getUuid(), website.getUrl()));
  }
}
