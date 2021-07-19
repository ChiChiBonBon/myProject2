package tw.back.a01_Member.service;

import java.util.List;
import java.util.Map;

import tw.back.a01_Member.model.MemberJobs;
import tw.front.a01_Member.model.MemberBean;

public interface IAdminMemberService {
	
	public MemberBean admin_selectMember(long id);
	
	public Map<String, Object> admin_selectAllMember();
	
	public List<MemberJobs> admin_selectAll_jobs();
	
	public MemberJobs admin_selectJob(long id);

	public int admin_update_member(long id, String quote, String auth, String status);
	
	public boolean change_status_byEmail(String member_cookieValue);
	
	public String check_email_to_resetPassword(String email);
}
