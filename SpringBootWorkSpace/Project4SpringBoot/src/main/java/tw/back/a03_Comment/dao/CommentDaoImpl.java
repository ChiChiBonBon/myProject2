package tw.back.a03_Comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.back.a03_Comment.model.Comment_board_3;
import tw.back.a03_Comment.model.Post_board_3;

@Repository
public class CommentDaoImpl {

	@Autowired
	EntityManager em;
	// 類似Hibernate的Session

	public CommentDaoImpl() {
		System.out.println("===CommentDaoImpl==========================================");
	}

	// 用主鍵來單筆查詢
	public Comment_board_3 findCommentByComment_num(Integer comment_num) {
		return em.find(Comment_board_3.class, comment_num);
	}

	// 查詢全部
	// 用Map<String, Object>可以回傳多種型別的資料 因為value回傳Object
	@SuppressWarnings("unchecked")
	public Map<String, Object> findBypost_num(Integer post_num) {
		Map<String, Object> map = new HashMap<>();
		Post_board_3 find = em.find(Post_board_3.class, post_num);
		String hql = "FROM Comment_board_3 WHERE postboard = :post_num";
		List<Comment_board_3> list = em.createQuery(hql)
				.setParameter("post_num", find)
				.getResultList();
		map.put("size", list.size());
		map.put("comments", list);
		System.out.println("嗨");
		System.out.println(map);
		return map;
	}
	
	// 新增
	public boolean insertComment(Comment_board_3 bean) {
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
		Comment_board_3 resultBean = em.find(Comment_board_3.class, comment_num);
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
	public boolean updateComment(Comment_board_3 bean) {
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
