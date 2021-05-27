package servlet_6;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc_6.TableBean_6;

public interface ControlInt_6 {
	
	public void selectDB(HttpServletRequest request, HttpServletResponse response, TableBean_6 bean, Connection conn, ServletContext context);
	
	public void insertDB(HttpServletRequest request, HttpServletResponse response, TableBean_6 bean, Connection conn, ServletContext context);
	
	public void updateDB(HttpServletRequest request, HttpServletResponse response, TableBean_6 bean, Connection conn, ServletContext context);
	
	public void deleteDB(HttpServletRequest request, HttpServletResponse response, TableBean_6 bean, Connection conn, ServletContext context);

}
