package com.smart.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement
public class DeviceControllRequest {
	
	private String moterName;
	private String userToken;
	private String command;
	
}
