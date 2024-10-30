package com.smart.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import com.smart.request.DeviceRegisterRequest;
import com.smart.handler.MyWebSocketHandler;
import com.smart.request.DeviceControllRequest;
import com.smart.response.DeviceResponse;
import com.smart.service.DeviceService;

@RestController
public class DeviceRestController {
	
	@Autowired
	DeviceService service;
	
	@Autowired
	MyWebSocketHandler handler;
	
	@GetMapping("/test/{deviceID}")
	 public ResponseEntity<DeviceResponse> test(@PathVariable String deviceID) throws IOException {
		 	(handler.deviceSessions.get(deviceID)).sendMessage(new TextMessage("Your request received"));
	        return new ResponseEntity<>(new DeviceResponse("started",deviceID), HttpStatus.OK);
	    } 
	
	 @PostMapping("/moter")
	 public ResponseEntity<DeviceResponse> moterControl(@RequestBody DeviceControllRequest request) {
		 	DeviceResponse response= service.handleRequest(request);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	 
	 @PostMapping("/register/device")
	 public String registerDevice(@RequestBody DeviceRegisterRequest requset) {
		  return service.registerDevice(requset);
	 }
	 
}
