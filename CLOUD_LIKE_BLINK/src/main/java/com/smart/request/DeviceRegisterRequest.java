package com.smart.request;

import lombok.Data;

@Data
public class DeviceRegisterRequest {
	private String deviceIp;
	private String deviceName;
	private String deviceToken;
}
