package com.springbook.biz.commom;

import org.springframework.stereotype.Component;

@Component("logAdvice")
public class BeforeAdvice {
	public void beforeLog() {
		System.out.println("[before사전 처리] 비즈니스 로직 수행 전 동작");
	}
}
