package tw.back.a01_Member.service;

import java.util.List;

import tw.front.a01_Member.model.MemberBean;

public interface IAdminMemberService {
	
	public MemberBean admin_selectMember(long id);
	
	public List<MemberBean> admin_selectAllMember();

}
