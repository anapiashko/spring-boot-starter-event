package test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;

/**
 * Dummy implementation of an event publisher. Simply publishes an event to all listeners that
 * are subscribed to that event. This solution obviously doesn't work
 * across the boundaries of a single application context... .
 */
@Slf4j
@RequiredArgsConstructor
public class EventPublisher {

    /**
     * The listeners that should be notified about published events.
     */
    private final List<EventListener> listeners;

    private final KafkaTemplate<String, Event> kafkaTemplate;

    public void publishEvent(Event event) {
        log.info("trying to publish event: {}", event);
        for (EventListener listener : listeners) {
            Message<Event> message = MessageBuilder
                    .withPayload(event)
                    .setHeader(KafkaHeaders.TOPIC, listener.getSubscribedEventType().toString().toLowerCase())
                    .build();
            kafkaTemplate.send(message);
        }
    }


}