package com.springbook.biz.commom;

import org.springframework.stereotype.Component;

@Component("AfterFinal")
public class AfterAdvice {
	public void finallyLog() {
		System.out.println("[finally사후 처리] 비즈니스 로직 수행 후 무조건 동작");
	}
}
