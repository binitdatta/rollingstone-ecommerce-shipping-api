package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.ShippingEvent;

@Component
public class ShippingEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(ShippingEvent shippingEvent) {
		log.info("Received Shipping Event : "+shippingEvent.getEventType());
		log.info("Received Shipping From Shipping Event :"+shippingEvent.getShipping().toString());
	}
}
