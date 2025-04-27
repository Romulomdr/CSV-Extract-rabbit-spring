package csv.processor.producer.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import csv.processor.producer.config.RabbitMqConfig;
import csv.processor.producer.dto.UserDto;

@Service
public class CsvService {

	private final RabbitTemplate rabbitTemplate;

	public CsvService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void processCsv(MultipartFile file) throws Exception {
		
		List<UserDto> users = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
			
			String linha;
			boolean primeiraLinha = true;
			
			while((linha = reader.readLine()) != null) {
				
				if(primeiraLinha) {
					primeiraLinha = false;
					continue;
				}
				
				String[] dados = linha.split(",");
				
				UserDto userDto =  new UserDto(
						dados[0].trim(),
						dados[1].trim(),
						Integer.parseInt(dados[2].trim())
						);
				
				users.add(userDto);
				
				if(users.size() == 10) {
					enviarParaFila(users);
					users.clear();
				}
				
				if(!users.isEmpty()) {
					enviarParaFila(users);
					users.clear();
				}
			}
		}
	}
	
	private void enviarParaFila(List<UserDto> users) {
		rabbitTemplate.convertAndSend(
				RabbitMqConfig.EXCHANGE_NAME,
				RabbitMqConfig.ROUTING_KEY,
				users);
	}
	
	public String testRabbitMq(UserDto userDto) {
		
		rabbitTemplate.convertAndSend(
				RabbitMqConfig.EXCHANGE_NAME,
				RabbitMqConfig.ROUTING_KEY,
				userDto);
		
		return "Mensagem Enviada.";
	}
}
