package com.starter.event;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.List;

@ConfigurationProperties(prefix = "eventstarter.listener")
@Data
public class EventListenerProperties {

  /**
   * List of event types that will be passed to {@link EventListener}
   * implementations. All other events will be ignored.
   */
  private List<String> enabledEvents = Collections.emptyList();

}