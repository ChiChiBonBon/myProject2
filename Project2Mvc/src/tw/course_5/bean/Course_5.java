package tw.course_5.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "course_5")
@Component(value = "course")
public class Course_5 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	Integer autoID;
	
	@Column(name="Course_ID")
	Integer courseID;
	
	@Column(name="Teacher_Name")
	String teacherName;
	
	@Column(name="Course_Outline")
	String courseOutline;
	
	@Column(name="Course_Date")
	Date courseDate;
	
	@Column(name="Course_time")
	Time courseTime;
	
	@Column(name="Fee")
	BigDecimal fee;
	
	@Column(name="Quota")
	Integer quota;
	
	@Column(name="Classification")
	String classification;
	
	@Column(name="Teaching_Method")
	String teachingMethod;
	
	@Column(name="Area")
	String area;
	
	@Column(name="Comment")
	String comment;
	
	public Course_5() {
		
	}
	
	public Course_5(Integer courseID, String teacherName, String courseOutline, Date courseDate,
			Time courseTime, BigDecimal fee, Integer quota, String classification, String teachingMethod, String area,
			String comment) {
		
		this.courseID = courseID;
		this.teacherName = teacherName;
		this.courseOutline = courseOutline;
		this.courseDate = courseDate;
		this.courseTime = courseTime;
		this.fee = fee;
		this.quota = quota;
		this.classification = classification;
		this.teachingMethod = teachingMethod;
		this.area = area;
		this.comment = comment;
	}
	
	public Integer getCourseID() {
		return courseID;
	}
	
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}

	public String getTeacherName() {
		return teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public String getCourseOutline() {
		return courseOutline;
	}
	
	public void setCourseOutline(String courseOutline) {
		this.courseOutline = courseOutline;
	}
	
	public Date getCourseDate() {
		return courseDate;
	}
	
	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}
	
	public Time getCourseTime() {
		return courseTime;
	}
	
	public void setCourseTime(Time courseTime) {
		this.courseTime = courseTime;
	}
	
	public BigDecimal getFee() {
		return fee;
	}
	
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	
	public Integer getQuota() {
		return quota;
	}
	
	public void setQuota(Integer quota) {
		this.quota = quota;
	}
	
	public String getClassification() {
		return classification;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public String getTeachingMethod() {
		return teachingMethod;
	}
	
	public void setTeachingMethod(String teachingMethod) {
		this.teachingMethod = teachingMethod;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
