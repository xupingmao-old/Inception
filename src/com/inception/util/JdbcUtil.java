package com.inception.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcUtil {

    private String user;
    private String passwd;
    private String url;

    public JdbcUtil(){

        user = "root";
        passwd = "root";
        
    	url="jdbc:mysql://127.0.0.1:3306/inceptionDB";
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
 
    public Connection getConnection(){
    	Connection conn=null;
    	try {
			 conn=DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
    	
    }
    
    public void close(ResultSet rs,Statement st,Connection conn){
    	
    	if(rs!=null){
    		try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	if(st!=null){
    		try {
    			st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	if(conn!=null){
    		try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
    
}
