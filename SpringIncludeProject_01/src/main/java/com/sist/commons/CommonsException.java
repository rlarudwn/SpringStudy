package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
// 공통 예외처리	=> 모든 Controller 예외처리
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException e) {
		System.out.println("================== DB 에러 ==================");
		e.printStackTrace();
		System.out.println("============================================");
	}
	@ExceptionHandler(IOException.class)
	public void ioException(IOException e) {
		System.out.println("================== IO 에러 ==================");
		e.printStackTrace();
		System.out.println("============================================");
	}
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException e) {
		System.out.println("================ RunTime에러 ================");
		e.printStackTrace();
		System.out.println("============================================");
	}
	@ExceptionHandler(Exception.class)
	public void Exception(Exception e) {
		System.out.println("================== 기타에러 ==================");
		e.printStackTrace();
		System.out.println("============================================");
	}
}
