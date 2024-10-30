package com.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.smart.handler.DeviceHandshakeInterceptor;
import com.smart.handler.MyWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final MyWebSocketHandler myWebSocketHandler;
    private final DeviceHandshakeInterceptor deviceHandshakeInterceptor;

    @Autowired
    public WebSocketConfig(MyWebSocketHandler myWebSocketHandler, DeviceHandshakeInterceptor deviceHandshakeInterceptor) {
        this.myWebSocketHandler = myWebSocketHandler;
        this.deviceHandshakeInterceptor = deviceHandshakeInterceptor;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler, "/ws")
                .addInterceptors(deviceHandshakeInterceptor)
                .setAllowedOrigins("*"); // Replace with specific origins in production
    }
}

