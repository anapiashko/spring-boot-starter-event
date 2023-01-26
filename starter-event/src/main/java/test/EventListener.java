package test;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class EventListener {

    private final EventListenerProperties properties;

    public void receive(Event event) {
        if (isEnabled(event) && isSubscribed(event)) {
            onEvent(event);
        }
    }

    private boolean isSubscribed(Event event) {
        return event.getType().equals(getSubscribedEventType());
    }

    private boolean isEnabled(Event event) {
        return properties.getEnabledEvents().contains(event.getType());
    }

    protected abstract EventType getSubscribedEventType();

    protected abstract void onEvent(Event event);

}