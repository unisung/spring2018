package com.springbook.biz.commom;

import org.springframework.stereotype.Component;

/* POJO 클래스 - 일반클래스 */
/*@Component("logAdvice")*/
@Component("log")
public class LogAdvice {
	//advice
   public void printLog() {
	   System.out.println("[get공통로그]비즈니스 로직 수행 전 동작");
   }
}
