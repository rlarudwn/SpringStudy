package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository("Oracle")
public class OracleDAO implements MyDAO {
	@Override
	public void connection() {
		System.out.println("Oracle Connection");

	}
}
