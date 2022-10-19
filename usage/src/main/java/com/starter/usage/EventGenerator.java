package com.starter.usage;

import com.starter.event.Event;
import com.starter.event.EventListener;
import com.starter.event.EventPublisher;
import com.starter.event.EventType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConditionalOnProperty(value = "event-starter.enabled", havingValue = "true")
class EventGenerator {

	private final EventPublisher eventPublisher;

	public EventGenerator(EventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Scheduled(fixedRate = 60000)
	void generateEvent() {
		Event birthdayEvent = new Event(EventType.BIRTHDAY, "This is a birthday event");
		eventPublisher.publishEvent(birthdayEvent);

		Event funeralEvent = new Event(EventType.FUNERAL, "This is a funeral event");
		eventPublisher.publishEvent(funeralEvent);
	}

}