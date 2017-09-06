package com.mkyong;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	ResponseEntity responseObj;
	// @RequestMapping("/")
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		responseObj = new ResponseEntity<>(HttpStatus.OK);
		String statusCode =responseObj.toString();
		String removeCharr = statusCode.replaceAll("[\\<\\>\\.\\^:]","");
		System.out.println("statusCode:"+removeCharr.substring(0, 3));
		return "welcome";
	}
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String welcomeSave(Map<String, Object> model) {
		model.put("message", this.message);
		 responseObj = new ResponseEntity<>(HttpStatus.CREATED);
		 String statusCode =responseObj.toString();
			String removeCharr = statusCode.replaceAll("[\\<\\>\\.\\^:]","");
			System.out.println("statusCode:"+removeCharr.substring(0, 3));
		return "welcome";
	}
	@RequestMapping(value = "/home", method = RequestMethod.DELETE)
	public String welcomeDelete(Map<String, Object> model) {
		model.put("message", this.message);
		 responseObj = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 String statusCode =responseObj.toString();
			String removeCharr = statusCode.replaceAll("[\\<\\>\\.\\^:]","");
			System.out.println("statusCode:"+removeCharr.substring(0, 3));
		return "welcome";
	}
	@RequestMapping(value = "/home", method = RequestMethod.PUT)
	public String welcomePut(Map<String, Object> model) {
		model.put("message", this.message);
		 responseObj = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 String statusCode =responseObj.toString();
			String removeCharr = statusCode.replaceAll("[\\<\\>\\.\\^:]","");
			System.out.println("statusCode:"+removeCharr.substring(0, 3));
		return "welcome";
	}
	

}