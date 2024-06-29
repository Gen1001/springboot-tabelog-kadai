package com.example.nagoyameshi.event;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.nagoyameshi.entity.User;

@Component
public class SubscriptionEventListener {
	private final JavaMailSender javaMailSender;
	
	public SubscriptionEventListener(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@EventListener
	private void onSubscriptEvent(SubscriptionEvent subscriptionEvent) {
		User user = subscriptionEvent.getUser();
				
		String recipientAddress = user.getEmail();
		String subject = "メール認証";
		String confirmationUrl = "https://billing.stripe.com/p/login/test_6oE5nlbUlf4f2764gg";
		String message = "以下のリンクより契約について変更いただけます。";
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(recipientAddress);
		mailMessage.setSubject(subject);
		mailMessage.setText(message + "\n" +confirmationUrl);
		javaMailSender.send(mailMessage);
				
	}
}
