package tw.front.a03_Comment.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.front.a03_Comment.dao.FrontPostDaoImpl;
import tw.front.a03_Comment.model.Post_board;

@Service
@Transactional
public class FrontPostServiceImpl {

	@Autowired
	FrontPostDaoImpl postDao;
	
	// 全部
	public Map<String, Object> findAllPost(){
		return postDao.findAllPost();
	}
	
	// 單筆查
	public Post_board findPostByPost_num(Integer post_num) {
		return postDao.findPostByPost_num(post_num);
	}
	
	// 新增
	public boolean insertPost(Post_board bean) {
		return postDao.insertPost(bean);
	}
	
	// 刪除
	public boolean deletePost(Integer post_num) {
		return postDao.deletePost(post_num);
	}

	// 修改
	public boolean updatePost(Post_board bean) {
		System.out.println("updatePost Service控制器");
		return postDao.updatePost(bean);
	}
	
	public Map<String, Object> queryBypostType(String postType) {
		return postDao.queryBypostType(postType);
	}
}
