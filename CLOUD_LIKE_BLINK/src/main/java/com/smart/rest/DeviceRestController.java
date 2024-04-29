package com.smart.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.smart.request.DeviceRegisterRequest;
import com.smart.request.DeviceControllRequest;
import com.smart.response.DeviceResponse;
import com.smart.service.DeviceService;

@RestController
public class DeviceRestController {
	
	@Autowired
	DeviceService service;
	
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
