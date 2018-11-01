package com.hundun.mahjong.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mahjong")
public class MyController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String bot(
		@RequestParam(value = "message", required = false) String message) {
		System.out.println("from GMS:" + message);
		return "Hello GameMaker!";
	}


	
}
