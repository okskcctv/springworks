package com.spring.common;

import java.sql.Connection;

public class JDBCTest {

	public static void main(String[] args) {
		Connection conn = JDBCUtil.getConnection();
		System.out.println(conn);
	}

}
