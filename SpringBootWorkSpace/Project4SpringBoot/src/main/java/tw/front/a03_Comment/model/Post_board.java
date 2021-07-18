package tw.front.a03_Comment.model;

import java.sql.Blob;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import tw.front.a03_Comment.utils.FrontSystemUtils;


@Entity
@Table(name = "post_board_3")
public class Post_board {

	@OneToMany(mappedBy = "postboard")
	Set<Comment_board> commentboard = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer post_num;
	
	private String userid;
	private String postType;
	private String title;
	
	@Lob
	private String post;
	
	@Column(updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone="Asia/Taipei",pattern = "yyyy-MM-dd")
	private Date ptime;
	
	// 前端圖檔送進來java是MultipartFile java給前端是base64字串
	// base64 就是 blob+mimeType
	
	@JsonIgnore
	// 圖片太大 不會轉成JSON
	private Blob ppicture;
	
	@JsonIgnore
	private String pmimeType;
	
	// 送回前端
	@Transient   // 短暫.臨時 告訴Hibernate不要把pictureString這變數做成Column 
	// Persistence: 永續儲存
	private String  pictureString;    // data:image/gif;base64,.....
	
	// 送進來
	@Transient   // @Transient簡單講就是不要在資料庫建立欄位
	private MultipartFile postImage;
	
	public Post_board() {		
	}

	public Post_board(Integer post_num, String userid, String postType, String title, String post,Date ptime,
			Blob ppicture, String pmimeType, String pictureString, MultipartFile postImage) {
		super();
		this.post_num = post_num;
		this.userid = userid;
		this.postType = postType;
		this.title = title;
		this.post = post;
		this.ptime = new Date(System.currentTimeMillis());
		this.ppicture = ppicture;
		this.pmimeType = pmimeType;
		this.pictureString = pictureString;
		this.postImage = postImage;
	}

	public Post_board(Integer post_num, String userid, String postType, String title, String post,Date ptime,
			Blob ppicture, String pmimeType, String pictureString) {
		super();
		this.post_num = post_num;
		this.userid = userid;
		this.postType = postType;
		this.title = title;
		this.post = post;
		this.ptime = new Date(System.currentTimeMillis());
		this.ppicture = ppicture;
		this.pmimeType = pmimeType;
		this.pictureString = pictureString;
	}

	public Integer getPost_num() {
		return post_num;
	}

	public void setPost_num(Integer post_num) {
		this.post_num = post_num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getPtime() {
		return ptime;
	}
	
	// el可以抓到ptime2  el是抓getter setter裡的變數名(小寫)
//	public String getPtime2() {
//		DateFormat toFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
//		return toFormat.format(ptime);
//	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}

	public Blob getPpicture() {
		return ppicture;
	}

	public void setPpicture(Blob ppicture) {
		this.ppicture = ppicture;
	}

	public String getPmimeType() {
		return pmimeType;
	}

	public void setPmimeType(String pmimeType) {
		this.pmimeType = pmimeType;
	}

	public String getPictureString() {
		return FrontSystemUtils.blobToDataProtocol(pmimeType, ppicture);
	}

	public void setPictureString(String pictureString) {
		this.pictureString = pictureString;
	}

	public MultipartFile getPostImage() {
		return postImage;
	}

	public void setPostImage(MultipartFile postImage) {
		this.postImage = postImage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Post_board_3 [post_num=");
		builder.append(post_num);
		builder.append(", userid=");
		builder.append(userid);
		builder.append(", postType=");
		builder.append(postType);
		builder.append(", title=");
		builder.append(title);
		builder.append(", post=");
		builder.append(post);
		builder.append(", ptime=");
		builder.append(ptime);
		builder.append(", ppicture=");
		builder.append(ppicture);
		builder.append(", pmimeType=");
		builder.append(pmimeType);
		builder.append(", pictureString=");
		builder.append(pictureString);
		builder.append(", postImage=");
		builder.append(postImage);
		builder.append("hashCode=]"+hashCode());
		// 物件在記憶體的位置 判斷是不是同一個物件
		return builder.toString();
	}
	


}
