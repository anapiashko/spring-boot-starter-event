package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

@Configuration
@Slf4j
@EnableConfigurationProperties(EventListenerProperties.class)
class EventAutoConfiguration {

  @Bean
  EventPublisher eventPublisher(List<EventListener> listeners, KafkaTemplate<String, Event> kafkaTemplate){
    log.info("Creating bean EventPublisher...");
    return new EventPublisher(listeners, kafkaTemplate);
  }

}