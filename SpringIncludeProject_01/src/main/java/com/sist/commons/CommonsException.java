package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
// ���� ����ó��	=> ��� Controller ����ó��
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException e) {
		System.out.println("================== DB ���� ==================");
		e.printStackTrace();
		System.out.println("============================================");
	}
	@ExceptionHandler(IOException.class)
	public void ioException(IOException e) {
		System.out.println("================== IO ���� ==================");
		e.printStackTrace();
		System.out.println("============================================");
	}
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException e) {
		System.out.println("================ RunTime���� ================");
		e.printStackTrace();
		System.out.println("============================================");
	}
	@ExceptionHandler(Exception.class)
	public void Exception(Exception e) {
		System.out.println("================== ��Ÿ���� ==================");
		e.printStackTrace();
		System.out.println("============================================");
	}
}
