package com.sist.dao;

public class MyDAO {
	public void getConnection() {
		System.out.println("오라클 연결");
	}
	public void disConnection() {
		System.out.println("연결 해제");
	}
	public void select() {
		System.out.println("SELECT");
	}
	public void insert() {
		System.out.println("INSERT");
	}
	public void update() {
		System.out.println("UPDATE");
	}
	public void delete() {
		System.out.println(10/0);
		System.out.println("DELETE");
	}
	public String find(String fd) {
		return fd+" 검색";
	}
	
}
