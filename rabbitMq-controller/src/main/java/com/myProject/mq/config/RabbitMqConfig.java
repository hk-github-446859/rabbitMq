package com.myProject.mq.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("helloQueue");
    }
    @Bean
    public Queue userQueue() {
        return new Queue("userQueue");
    }

    @Bean
    public Queue directQueue() {
        return new Queue("direct.message");
    }

    @Bean
    public Queue directQueues() {
        return new Queue("direct.messages");
    }

    @Bean
    public Queue queueMessage() {
        return new Queue("topic.message");
    }
    @Bean
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }
    //===============以上是验证Fanout Exchange的队列==========

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }
//    @Bean
//    DirectExchange directExchanges() {
//        return new DirectExchange("directExchanges");
//    }
    @Bean
    Binding bindingExchangeDirect(Queue queueMessage, DirectExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("direct.message");
    }
    @Bean
    Binding bindingExchangeDirects(Queue queueMessages, DirectExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("direct.*");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }


    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}
