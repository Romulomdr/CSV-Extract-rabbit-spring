package csv.processor.producer.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvController {

	
	@PostMapping(name = "/send")
	public void sendCsv() {
		
	}
	
}
