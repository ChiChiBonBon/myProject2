package tw.back.a03_Comment.service;

import org.springframework.transaction.annotation.Transactional;

import tw.back.a03_Comment.dao.PostDaoImpl;
import tw.back.a03_Comment.model.Post_board_3;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostServiceImpl {

	@Autowired
	PostDaoImpl postDao;
	
	// 全部
	public Map<String, Object> findAllPost(){
		return postDao.findAllPost();
	}
	
	// 單筆查
	public Post_board_3 findPostByPost_num(Integer post_num) {
		return postDao.findPostByPost_num(post_num);
	}
	
	// 新增
	public boolean insertPost(Post_board_3 bean) {
		return postDao.insertPost(bean);
	}
	
	// 刪除
	public boolean deletePost(Integer post_num) {
		return postDao.deletePost(post_num);
	}

	// 修改
	public boolean updatePost(Post_board_3 bean) {
		System.out.println("updatePost Service控制器");
		return postDao.updatePost(bean);
	}
}
