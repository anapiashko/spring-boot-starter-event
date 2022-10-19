package com.starter.event;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class Event {

	private EventType type;
	private String payload;

}