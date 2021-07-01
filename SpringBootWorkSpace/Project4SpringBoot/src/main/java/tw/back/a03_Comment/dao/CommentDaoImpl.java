//package tw.back.a03_Comment.dao;
//
//import java.sql.Clob;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import tw.back.a03_Comment.model.Comment_board_3;
//
//
//@Repository
//public class CommentDaoImpl{
//	
//	@Autowired
//	EntityManager em;
//	//類似Hibernate的Session
//
//	public CommentDaoImpl() {
//		System.out.println("===CommentDaoImpl==========================================");
//	}
//	
//	// 用主鍵來單筆查詢
//	public Comment_board_3 findCommentByComment_num(Integer comment_num) {
//		return em.find(Comment_board_3.class, comment_num);
//	}
//
//	// 用非主鍵來做查詢
//	@SuppressWarnings("unchecked")
//	public List<Comment_board_3> findBypost_num(Integer post_num){
//		// post_num不是主鍵
//		String hql = "FROM Comment_board_3 WHERE post_num = :post_num";
//		return em.createQuery(hql)
//		         .setParameter("post_num",post_num)
//		         .getResultList(); // 同樣post_num可能會有很多筆 所以回傳List
//	}
//	
//	// 查詢全部
//	@SuppressWarnings("unchecked")
//	public List<Comment_board_3> findAllText() {
//		String hql = "FROM Comment_board_3";
//		return em.createQuery(hql).getResultList();
//	
//	}
//
//	public boolean insertComment(Comment_board_3 bean) {
//		em.persist(bean);
//		return true;
//	}
//
//	@Override
//	public boolean deleteComment(Integer comment_num) {
//		Comment_board_3 resultBean = findCommentByComment_num(comment_num);
//		if (resultBean!=null) {
//			session.delete(resultBean);
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public boolean updateComment(Comment_board_3 bean) {
//		Integer comment_num = bean.getComment_num();
//		Clob comment = bean.getComment();
//		Comment_board_3 resultBean = findCommentByComment_num(comment_num);
//		if (resultBean!=null) {
//			resultBean.setComment(comment);
//			return true;
//		}
//		return false;
//	}
//	
//	
//}
