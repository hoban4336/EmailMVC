package com.yeon.EmailDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmailDao {

	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		}

		return conn;

	}

	public List<EmailVo> getList() {
		List<EmailVo> list = new ArrayList<EmailVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select  no, last_name, first_name, email from emaillist order by no desc";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String lastName = rs.getString(2);
				String firstName = rs.getString(3);
				String email = rs.getString(4);

				EmailVo evo = new EmailVo();
				evo.setNo(no);
				evo.setLastName(lastName);
				evo.setFirstName(firstName);
				evo.setEmail(email);

				list.add(evo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public void Insert(EmailVo vo){
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = getConnection();
			String sql = "insert  into emaillist values( emaillist_seq.nextval,  ? , ? ,  ? )";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3,vo.getEmail());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
