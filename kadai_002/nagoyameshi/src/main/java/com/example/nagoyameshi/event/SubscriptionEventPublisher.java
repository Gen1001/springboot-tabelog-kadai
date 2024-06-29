package com.example.nagoyameshi.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.example.nagoyameshi.entity.User;

@Component
public class SubscriptionEventPublisher {
	private final ApplicationEventPublisher applicationEventPublisher;
	
	public SubscriptionEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public void publishSubscriptionEvent(User user, String requestUrl) {
		applicationEventPublisher.publishEvent(new SubscriptionEvent(this, user, requestUrl));
	}
}
