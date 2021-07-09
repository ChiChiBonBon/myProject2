package tw.back.a03_Comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.back.a03_Comment.model.Post_board_3;

@Repository
public class PostDaoImpl {

	@Autowired
	EntityManager em;

	public PostDaoImpl() {
		System.out.println("===PostDaoImpl==========================================");
	}

	// 用主鍵來單筆查詢
	public Post_board_3 findPostByPost_num(Integer post_num) {
		return em.find(Post_board_3.class, post_num);
	}

	// 查詢全部
	// 用Map<String, Object>可以回傳多種型別的資料 因為value回傳Object
	@SuppressWarnings("unchecked")
	public Map<String, Object> findAllPost() {
		Map<String, Object> map = new HashMap<>();

		String hql = "FROM Post_board_3";
		List<Post_board_3> list = em.createQuery(hql).getResultList();
		map.put("size", list.size());
		map.put("posts", list);
		System.out.println("查全部post DAO");
		return map;
	}

	
	// 新增
	public boolean insertPost(Post_board_3 bean) {
		Boolean result = true;
		try {
			em.persist(bean);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	// 刪除
	public boolean deletePost(Integer post_num) {
		Boolean result = true;
		Post_board_3 resultBean = em.find(Post_board_3.class, post_num);
		if (resultBean != null) {
			try {
				em.remove(resultBean);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return result;
	}

	// 修改
	public boolean updatePost(Post_board_3 bean) {
		Boolean result = true;
		try {
			em.merge(bean);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	// 用非主鍵來做查詢
	@SuppressWarnings("unchecked")
	public Map<String, Object> findBypostType(String postType) {
		Map<String, Object> map = new HashMap<>();

		// postType不是主鍵
		String hql = "FROM Post_board_3 WHERE postType = :postType";

		List<Post_board_3> list = em.createQuery(hql).setParameter("postType", postType).getResultList();
		// 同樣Type可能會有很多筆 所以回傳List
		map.put("size", list.size());
		map.put("list", list);
		return map;
	}
}
