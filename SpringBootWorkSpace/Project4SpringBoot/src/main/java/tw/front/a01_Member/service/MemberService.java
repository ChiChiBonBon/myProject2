package tw.front.a01_Member.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.front.a01_Member.dao.IMemberDao;
import tw.front.a01_Member.model.MemberBean;

@Service
@Transactional
public class MemberService implements IMemberService {
	
	@Autowired
	private IMemberDao mDao;

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

}
