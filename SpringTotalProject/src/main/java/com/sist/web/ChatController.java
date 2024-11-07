/*
	DI : 클래스와 클래스 연관 관계설정
		DAO VS Service
	AOP : 공통기반의 메소드를 만들어서 반복을 제거
		트랜잭션 / 보안
		
	페이지 에러
		404:파일이 없는경우
		500:DAO, NULL
		400:매개변수 받는 값의 데이터형이 다름
		405:GET/POST 구분
		403:접근거부
		412:한글 변환
		200:정상
 */
package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
	@GetMapping("chat/chat.do")
	public String chat() {
		return "chat/chat";
	}
}
