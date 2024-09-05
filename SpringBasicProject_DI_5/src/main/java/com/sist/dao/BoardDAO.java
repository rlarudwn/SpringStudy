package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class BoardDAO {
	public void list() {
		System.out.println("SELECT");
	}
}
