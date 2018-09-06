package com.springbook.biz.commom;

import org.springframework.stereotype.Component;

@Component("after")
public class AfterReturningAdvice {
	public void afterLog() {
		System.out.println("[after 사후 처리] 비즈니스 로직 수행 후 동작");
	}
}
