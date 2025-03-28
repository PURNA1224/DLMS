package com.example.DigitalLibrary.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/system")
public class SystemController {

	private final ApplicationContext context;
	
	public SystemController(ApplicationContext context) {
		this.context = context;
	}
	
	@GetMapping("/exit")
	public ResponseEntity<String >exitSystem() {
		ResponseEntity<String> response = ResponseEntity.ok("System is shutting down...");
        new Thread(() -> {
            int exitCode = SpringApplication.exit(context, () -> 0);
            System.exit(exitCode);
        }).start();

        return response; 
	}
}
