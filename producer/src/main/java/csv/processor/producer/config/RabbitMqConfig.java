package csv.processor.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

	public static final String QUEUE_NAME = "cadastro-usuarios-queue";
	
	public static final String EXCHANGE_NAME = "cadastro-usuarios-exchange";
	
	public static final String ROUTING_KEY = "cadastro-usuarios-routingKey";

    @Bean
    Queue queue() {
		return new Queue(QUEUE_NAME, true);
	}
    
    @Bean
    DirectExchange exchange() {
    	return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
    	return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
    
    @Bean
    RabbitTemplate rabbitTemplate (ConnectionFactory connectionFactory) {
    	RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    	rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
    }
    
    @Bean
    Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
