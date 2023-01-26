package test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@ConditionalOnProperty(value = "event-starter.enabled", havingValue = "true")
class EventGenerator {

	private final EventPublisher eventPublisher;

	public EventGenerator(EventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Scheduled(fixedRate = 6000)
	void generateEvent() {
		Event birthdayEvent = new Event(EventType.BIRTHDAY, "This is a birthday event");
		eventPublisher.publishEvent(birthdayEvent);

//		Event funeralEvent = new Event(EventType.FUNERAL, "This is a funeral event");
//		eventPublisher.publishEvent(funeralEvent);
	}

}