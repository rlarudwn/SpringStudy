package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository("mySql")
public class MySqlDAO implements MyDAO{
	@Override
	public void connection() {
		System.out.println("mySQL Connection");
	}
}
