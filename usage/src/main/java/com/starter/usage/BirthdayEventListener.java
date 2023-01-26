package com.starter.usage;

import com.starter.event.Event;
import com.starter.event.EventListener;
import com.starter.event.EventListenerProperties;
import com.starter.event.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty(value = "event-starter.enabled", havingValue = "true")
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