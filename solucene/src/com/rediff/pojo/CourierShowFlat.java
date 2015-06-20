package com.rediff.pojo;

import java.io.Serializable;
import java.util.List;

public class CourierShowFlat implements Serializable {

	private static final long serialVersionUID = 1L;

	private CourierFlat courier;

	private List<CourierFlat> events;

	public CourierFlat getCourier() {
		return courier;
	}

	public List<CourierFlat> getEvents() {
		return events;
	}

	public void setCourier(CourierFlat courier) {
		this.courier = courier;
	}

	public void setEvents(List<CourierFlat> events) {
		this.events = events;
	}

}