package csv.processor.producer.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import csv.processor.producer.dto.UserDto;

@Component
public class UserItemWriter implements ItemWriter<UserDto>{

	private RabbitTemplate rabbitTemplate;

	public UserItemWriter(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void write(Chunk<? extends UserDto> users) throws Exception {
		rabbitTemplate.convertAndSend(
				RabbitMqConfig.EXCHANGE_NAME,
				RabbitMqConfig.ROUTING_KEY,
				users);
		
	}
}
