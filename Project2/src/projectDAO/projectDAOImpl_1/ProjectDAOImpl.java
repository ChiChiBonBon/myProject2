package projectDAO.projectDAOImpl_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import projectDAO_1.ProjectDAO;
import projectVO_1.ProjectBean;

public class ProjectDAOImpl implements ProjectDAO {

	@Override
	public boolean deleteAccount(ProjectBean bean, Connection conn) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM [member_1]\n"
				+ "WHERE id = ?;";

		boolean isDelete = false;
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, bean.getId());

			int i = stmt.executeUpdate();
			if (i > 0) {
				isDelete = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDelete;
	}

	@Override
	public ProjectBean checkAccount(String account, String password, Connection conn) {
		// TODO Auto-generated method stub
		account = String.format("%s", account);
		String sqlString = "SELECT * FROM [member_1] \n" + "where account = ?;";
		ProjectBean acc_check = null;
		ProjectBean projectBean = new ProjectBean();

		try {
			PreparedStatement stmt = conn.prepareStatement(sqlString);

			stmt.setString(1, account);
			ResultSet rsResultSet = stmt.executeQuery();

			System.out.println(rsResultSet);

			while (rsResultSet.next()) {
				projectBean.setId(rsResultSet.getInt("id"));
				projectBean.setAccount(rsResultSet.getString("account"));
				projectBean.setPassword(rsResultSet.getString("password"));
				projectBean.setName(rsResultSet.getString("name"));
				projectBean.setBirthday(rsResultSet.getString("birthday"));
				projectBean.setNickname(rsResultSet.getString("nickname"));
				projectBean.setGender(rsResultSet.getString("gender"));
				projectBean.setE_mail(rsResultSet.getString("e_mail"));
				projectBean.setCellphone(rsResultSet.getString("cellphone"));
				projectBean.setAddress(rsResultSet.getString("address"));
				projectBean.setJob(rsResultSet.getString("job"));
				projectBean.setCarrier(rsResultSet.getString("carrier"));

				System.out.println("check Account:" + projectBean.getAccount());

				if (password.equals(projectBean.getPassword())) {
					acc_check = projectBean;
				}

			}
//			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc_check;
	}

	@Override
	public ProjectBean member_info(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createAccount(ProjectBean bean, Connection conn) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO [member_1]\n"
				+ "		(account, password, name, birthday, nickname, gender, e_mail, cellphone, address, job, carrier)\n"
				+ "		VALUES (?,?,?,?,?,?,?,?,?,?,?);";

		int isInsert = 0;
//		default fail
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bean.getAccount());
			stmt.setString(2, bean.getPassword());
			stmt.setString(3, bean.getName());
			stmt.setString(4, bean.getBirthday());
			stmt.setString(5, bean.getNickname());
			stmt.setString(6, bean.getGender());
			stmt.setString(7, bean.getE_mail());
			stmt.setString(8, bean.getCellphone());
			stmt.setString(9, bean.getAddress());
			stmt.setString(10, bean.getJob());
			stmt.setString(11, bean.getCarrier());

			int i = stmt.executeUpdate();
			if (i > 0) {
				isInsert = 1;
//				set success
			}
//		} catch (SQLIntegrityConstraintViolationException e) {
//			// TODO: handle exception
////			抓SQL UNIQUE KEY的重複
//			isInsert = -1;
////			表示 SQL unique error
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String eString = e.toString();
			System.out.println(eString);
			if (eString.contains("UQ__member_1__EA162E11728CA49E")) {
				isInsert = -1;
//				表示 SQL unique error account		
			} else if (eString.contains("UQ__member_1__B58D514980C016ED")) {
				
				isInsert = -2;
//				表示 SQL unique error e_mail
			}
		}
		System.out.println("create account status: " + isInsert);
		return isInsert;
	}

	@Override
	public int updateAccount(ProjectBean bean, Connection conn) {
		// TODO Auto-generated method stub
		String sql = "UPDATE [member_1]\n"
				+ "SET\n"
				+ "account = ?,\n"
				+ "name = ?,\n"
				+ "birthday = ?,\n"
				+ "nickname = ?,\n"
				+ "gender = ?,\n"
				+ "e_mail = ?,\n"
				+ "cellphone = ?,\n"
				+ "address = ?,\n"
				+ "job = ?,\n"
				+ "carrier = ?\n"
				+ "WHERE id = ?;";
//		String sql = "UPDATE MyProject.member_1\n"
//				+ "SET account = ?,"
//				+ " name = ?,"
//				+ " birthday = ?,"
//				+ " nickname = ?,"
//				+ " gender = ?,"
//				+ " e_mail = ?,"
//				+ " cellphone = ?,"
//				+ " address = ?,"
//				+ " job = ?,"
//				+ " carrier = ?"
//				+ " WHERE `id` = ? ;";

		int isUpdate = 0;
//		default fail	
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bean.getAccount());
			stmt.setString(2, bean.getName());
			stmt.setString(3, bean.getBirthday());
			System.out.println("bean birthday: " + bean.getBirthday());
			stmt.setString(4, bean.getNickname());
			stmt.setString(5, bean.getGender());
			stmt.setString(6, bean.getE_mail());
			stmt.setString(7, bean.getCellphone());
			System.out.println("bean cellphone: " + bean.getCellphone());
			stmt.setString(8, bean.getAddress());
			stmt.setString(9, bean.getJob());
			stmt.setString(10, bean.getCarrier());
			stmt.setInt(11, bean.getId());

			int i = stmt.executeUpdate();
			if (i > 0) {
				isUpdate = 1;
//				set success

			}
//		} catch (SQLIntegrityConstraintViolationException e) {
//			// TODO: handle exception
////			抓SQL UNIQUE KEY的重複
//			isUpdate = -1;
//			表示 SQL unique error
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String eString = e.toString();
			if (eString.contains("UQ__member_1__EA162E11728CA49E")) {
				isUpdate = -1;
//				表示 SQL unique error account		
			} else if (eString.contains("UQ__member_1__B58D514980C016ED")) {
				isUpdate = -2;
//				表示 SQL unique error e_mail
			} else if (eString.contains("member_1.cellphone_UNIQUE")) {
				isUpdate = -3;
//				表示 SQL unique error cellphone
			}
		}
		return isUpdate;
	}

	@Override
	public boolean updatePassword(ProjectBean bean, Connection conn) {
		// TODO Auto-generated method stub
		String sql = "UPDATE [member_1]\n"
				+ "SET\n"
				+ "password = ?\n"
				+ "WHERE id = ?;";

		boolean isUpdate = false;
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bean.getPassword());
			stmt.setInt(2, bean.getId());

			int i = stmt.executeUpdate();
			if (i > 0) {
				isUpdate = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdate;
	}

}
