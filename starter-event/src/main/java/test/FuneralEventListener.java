package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
//@Component
//@ConditionalOnProperty(value = "event-starter.enabled", havingValue = "true")
class FuneralEventListener extends EventListener {

	public FuneralEventListener(EventListenerProperties properties) {
		super(properties);
	}

	@Override
	public EventType getSubscribedEventType() {
		return EventType.FUNERAL;
	}

	@Override
	@KafkaListener(topics = "funeral",
			groupId = "group-id")
	public void onEvent(Event event) {
		log.info("received event {}", event);
	}
}