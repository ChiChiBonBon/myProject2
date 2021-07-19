package tw.front.a01_Member.service;


import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a01_Member.model.MemberJobs;
import tw.back.a01_Member.service.IAdminMemberService;
import tw.front.a01_Member.dao.IMemberDao;
import tw.front.a01_Member.model.MemberBean;

@Service
@Transactional
public class MemberService implements IMemberService {
	
	@Autowired
	private IMemberDao mDao;
	
	@Autowired
	private IAdminMemberService adminservice;

	public MemberService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public MemberBean member_checkAccount(String account, String password) {
		// TODO Auto-generated method stub
		return mDao.member_checkAccount(account, password);
	}

	@Override
	public int member_createAccount(MemberBean bean) {
		// TODO Auto-generated method stub
		return mDao.member_insert(bean);
	}

	@Override
	public int member_updateAccount(MemberBean bean) {
		// TODO Auto-generated method stub
		if (bean.getJobType_id() == null) {
			System.out.println("here: (bean.getJobType_id()" + bean);
			return mDao.member_updateAccount(bean);
		} else if (bean.getJobType_id() != null) {
			MemberJobs memberjob = adminservice.admin_selectJob(bean.getJobType_id().getJob_id());
			bean.setJobType_id(memberjob);
		}
		return mDao.member_updateAccount(bean);
	}

	@Override
	public boolean member_updatePassword(long id, String password) {
		// TODO Auto-generated method stub
		return mDao.member_updatePassword(id, password);
	}

	@Override
	public boolean member_deleteAccount(long id) {
		// TODO Auto-generated method stub
		return mDao.member_delete(id);
	}

	@Override
	public MemberBean member_member_info(long id) {
		// TODO Auto-generated method stub
		return mDao.member_select(id);
	}

	@Override
	public String check_unique(String column, String value, String origin_value) {
		// TODO Auto-generated method stub
		return mDao.check_unique(column, value, origin_value);
	}

	@Override
	public String check_unique(String column, String value) {
		// TODO Auto-generated method stub
		return mDao.check_unique(column, value);
	}

	@Override
	public boolean check_cookie(String cookie_value) {
		// TODO Auto-generated method stub
//		System.out.println("check_cookie service cookie:  " + cookie_value);
		return mDao.check_cookie(cookie_value);
	}

	@Override
	public MemberBean member_checkAccount_email(String email, String password) {
		// TODO Auto-generated method stub
		return mDao.member_checkAccount_email(email, password);
	}

	@Override
	public boolean member_updateTime(long id, Timestamp timestamp) {
		// TODO Auto-generated method stub
		return mDao.member_updateTime(id, timestamp);
	}
}
