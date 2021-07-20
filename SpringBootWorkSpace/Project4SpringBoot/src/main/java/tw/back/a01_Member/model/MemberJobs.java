package tw.back.a01_Member.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "member_3_jobs")
public class MemberJobs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long job_id;
	
	@Column(unique = true, nullable = false)
	private String job;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createDate;
	
//	@OneToMany(mappedBy = "jobType_id", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
//	Set<MemberBean> members = new HashSet<>();
	
	   
	public MemberJobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getJob_id() {
		return job_id;
	}
	public void setJob_id(Long job_id) {
		this.job_id = job_id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
