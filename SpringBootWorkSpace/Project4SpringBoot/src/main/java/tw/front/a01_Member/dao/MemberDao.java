package tw.front.a01_Member.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.front.a01_Member.model.MemberBean;

@Repository("memberdao")
public class MemberDao implements IMemberDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public int member_insert(MemberBean bean) {
		// TODO Auto-generated method stub
		int isInsert = 0;
		try {
			em.persist(bean);
			isInsert = 1;
//			set success
		} catch (Exception e) {
			e.printStackTrace();
			String eString = e.toString();
			System.out.println("estring:::  " + eString);
//			if (eString.contains("member_1.account_UNIQUE")) {
//				isInsert = -1;
////				表示 SQL unique error account		
//			} else if (eString.contains("member_1.e_mail_UNIQUE")) {
//				isInsert = -2;
////				表示 SQL unique error e_mail
//			}
		}
		System.out.println("create account status: " + isInsert);
		return isInsert;
	}

	@Override
	public MemberBean member_checkAccount(String account, String password) {
		// TODO Auto-generated method stub
		String hqlString = "from MemberBean m where m.account = :account_insert"; // MemberBean 這邊是指javabean的
		TypedQuery<MemberBean> query = em.createQuery(hqlString, MemberBean.class);
		
		query.setParameter("account_insert", account);
		
		List<MemberBean> resultlist = query.getResultList();
		System.out.println(resultlist);

//		判斷密碼
		if (!resultlist.isEmpty()) {
			System.out.println("resultlist: not null");
			if (password.equals(resultlist.get(0).getPassword())) {
//				
//				確定帳號是否激活 
//				if (resultlist.get(0).getMember_status().equals("activated")) {
//					return resultlist.get(0);
//				}
				return resultlist.get(0);
			}
//			密碼不一樣 返回空值
			return null;
		}
		return null;
	}

	@Override
	public int member_updateAccount(MemberBean bean) {
		// TODO Auto-generated method stub
		int isUpdate = 1;
		MemberBean resultbean = em.find(MemberBean.class, bean.getId());
		if (resultbean != null) {
		try {
			resultbean.setAccount(bean.getAccount());
			resultbean.setName(bean.getName());
			resultbean.setBirthday(bean.getBirthday());
			resultbean.setNickname(bean.getNickname());
			resultbean.setGender(bean.getGender());
			resultbean.setE_mail(bean.getE_mail());
			resultbean.setCellphone(bean.getCellphone());
			resultbean.setAddress(bean.getAddress());
			resultbean.setJob(bean.getJob());
			resultbean.setCarrier(bean.getCarrier());
			
			resultbean.setPicture(bean.getPicture());
			resultbean.setMimeType(bean.getMimeType());
			
			isUpdate = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
//			String eString = e.toString();
//			if (eString.contains("member_1.account_UNIQUE")) {
//				isUpdate = -1;
////				表示 SQL unique error account		
//			} else if (eString.contains("member_1.e_mail_UNIQUE")) {
//				isUpdate = -2;
////				表示 SQL unique error e_mail
//			} else if (eString.contains("member_1.cellphone_UNIQUE")) {
//				isUpdate = -3;
////				表示 SQL unique error cellphone
//			}
		}
		}
		return isUpdate;
	}

	@Override
	public boolean member_updatePassword(long id, String password) {
		// TODO Auto-generated method stub
		MemberBean resultbean = em.find(MemberBean.class, id);
		if (resultbean != null) {
			resultbean.setPassword(password);
			return true;
		}
		return false;
	}

	@Override
	public boolean member_delete(long id) {
		// TODO Auto-generated method stub
		MemberBean resultbean = em.find(MemberBean.class, id);
		if (resultbean != null) {
			resultbean.setMember_status("deleted");
			return true;
		}
		return false;
	}

	@Override
	public MemberBean member_select(long id) {
		// TODO Auto-generated method stub
		return em.find(MemberBean.class, id);
	}

}
