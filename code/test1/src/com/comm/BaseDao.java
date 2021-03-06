package com.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//���ݿ��������-���
public class BaseDao {
	private static String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://120.77.155.205/schoolol?useSSL=false";
	private String user = "root";
	private String pwd="123456zxC";
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void getConnection(){
		try {
			conn= DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			System.out.println("fail");
			e.printStackTrace();
			
		}
	}

	public int executeUpdate(String sql,Object [] obs){
		int row=0;
		getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if(obs!=null&&obs.length>0){
				for(int i=0;i<obs.length;i++){
					ps.setObject(i+1, obs[i]);
					
				}
			}
			row= ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return row;
	}

	public ResultSet executeSelect(String sql,Object [] obs){
		ResultSet result = null;
		getConnection();

		try {
			ps = conn.prepareStatement(sql);
			if(obs!=null&&obs.length>0){
				for(int i=0;i<obs.length;i++){
					ps.setObject(i+1, obs[i]);
				}
			}
			result= ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public void free(){
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
