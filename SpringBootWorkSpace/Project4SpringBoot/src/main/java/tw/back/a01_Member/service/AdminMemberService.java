package tw.back.a01_Member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a01_Member.dao.IAdminMemberDao;
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
	public List<MemberBean> admin_selectAllMember() {
		// TODO Auto-generated method stub
		return adminDao.admin_selectAll();
	}

}
