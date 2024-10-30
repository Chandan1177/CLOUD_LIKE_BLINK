package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.DeviceDao;
import com.smart.request.DeviceRegisterRequest;
import com.smart.request.DeviceControllRequest;

@Service
public class Validation {
	
	@Autowired
	DeviceDao dao;
	
	public boolean isValidDevice(DeviceRegisterRequest request) {
		return (dao.getDeviceRecord(request.getDeviceToken()))>0?true:false;
	}
	
	public boolean isValidUser(DeviceControllRequest request) {
		return (dao.getUserRecord(request.getUserToken()))>0?true:false;
	}
}
