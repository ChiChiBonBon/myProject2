package tw.back.a01_Member.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public List<MemberBean> admin_selectAll() {
		// TODO Auto-generated method stub
		TypedQuery<MemberBean> query = em.createQuery("from MemberBean", MemberBean.class);
		return query.getResultList();
		
	}

}
