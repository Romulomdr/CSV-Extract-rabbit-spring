package csv.processor.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	public static final String QUEUE_NAME = "cadastro-usuarios-queue";
	public static final String EXCHANGE = "cadastro-usuarios-exchange"; 
	public static final String ROUTING_KEY = "cadastro-usuarios-routingKey";
	
	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, true);
	}
	
	@Bean
	DirectExchange Exchange() {
		return new DirectExchange(EXCHANGE);
	}
	
	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
}
