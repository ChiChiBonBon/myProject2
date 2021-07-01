//package tw.back.a03_Comment.model;
//
//import java.sql.Blob;
//import java.sql.Clob;
//import java.sql.Timestamp;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Table(name = "post_board_3")
//@Component("post_board_3")
//public class Post_board_3 {
//
//	@OneToMany(mappedBy = "post_board_3")
//	Set<Comment_board_3> commentboard = new HashSet<>();
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Integer post_num;
//	
//	@JsonIgnore
//	// 不會轉成JSON
//	Clob post;
//	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy年MM月dd日 HH:mm", timezone="Asia/Taipei")
//	Timestamp ptime;
//	
//	@JsonIgnore
//	// 圖片太大 不會轉成JSON
//	Blob ppicture;
//	
//	String pmimeType;
//	String userid;
//	String postType;
//	
//	@Transient   // 短暫.臨時 告訴Hibernate不要把pictureString這變數做成Column 
//	// Persistence: 永續儲存
//	String  pictureString;    // data:image/gif;base64,.....
//	
//	@Transient   // @Transient簡單講就是不要在資料庫建立欄位
//	MultipartFile postImage;
//
//	public Post_board_3() {		
//	}
//	
//	public Post_board_3(Integer post_num, Clob post, Timestamp ptime, Blob ppicture, String pmimeType, String userid,
//			String postType) {
//		super();
//		this.post_num = post_num;
//		this.post = post;
//		this.ptime = ptime;
//		this.ppicture = ppicture;
//		this.pmimeType = pmimeType;
//		this.userid = userid;
//		this.postType = postType;
//	}
//
//	public Integer getPost_num() {
//		return post_num;
//	}
//
//	public void setPost_num(Integer post_num) {
//		this.post_num = post_num;
//	}
//
//	public Clob getPost() {
//		return post;
//	}
//
//	public void setPost(Clob post) {
//		this.post = post;
//	}
//
//	public Timestamp getPtime() {
//		return ptime;
//	}
//
//	public void setPtime(Timestamp ptime) {
//		this.ptime = ptime;
//	}
//
//	public Blob getPpicture() {
//		return ppicture;
//	}
//
//	public void setPpicture(Blob ppicture) {
//		this.ppicture = ppicture;
//	}
//
//	public String getPmimeType() {
//		return pmimeType;
//	}
//
//	public void setPmimeType(String pmimeType) {
//		this.pmimeType = pmimeType;
//	}
//
//	public String getUserid() {
//		return userid;
//	}
//
//	public void setUserid(String userid) {
//		this.userid = userid;
//	}
//
//	public String getPostType() {
//		return postType;
//	}
//
//	public void setPostType(String postType) {
//		this.postType = postType;
//	}
//
//	public String getPictureString() {
//		return pictureString;
//	}
//
//	public void setPictureString(String pictureString) {
//		this.pictureString = pictureString;
//	}
//
//	public MultipartFile getPostImage() {
//		return postImage;
//	}
//
//	public void setPostImage(MultipartFile postImage) {
//		this.postImage = postImage;
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Post_board_3 [post_num=");
//		builder.append(post_num);
//		builder.append(", post=");
//		builder.append(post);
//		builder.append(", ptime=");
//		builder.append(ptime);
//		builder.append(", userid=");
//		builder.append(userid);
//		builder.append(", postType=");
//		builder.append(postType);
//		builder.append("hashCode=]"+hashCode());
//		// 物件在記憶體的位置 判斷是不是同一個物件
//		return builder.toString();
//	}
//
//}
