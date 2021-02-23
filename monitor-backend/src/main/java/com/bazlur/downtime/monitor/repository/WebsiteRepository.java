package com.bazlur.downtime.monitor.repository;

import com.bazlur.downtime.monitor.domain.Website;
import org.springframework.stereotype.Component;

@Component
public class WebsiteRepository {
  public Website save(final Website website) {

    return website;
  }
}
