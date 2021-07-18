package tw.front.a01_Member.service;

import tw.front.a01_Member.model.MemberBean;

public interface IMemberService {
	
	public MemberBean member_checkAccount(String account, String password);

	public int member_createAccount(MemberBean bean);
	
	public int member_updateAccount(MemberBean bean);
	
	public boolean member_updatePassword(long id, String password);

	boolean member_deleteAccount(long id);
	
	public MemberBean member_member_info(long id);
	
	public String check_unique(String column, String value, String origin_value);
	
	public String check_unique(String column, String value);
	
	public boolean check_cookie(String cookie_value);

}
