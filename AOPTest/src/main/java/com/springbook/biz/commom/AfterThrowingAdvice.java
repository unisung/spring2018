package com.springbook.biz.commom;

import org.springframework.stereotype.Component;

@Component("afterThrowing")
public class AfterThrowingAdvice {
	public void afterException() {
		System.out.println("[afterExcept사후 처리] 비즈니스 로직 수행 중 예외 발생");
	}
}
