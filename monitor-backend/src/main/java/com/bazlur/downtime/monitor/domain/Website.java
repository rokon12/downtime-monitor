package com.bazlur.downtime.monitor.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Website {
  private String uuid;
  private Long version;
  private String url;
  @Builder.Default
  private LocalDateTime createdDateTime = LocalDateTime.now();

  @Builder.Default
  private LocalDateTime lastUpdatedTime = LocalDateTime.now();
  ;

}
