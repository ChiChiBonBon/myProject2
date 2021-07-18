package tw.front.a01_Member.dao;

import tw.front.a01_Member.model.MemberBean;

public interface IMemberDao {

	public int member_insert(MemberBean bean);
	
	public MemberBean member_checkAccount(String account, String password);
	
	public int member_updateAccount(MemberBean bean);
	
	public boolean member_updatePassword(long id, String password);
	
	public boolean member_delete(long id);
	
	public MemberBean member_select(long id);
	
	public String check_unique(String column, String value, String origin_value);
	
	public String check_unique(String column, String value);
	
	public boolean check_cookie(String cookie_value);
}
