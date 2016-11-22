package com.fitnessgeek.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

@Named
public class JMSBean {
	
	@Inject
	ActiveMQConnectionFactory jmsConnectionFactory;

	public void submit(String message) throws Exception {

		Connection connection = jmsConnectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Queue photoqQueue = session.createQueue("fitnessgeek_photos");
		MessageProducer producer = session.createProducer(photoqQueue);

		TextMessage textMessage = session.createTextMessage(message);

		producer.send(textMessage);
		connection.stop();
	}
}
