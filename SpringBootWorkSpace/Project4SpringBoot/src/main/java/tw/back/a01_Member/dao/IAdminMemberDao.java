package tw.back.a01_Member.dao;

import java.util.List;

import tw.front.a01_Member.model.MemberBean;

public interface IAdminMemberDao {
	
	public MemberBean admin_select(long id);
	
	public List<MemberBean> admin_selectAll();

}
