package tw.front.a01_Member.model;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tw.back.a01_Member.model.MemberJobs;

@Entity
@Table(name = "member_3")
public class MemberBean {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "不能空")
	@Column(unique = true, nullable = false)
	private String account;
	
	@NotEmpty(message = "不能空")
	@Column(nullable = false)
	private String password;
	
	@NotEmpty(message = "不能空")
	@Column(nullable = false)
	private String name;
	
	@Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message="出生日期格式不正確")
	private String birthday;
	
	private String nickname;
	
	@NotEmpty(message = "不能空")
	@Column(nullable = false)
	private String gender;
	
	@NotEmpty(message = "不能空")
	@Email(message = "要輸電子信箱")
	@Column(unique = true, nullable = false)
	private String e_mail;
	

	private String cellphone;
	
	private String address;
	
	
	@ManyToOne
	@JoinColumn(name = "jobid", nullable = true)
	private MemberJobs jobType_id;
	
	
	private String carrier;
	
	private Timestamp lastUsing;
	
	private Timestamp registertime;
	
	@JsonIgnore
	private Blob picture;
	
	@Transient 	// 短暫. 臨時    Persistence: 永續儲存
	private String pictureString;  // data:image/gif;base64,.....
	
//	前端使用memberImage 送出讓這裡處理mutipartfile類型的 Blob類型讓資料庫存取
	@Transient  // 這種類型的 不會放到DB中
	MultipartFile memberImage;
	
	private String mimeType;
	
	private String pictureFile_name;

	private String member_stock_ID; 
	private String member_quote;  
	private String member_auth;
	
	private String member_status;
	
	private String acc_encode_cookie;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public MemberJobs getJobType_id() {
		return jobType_id;
	}
	public void setJobType_id(MemberJobs jobType_id) {
		this.jobType_id = jobType_id;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public String getMember_status() {
		return member_status;
	}
	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}
	public Timestamp getLastUsing() {
		return lastUsing;
	}
	public void setLastUsing(Timestamp lastUsing) {
		this.lastUsing = lastUsing;
	}
	public Timestamp getRegistertime() {
		return registertime;
	}
	public void setRegistertime(Timestamp registertime) {
		this.registertime = registertime;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getPictureString() {
		return pictureString;
	}
	public void setPictureString(String pictureString) {
		this.pictureString = pictureString;
	}
	public MultipartFile getMemberImage() {
		return memberImage;
	}
	public void setMemberImage(MultipartFile memberImage) {
		this.memberImage = memberImage;
	}
	public String getMember_stock_ID() {
		return member_stock_ID;
	}
	public void setMember_stock_ID(String member_stock_ID) {
		this.member_stock_ID = member_stock_ID;
	}
	public String getMember_quote() {
		return member_quote;
	}
	public void setMember_quote(String member_quote) {
		this.member_quote = member_quote;
	}
	public String getMember_auth() {
		return member_auth;
	}
	public void setMember_auth(String member_auth) {
		this.member_auth = member_auth;
	}
	public String getPictureFile_name() {
		return pictureFile_name;
	}
	public void setPictureFile_name(String pictureFile_name) {
		this.pictureFile_name = pictureFile_name;
	}
	public String getAcc_encode_cookie() {
		return acc_encode_cookie;
	}
	public void setAcc_encode_cookie(String acc_encode_cookie) {
		this.acc_encode_cookie = acc_encode_cookie;
	}

}

