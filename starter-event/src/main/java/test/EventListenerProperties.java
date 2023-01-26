package test;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.List;

@ConfigurationProperties(prefix = "event-starter.listener")
@Data
public class EventListenerProperties {

    /**
     * List of event types that will be passed to {@link EventListener}
     * implementations. All other events will be ignored.
     */
    private List<EventType> enabledEvents = Collections.emptyList();

}