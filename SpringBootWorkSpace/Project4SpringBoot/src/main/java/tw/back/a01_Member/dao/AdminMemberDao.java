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
		System.out.println("list.get(0)=" + list.get(0));
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
	public boolean admin_update_member(long id, String quote, String auth, String status) {
		// TODO Auto-generated method stub
		try {
			MemberBean resultbean = em.find(MemberBean.class, id);
			resultbean.setMember_quote(quote);
			resultbean.setMember_auth(auth);
			resultbean.setMember_status(status);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Admin Dao problem");
		}
		return false;
	}

}
