package bean_5;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer courseID;
	String teacherName;
	String courseOutline;
	Date courseDate;
	Time courseTime;
	BigDecimal fee;
	Integer quota;
	String classification;
	String teachingMethod;
	String area;
	String comment;
	
	public Course() {
		
	}
	
	public Course(Integer courseID, String teacherName, String courseOutline, Date courseDate,
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
