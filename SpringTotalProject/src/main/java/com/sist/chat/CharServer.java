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
	
	// ���ӽ� ó��
	@OnOpen
	public void onOpen(Session session) {
		users.add(session);
		System.out.println("Ŭ���̾�Ʈ ���� : "+session.getId());
	}
	// �޼��� ���۽� ó��
	@OnMessage
	public void onMessage(String message, Session session) throws Exception{
		System.out.println(session.getId()+"���� �޼��� : "+message);
		for(Session s:users) {
			s.getBasicRemote().sendText(message);
		}
	}
	// ����� ó��
	@OnClose
	public void onClose(Session session) {
		users.remove(session);
		System.out.println("Ŭ���̾�Ʈ ���� : "+session.getId());
	}
}

