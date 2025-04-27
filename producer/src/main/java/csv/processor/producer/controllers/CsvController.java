package csv.processor.producer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import csv.processor.producer.dto.UserDto;
import csv.processor.producer.service.CsvService;

@RestController
public class CsvController {


	private final CsvService csvService;
	
	public CsvController(CsvService csvService) {
		this.csvService = csvService;
	}
	
	
	@PostMapping("/upload-csv")
	public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
		try {
			if(file.isEmpty()) {
				return ResponseEntity.badRequest().body("Arquivo vazio.");
			}
			
			csvService.processCsv(file);
			return ResponseEntity.ok().body("CSV processado e enviado para a fila com sucesso.");
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Erro ao processar CSV "+ e.getMessage());
		}
	}
	
	
	@GetMapping("/teste") // Apenas para testar o RabbitMQ
	public String testeEnvio() {
		
		UserDto userDto = new UserDto("Jorge", "jorge@email.com", 25);
				
		return csvService.testRabbitMq(userDto);
	}
}
