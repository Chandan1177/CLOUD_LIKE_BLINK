package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smart.dao.DeviceDao;
import com.smart.request.DeviceRegisterRequest;
import com.smart.request.DeviceControllRequest;
import com.smart.response.DeviceResponse;


@Service
public class DeviceService {
	
	@Autowired
	DeviceDao dao;
	
	@Autowired
	Validation validation;
	
	public DeviceResponse handleRequest(DeviceControllRequest request) {
		if(validation.isValidUser(request)) {
			return dao.handleRequest(request);
		}
		return null;
	}

	public String registerDevice(DeviceRegisterRequest request) {
		if(validation.isValidDevice(request))	{
			return dao.registerDevice(request);
		}else return "device :: unauthorized";	
	}
	
}
