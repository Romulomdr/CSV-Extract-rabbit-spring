package csv.processor.consumer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class CsvUsersService {

	private RabbitTemplate rabbitTemplate;

	public CsvUsersService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void consumeQueue() {
	}
	
	public void saveUsers() {
		
	}
	
}
