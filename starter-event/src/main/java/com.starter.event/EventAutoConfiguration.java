package com.starter.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
@Slf4j
@EnableConfigurationProperties(EventListenerProperties.class)
class EventAutoConfiguration {

  @Bean
  EventPublisher eventPublisher(KafkaTemplate<String, Event> kafkaTemplate){
    log.info("Creating bean EventPublisher...");
    return new EventPublisher(kafkaTemplate);
  }

}