package tw.comment_3.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tw.comment_3.bean.Comment_board_3;

@Repository("socialDao")
@Transactional
@EnableTransactionManagement
public class SocialDaoImpl implements SocialDao{
	
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public Comment_board_3 findCommentByComment_num(Integer comment_num) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Comment_board_3.class, comment_num);
	}

	@Override
	public List<Comment_board_3> findAllText() {
		Session session = sessionFactory.getCurrentSession();
		Query<Comment_board_3> query = session.createQuery("from Comment_board_3",Comment_board_3.class);
		return query.list();
	
	}

	@Override
	public boolean insertComment(Comment_board_3 bean) {
		Session session = sessionFactory.getCurrentSession();
		session.save(bean);
		return true;
	}

	@Override
	public boolean deleteComment(Integer comment_num) {
		Session session = sessionFactory.getCurrentSession();
		Comment_board_3 resultBean = findCommentByComment_num(comment_num);
		if (resultBean!=null) {
			session.delete(resultBean);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateComment(Comment_board_3 bean) {
		Integer comment_num = bean.getComment_num();
		String comment = bean.getComment();
		Comment_board_3 resultBean = findCommentByComment_num(comment_num);
		if (resultBean!=null) {
			resultBean.setComment(comment);
			return true;
		}
		return false;
	}
	
	
}
