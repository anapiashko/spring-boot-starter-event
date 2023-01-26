package com.starter.event;

import lombok.*;

//@Value
//@ToString
@Data
public class Event {

	private EventType type;
	private String payload;

	public Event (){

	}

	public Event(EventType type, String payload) {
		this.type = type;
		this.payload = payload;
	}

}