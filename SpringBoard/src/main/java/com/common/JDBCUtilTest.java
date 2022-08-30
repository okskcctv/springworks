package com.common;

import java.sql.Connection;

public class JDBCUtilTest {

	public static void main(String[] args) {
		Connection conn = JDBCUtil.getConnection();
		System.out.println(conn);
	}

}
