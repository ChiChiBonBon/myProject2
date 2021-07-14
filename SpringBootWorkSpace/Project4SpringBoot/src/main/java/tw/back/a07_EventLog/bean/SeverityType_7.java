package tw.back.a07_EventLog.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "severityType_7")
public class SeverityType_7 {
	

	@Id
	private String severityType;
	
	
	
	public String getSeverityType() {
		return severityType;
	}

	public void setSeverityType(String severityType) {
		this.severityType = severityType;
	}

	
	
	
}
