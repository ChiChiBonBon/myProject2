package tw.front.a01_Member.dao;

import java.sql.Timestamp;
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
				
//				要獲取 Java 中的當前時間戳，可以使用 Timestamp 類。由於此類沒有預設的建構函式
//				，因此我們以毫秒為單位傳遞時間。我們使用 System 類的 currentTimeMillis() 方法獲取時間。
		        Long datetime = System.currentTimeMillis();
		        Timestamp timestamp = new Timestamp(datetime);
				resultlist.get(0).setLastUsing(timestamp);
				
//				確定密碼符合後 插入當前時間然後存入
				em.persist(resultlist.get(0));
				
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
		int re = 0;
		try {
			em.merge(bean);
			re = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return re;
	}
//		int isUpdate = 0;
//		MemberBean resultbean = em.find(MemberBean.class, bean.getId());
//		if (resultbean != null) {
//		try {
//			resultbean.setAccount(bean.getAccount());
//			resultbean.setName(bean.getName());
//			resultbean.setBirthday(bean.getBirthday());
//			resultbean.setNickname(bean.getNickname());
//			resultbean.setGender(bean.getGender());
//			resultbean.setE_mail(bean.getE_mail());
//			resultbean.setCellphone(bean.getCellphone());
//			resultbean.setAddress(bean.getAddress());
//			
//
////			用存入的 jobType_id.job_id 找出完整的 job 再放入 jobType_id field 中
//			MemberJobs memberjob = adminservice.admin_selectJob(bean.getJobType_id().getJob_id());
//			resultbean.setJobType_id(null);
//			resultbean.setJobType_id(memberjob);
//			
//			
//			resultbean.setCarrier(bean.getCarrier());
//			
//			resultbean.setPicture(bean.getPicture());
//			resultbean.setMimeType(bean.getMimeType());
//			
//			isUpdate = 1;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		}
//		return isUpdate;
//	}

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

	@Override
	public String check_unique(String column, String value, String origin_value) {
		// TODO Auto-generated method stub
//		因為這邊程式內建輸入進去的column值 所以不會有sql語法 攻擊的問題
		String hqlString = "from MemberBean m where " + column + "= :value_insert"; // MemberBean 這邊是指javabean的
		TypedQuery<MemberBean> query = em.createQuery(hqlString, MemberBean.class);
		
		query.setParameter("value_insert", value);
		
		List<MemberBean> resultlist = query.getResultList();
		System.out.println(resultlist);
		
//		判斷是否有使用過 假如新輸入的跟原本的一樣 也返回可以使用
		System.out.println("New: " + value + " old: " + origin_value);
		if (resultlist.isEmpty() || origin_value.equals(value)) {
			System.out.println("可以使用");
			return "1";
		} 
		System.out.println("不可以使用");
		return "0";
	}

	@Override
	public String check_unique(String column, String value) {
		// TODO Auto-generated method stub
//		因為這邊程式內建輸入進去的column值 所以不會有sql語法 攻擊的問題
		String hqlString = "from MemberBean m where " + column + "= :value_insert"; // MemberBean 這邊是指javabean的
		TypedQuery<MemberBean> query = em.createQuery(hqlString, MemberBean.class);
		
		query.setParameter("value_insert", value);
		
		List<MemberBean> resultlist = query.getResultList();
		System.out.println(resultlist);
		
//		判斷是否有使用過 假如新輸入的跟原本的一樣 也返回可以使用
		System.out.println("New: " + value);
		if (resultlist.isEmpty()) {
			System.out.println("可以使用");
			return "1";
		} 
		System.out.println("不可以使用");
		return "0";
	}

	@Override
	public boolean check_cookie(String cookie_value) {
		// TODO Auto-generated method stub
		System.out.println("Here check_cookie dao");
		String hqlString = "from MemberBean m where m.acc_encode_cookie = :account_cookie_insert"; // MemberBean 這邊是指javabean的
		TypedQuery<MemberBean> query = em.createQuery(hqlString, MemberBean.class);
		
		System.out.println("Dao insert attribute");
		query.setParameter("account_cookie_insert", cookie_value);
		
		List<MemberBean> resultlist = query.getResultList();
		System.out.println("cookie_result_dao:    " + resultlist);
		if (resultlist.isEmpty()) {
			return false;
		}
		return true;
	}
}
