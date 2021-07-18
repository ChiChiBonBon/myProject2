package tw.back.a01_Member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a01_Member.dao.IAdminMemberDao;
import tw.back.a01_Member.model.MemberJobs;
import tw.front.a01_Member.model.MemberBean;

@Service
@Transactional
public class AdminMemberService implements IAdminMemberService {
	
	@Autowired
	private IAdminMemberDao adminDao;

	@Override
	public MemberBean admin_selectMember(long id) {
		// TODO Auto-generated method stub
		return adminDao.admin_select(id);
	}

	@Override
	public Map<String, Object> admin_selectAllMember() {
		// TODO Auto-generated method stub
		return adminDao.admin_selectAllMember();
	}

	@Override
	public List<MemberJobs> admin_selectAll_jobs() {
		// TODO Auto-generated method stub
		return adminDao.admin_selectAll_jobs();
	}

	@Override
	public MemberJobs admin_selectJob(long id) {
		// TODO Auto-generated method stub
		return adminDao.admin_selectJob(id);
	}

	@Override
	public boolean admin_update_member(long id, String quote, String auth, String status) {
		// TODO Auto-generated method stub
		return adminDao.admin_update_member(id, quote, auth, status);
	}

}
