package tw.back.a03_Comment.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comment_board_3")
@Component("comment_board_3")
public class Comment_board_3{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer comment_num;
	
	@JsonIgnore
	// 不會轉成JSON
	Clob comment;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy年MM月dd日 HH:mm", timezone="Asia/Taipei")
	Timestamp ctime;
	
	@JsonIgnore
	// 圖片太大 不會轉成JSON
	Blob cpicture;
	
	String cmimeType;
	String userid;
	Integer post_num;
	
	@Transient   // 短暫.臨時 告訴Hibernate不要把pictureString這變數做成Column 
	// Persistence: 永續儲存
	String  pictureString;    // data:image/gif;base64,.....
	
	@Transient   // @Transient簡單講就是不要在資料庫建立欄位
	MultipartFile commentImage;
	// 檔案上傳的時候 controller收到的是MultipartFile型別的物件
	// 要跟insertRestaurant.jsp裡的<form:input path="placeImage" type='file'/> path值一樣
	
	public Comment_board_3(){
	}

	public Comment_board_3(Integer comment_num, Clob comment, Timestamp ctime, Blob cpicture, String cmimeType,
			String userid, Integer post_num) {
		super();
		this.comment_num = comment_num;
		this.comment = comment;
		this.ctime = ctime;
		this.cpicture = cpicture;
		this.cmimeType = cmimeType;
		this.userid = userid;
		this.post_num = post_num;
	}

	public Integer getComment_num() {
		return comment_num;
	}

	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}

	public Clob getComment() {
		return comment;
	}

	public void setComment(Clob comment) {
		this.comment = comment;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getPost_num() {
		return post_num;
	}

	public void setPost_num(Integer post_num) {
		this.post_num = post_num;
	}

	public String getPictureString() {
		return pictureString;
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
		builder.append("Comment_board_3 [comment_num=");
		builder.append(comment_num);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", ctime=");
		builder.append(ctime);
		builder.append(", userid=");
		builder.append(userid);
		builder.append(", post_num=");
		builder.append(post_num);
		builder.append("hashCode=]"+hashCode());
		// 物件在記憶體的位置 判斷是不是同一個物件
		return builder.toString();
	}

}
