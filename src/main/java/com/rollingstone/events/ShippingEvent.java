package com.rollingstone.events;


import org.springframework.context.ApplicationEvent;

import com.rollingstone.spring.model.Shipping;

public class ShippingEvent extends ApplicationEvent {

	private String eventType;
	private Shipping shipping;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	public ShippingEvent(Object source, String eventType, Shipping shipping) {
		super(source);
		this.eventType = eventType;
		this.shipping = shipping;
	}
	@Override
	public String toString() {
		return "ShippingEvent [eventType=" + eventType + ", shipping=" + shipping + "]";
	}
	
	
	
}
