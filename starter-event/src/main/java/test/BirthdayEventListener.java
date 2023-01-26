package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class BirthdayEventListener extends EventListener {

	public BirthdayEventListener(EventListenerProperties properties) {
		super(properties);
	}

	@Override
	public EventType getSubscribedEventType() {
		return EventType.BIRTHDAY;
	}

	@Override
	@KafkaListener(topics = "birthday",
			groupId = "group-id")
	public void onEvent(Event event) {
		log.info("received event {}", event);
	}
}