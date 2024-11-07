/*
	DI : Ŭ������ Ŭ���� ���� ���輳��
		DAO VS Service
	AOP : �������� �޼ҵ带 ���� �ݺ��� ����
		Ʈ����� / ����
		
	������ ����
		404:������ ���°��
		500:DAO, NULL
		400:�Ű����� �޴� ���� ���������� �ٸ�
		405:GET/POST ����
		403:���ٰź�
		412:�ѱ� ��ȯ
		200:����
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
