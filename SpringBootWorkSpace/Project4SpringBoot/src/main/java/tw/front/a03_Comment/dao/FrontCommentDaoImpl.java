package tw.front.a03_Comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.front.a03_Comment.model.Comment_board;
import tw.front.a03_Comment.model.Post_board;



@Repository
public class FrontCommentDaoImpl {

	@Autowired
	EntityManager em;
	// 類似Hibernate的Session

	public FrontCommentDaoImpl() {
		System.out.println("===FrontCommentDaoImpl==========================================");
	}

	// 用主鍵來單筆查詢
	public Comment_board findCommentByComment_num(Integer comment_num) {
		return em.find(Comment_board.class, comment_num);
	}

	// 查詢全部
	// 用Map<String, Object>可以回傳多種型別的資料 因為value回傳Object
	@SuppressWarnings("unchecked")
	public Map<String, Object> findBypost_num(Integer post_num) {
		Map<String, Object> map = new HashMap<>();
		Post_board find = em.find(Post_board.class, post_num);
		String hql = "FROM Comment_board WHERE postboard = :post_num";
		List<Comment_board> list = em.createQuery(hql)
				.setParameter("post_num", find)
				.getResultList();
		map.put("size", list.size());
		map.put("comments", list);
		System.out.println("嗨");
		System.out.println("map="+map);
		return map;
	}
	
	// 新增
	public boolean insertComment(Comment_board bean) {
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
	public boolean deleteComment(Integer comment_num) {
		Boolean result = true;
		Comment_board resultBean = em.find(Comment_board.class, comment_num);
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
	public boolean updateComment(Comment_board bean) {
		Boolean result = true;
		try {
			em.merge(bean);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
}
