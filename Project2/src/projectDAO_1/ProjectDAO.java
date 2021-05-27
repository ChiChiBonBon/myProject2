package projectDAO_1;


import java.sql.Connection;

import projectVO_1.ProjectBean;

public interface ProjectDAO {
		
	int createAccount(ProjectBean bean, Connection conn);
	
	boolean deleteAccount(ProjectBean bean, Connection conn);
	
	int updateAccount(ProjectBean bean, Connection conn);
	
	boolean updatePassword(ProjectBean bean, Connection conn);
	
	ProjectBean checkAccount(String account, String password, Connection conn);
	
	ProjectBean member_info(int id);

	
}