package tw.front.a03_Comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.front.a03_Comment.model.Post_board;


@Repository
public class FrontPostDaoImpl {

	@Autowired
	EntityManager em;

	public FrontPostDaoImpl() {
		System.out.println("===FrontPostDaoImpl==========================================");
	}

	// 用主鍵來單筆查詢
	public Post_board findPostByPost_num(Integer post_num) {
		return em.find(Post_board.class, post_num);
	}

	// 查詢全部
	// 用Map<String, Object>可以回傳多種型別的資料 因為value回傳Object
	@SuppressWarnings("unchecked")
	public Map<String, Object> findAllPost() {
		Map<String, Object> map = new HashMap<>();

		String hql = "FROM Post_board";
		List<Post_board> list = em.createQuery(hql).getResultList();
		map.put("size", list.size());
		map.put("posts", list);
		System.out.println("查全部post DAO");
		return map;
	}

	
	// 新增
	public boolean insertPost(Post_board bean) {
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
		Post_board resultBean = em.find(Post_board.class, post_num);
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
	public boolean updatePost(Post_board bean) {
		Boolean result = true;
		System.out.println("updatePost dao控制器");
		try {
			em.merge(bean);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	// 用餐廳名字模糊查詢
	public Map<String, Object> queryBypostType(String postType) {
		Map<String, Object> map = new HashMap<>();

		String hql = "FROM Post_board WHERE postType like :postType";
		
		List<Post_board> list = em.createQuery(hql, Post_board.class)
				.setParameter("postType",postType)
				.getResultList();
		map.put("size", list.size());
		map.put("posts", list);
		return map;
	}
	
}
