package com.sangbill.advanced.thread.callable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sangbill.util.DBUtil;

public class SqlHadle {
	public int count(String table) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = String.format("select count(1) from %s ",table);
			conn = DBUtil.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				count = rs.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn, stmt, rs);	
		}
		return count;
	}



	public List query(int bindex, int num, String table) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			int start = (bindex == 0)?0:(bindex - 1)*num;
			int end = (bindex == 0)?num:bindex*num;
			String sql = String.format("select * from %s limit %s,%s ",table,start,end);
			conn = DBUtil.getInstance().getConnection();
			if(conn == null){
				System.out.println(conn);
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String personId = rs.getString(1);
				String groupId = rs.getString(2);
				String content = personId + "_"+groupId;
				list.add(content);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.getInstance().freeConnection(conn);
//			close(conn, stmt, rs);	
		}
		return list;
	}

	private void close(Connection conn, Statement stmt, ResultSet rs) {
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
