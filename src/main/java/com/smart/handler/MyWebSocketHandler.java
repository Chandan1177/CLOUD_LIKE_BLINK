package com.smart.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    public static Map<String, WebSocketSession> deviceSessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String deviceId = (String) session.getAttributes().get("deviceId");
        
        if (deviceId == null) {
            // Handle cases where no device ID is provided
            deviceId = "UnknownDevice" + session.getId();
        }
        
        deviceSessions.put(deviceId, session);
        System.out.println("Device connected with ID: " + deviceId);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String deviceId = (String) session.getAttributes().get("deviceId");
        String payload = message.getPayload();
        
        System.out.println("Message from device " + deviceId + ": " + payload);
        session.sendMessage(new TextMessage("Echo from server: " + payload));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String deviceId = (String) session.getAttributes().get("deviceId");
        deviceSessions.remove(deviceId);
        System.out.println("Device disconnected with ID: " + deviceId);
    }
}

