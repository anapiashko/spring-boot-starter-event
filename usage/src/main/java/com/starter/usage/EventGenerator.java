package com.starter.usage;

import com.starter.event.Event;
import com.starter.event.EventPublisher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "eventstarter.enabled", havingValue = "true")
class EventGenerator {

	private final EventPublisher eventPublisher;

	public EventGenerator(EventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Scheduled(fixedRate = 2000)
	void generateEvent() {
		Event event = new Event("foo", "This is a foo event");
		eventPublisher.publishEvent(event);
	}

}