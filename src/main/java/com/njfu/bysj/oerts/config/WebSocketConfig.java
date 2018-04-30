/**
 * @FileName:		WebSocketConfig.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月29日 下午7:33:02
 *
 */
package com.njfu.bysj.oerts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @ClassName: WebSocketConfig
 * @Description: /通过EnableWebSocketMessageBroker 开启使用STOMP协议来传输基于代理(message
 *               broker)的消息,此时浏览器支持使用@MessageMapping 就像支持@RequestMapping一样
 *
 * @author: 徐至彦
 * @date: 2018年4月29日 下午7:33:02
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	// 注册一个名字为"socket" 的endpoint,并指定 SockJS协议;添加一个服务端点，来接收客户端的连接
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/socket").withSockJS();
	}

	@Override
	// 配置消息代理(message broker) 设置消息连接请求的各种规范
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 客户端订阅地址的前缀信息
		registry.enableSimpleBroker("/topic");
		// 客户端给服务端发消息的地址的前缀
		registry.setApplicationDestinationPrefixes("/app");
	}
}
