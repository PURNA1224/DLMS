package com.example.DigitalLibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DigitalLibraryHomeController {
	@GetMapping("/")
	public String home() {
		return "Digital Library";
	}
}
