package com.smart.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.smart.request.DeviceRegisterRequest;
import com.smart.request.DeviceControllRequest;
import com.smart.response.DeviceResponse;

@Repository
public class DeviceDao {

	private Map<String, String> deviceMap=new HashMap<>();
	
	
	public DeviceResponse handleRequest(DeviceControllRequest requset) {
		String url = deviceMap.get(requset.getMoterName())+"/"+requset.getCommand();
        RestTemplate restTemplate = new RestTemplate();
        String status= restTemplate.getForObject(url, String.class);
        
        DeviceResponse response=new DeviceResponse();
        response.setStatus(status);
        response.setDeviceName(requset.getMoterName());
        return response;
	}

	public String registerDevice(DeviceRegisterRequest request) {
		deviceMap.put(request.getDeviceName(), request.getDeviceIp());
		return "Device :: registered";
	}

	public int getDeviceRecord(String deviceToken) {
		//logic to fetch device record form db
		return 1;
	}

	public int getUserRecord(String userToken) {
		//logic to fetch user record form db
		return 1;
	}
	
}
