package com.sist.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/chat/chat-ws")
public class CharServer {
	private static List<Session> users=Collections.synchronizedList(new ArrayList<Session>());
	
	// 접속시 처리
	@OnOpen
	public void onOpen(Session session) {
		users.add(session);
		System.out.println("클라이언트 접속 : "+session.getId());
	}
	// 메세지 전송시 처리
	@OnMessage
	public void onMessage(String message, Session session) throws Exception{
		System.out.println(session.getId()+"님의 메세지 : "+message);
		for(Session s:users) {
			s.getBasicRemote().sendText(message);
		}
	}
	// 퇴장시 처리
	@OnClose
	public void onClose(Session session) {
		users.remove(session);
		System.out.println("클라이언트 퇴장 : "+session.getId());
	}
}

