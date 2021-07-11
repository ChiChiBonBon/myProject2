package tw.back.a03_Comment.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import tw.back.a03_Comment.dao.PostDaoImpl;
import tw.back.a03_Comment.utils.SystemUtils;

@Entity
@Table(name = "comment_board_3")
public class Comment_board_3{
	
	@ManyToOne
	@JoinColumn(name = "post_num")
	Post_board_3 postboard;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comment_num;
	
	private String userid;
	private String comment;
	
	@Column(insertable = false ,updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone="Asia/Taipei",pattern = "yyyy-MM-dd")
	private Date ctime;
	
	@JsonIgnore
	// 圖片太大 不會轉成JSON
	private Blob cpicture;
	
	@JsonIgnore
	private String cmimeType;
	
	@Transient   // 短暫.臨時 告訴Hibernate不要把pictureString這變數做成Column 
	// Persistence: 永續儲存
	private String  pictureString;    // data:image/gif;base64,.....
	
	@Transient   // @Transient簡單講就是不要在資料庫建立欄位
	private MultipartFile commentImage;
	// 檔案上傳的時候 controller收到的是MultipartFile型別的物件
	// 要跟insertRestaurant.jsp裡的<form:input path="placeImage" type='file'/> path值一樣
	
	public Comment_board_3(){
	}

	public Comment_board_3(Post_board_3 postboard, Integer comment_num, String userid, String comment,Date ctime,
			Blob cpicture, String cmimeType, String pictureString, MultipartFile commentImage) {
		super();
		this.postboard = postboard;
		this.comment_num = comment_num;
		this.userid = userid;
		this.comment = comment;
		this.ctime = new Date(System.currentTimeMillis());
		this.cpicture = cpicture;
		this.cmimeType = cmimeType;
		this.pictureString = pictureString;
		this.commentImage = commentImage;
	}

	
//	public Integer getPostboard2() {
//		return postboard.getPost_num();
//	}

	public void setPostboard(Post_board_3 postboard) {
		this.postboard = postboard;
	}
	
	public void setPostboard2(Integer postboard) {
		this.postboard = new PostDaoImpl(). findPostByPost_num(postboard);
	}

	public Post_board_3 getPostboard() {
		return postboard;
	}
	
	public Integer getComment_num() {
		return comment_num;
	}

	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCtime() {
		return ctime;
	}

	// el可以抓到ctime2  el是抓getter setter裡的變數名(小寫)
//	public String getCtime2() {
//		DateFormat toFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
//		return toFormat.format(ctime);
//	}
	
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Blob getCpicture() {
		return cpicture;
	}

	public void setCpicture(Blob cpicture) {
		this.cpicture = cpicture;
	}

	public String getCmimeType() {
		return cmimeType;
	}

	public void setCmimeType(String cmimeType) {
		this.cmimeType = cmimeType;
	}

	public String getPictureString() {
		return SystemUtils.blobToDataProtocol(cmimeType, cpicture);
	}

	public void setPictureString(String pictureString) {
		this.pictureString = pictureString;
	}

	public MultipartFile getCommentImage() {
		return commentImage;
	}

	public void setCommentImage(MultipartFile commentImage) {
		this.commentImage = commentImage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment_board_3 [postboard=");
		builder.append(postboard);
		builder.append(", comment_num=");
		builder.append(comment_num);
		builder.append(", userid=");
		builder.append(userid);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", ctime=");
		builder.append(ctime);
		builder.append(", cpicture=");
		builder.append(cpicture);
		builder.append(", cmimeType=");
		builder.append(cmimeType);
		builder.append(", pictureString=");
		builder.append(pictureString);
		builder.append(", commentImage=");
		builder.append(commentImage);
		builder.append("hashCode=]"+hashCode());
		// 物件在記憶體的位置 判斷是不是同一個物件
		return builder.toString();
	}



}
