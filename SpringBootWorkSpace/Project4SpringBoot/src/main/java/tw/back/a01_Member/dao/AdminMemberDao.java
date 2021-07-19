package tw.back.a01_Member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.back.a01_Member.model.MemberJobs;
import tw.front.a01_Member.model.MemberBean;
import tw.front.a01_Member.utils.SystemUtils;

@Repository("adminmemberdao")
public class AdminMemberDao implements IAdminMemberDao {
	
	@Autowired
	private EntityManager em;


	@Override
	public MemberBean admin_select(long id) {
		// TODO Auto-generated method stub
		return em.find(MemberBean.class, id);
	}

	@Override
	public Map<String, Object> admin_selectAllMember() {
		// TODO Auto-generated method stub
		TypedQuery<MemberBean> query = em.createQuery("from MemberBean", MemberBean.class);
		List<MemberBean> list = query.getResultList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("size", list.size()); 
		map.put("list", list); 
		return map;	
	}

	@Override
	public List<MemberJobs> admin_selectAll_jobs() {
		// TODO Auto-generated method stub
		TypedQuery<MemberJobs> query = em.createQuery("from MemberJobs", MemberJobs.class);
		return query.getResultList();
	}

	@Override
	public MemberJobs admin_selectJob(long id) {
		// TODO Auto-generated method stub
		return em.find(MemberJobs.class, id);
	}

	@Override
	public int admin_update_member(long id, String quote, String auth, String status) {
		// TODO Auto-generated method stub
		try {
			MemberBean resultbean = em.find(MemberBean.class, id);
			resultbean.setMember_quote(quote);
			resultbean.setMember_auth(auth);
			resultbean.setMember_status(status);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Admin Dao problem");
		}
		return 0;
	}

	@Override
	public boolean change_status_byEmail(String member_cookieValue) {
		// TODO Auto-generated method stub
		String hqlString = "from MemberBean m where m.acc_encode_cookie = :cookie_find"; // MemberBean 這邊是指javabean的
		TypedQuery<MemberBean> query = em.createQuery(hqlString, MemberBean.class);
		query.setParameter("cookie_find", member_cookieValue);
		List<MemberBean> resultlist = query.getResultList();
		if (!resultlist.isEmpty()) {
			System.out.println("resultlist: not null");
			MemberBean member_target = resultlist.get(0);
			
			MemberBean resultbean = em.find(MemberBean.class, member_target.getId());
			resultbean.setMember_status("activated");
			System.out.println("member activated done");
			return true;
		}
		return false;
	}

	@Override
	public String check_email_to_resetPassword(String email) {
		// TODO Auto-generated method stub
		String hqlString = "from MemberBean m where m.e_mail = :email_find"; // MemberBean 這邊是指javabean的
		TypedQuery<MemberBean> query = em.createQuery(hqlString, MemberBean.class);
		query.setParameter("email_find", email);
		List<MemberBean> resultlist = query.getResultList();
		if (!resultlist.isEmpty()) {
			MemberBean member_target = resultlist.get(0);
			MemberBean resultbean = em.find(MemberBean.class, member_target.getId());
			
			String newRandomPass = SystemUtils.generateRandomPassword().toString();
			String newEncodePass = SystemUtils.encodePassword(newRandomPass);
			resultbean.setPassword(newEncodePass);
			System.out.println("Change Password!");
			return newRandomPass;
		}
		return "None";
	}

}
