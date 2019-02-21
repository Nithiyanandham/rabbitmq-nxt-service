package com.nxt.spboot.rabbitmqservice;

import com.nxt.spboot.rabbitmqservice.common.RabbitmqServiceProperties;
import com.nxt.spboot.rabbitmqservice.service.RabbitmqListenerService;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqServiceApplication.class, args);
    }

    @Autowired
    private RabbitmqServiceProperties rabbitmqServiceProperties;

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RabbitmqServiceApplication.class);
    }

    /* Creating a bean for the Message queue Exchange */
    @Bean
    public TopicExchange getAppExchange() {
        return new TopicExchange(rabbitmqServiceProperties.getAppExchange());
    }

    /* Creating a bean for the Message queue */
    @Bean
    public Queue getnxtQueue() {
        return new Queue(rabbitmqServiceProperties.getAppQueue());
    }

    /* Binding between Exchange and Queue using routing key */
    @Bean
    public Binding declareBindingNxt() {
        return BindingBuilder.bind(getnxtQueue()).to(getAppExchange()).with(rabbitmqServiceProperties.getAppRoutingKey());
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(rabbitmqServiceProperties.getAppQueue());
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(RabbitmqListenerService listener) {
        return new MessageListenerAdapter(listener, "receiveMessage");
    }

}