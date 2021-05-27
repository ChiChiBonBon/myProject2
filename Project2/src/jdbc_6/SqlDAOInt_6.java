package jdbc_6;

import java.sql.Connection;

import javax.servlet.ServletContext;

public interface SqlDAOInt_6 {
	
	public TableBean_6 selectDAO(TableBean_6 bean, Connection conn, ServletContext context);
	public TableBean_6 updateDAO(TableBean_6 bean, Connection conn, ServletContext context);
	public TableBean_6 deleteDAO(TableBean_6 bean, Connection conn, ServletContext context);
	public TableBean_6 insertDAO(TableBean_6 bean, Connection conn, ServletContext context);

}
