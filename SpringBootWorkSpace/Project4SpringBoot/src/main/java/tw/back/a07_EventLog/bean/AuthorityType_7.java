package tw.back.a07_EventLog.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authorityType_7")
public class AuthorityType_7 {

	@Id
	private String authorityType;
	
	
	public String getAuthorityType() {
		return authorityType;
	}
	public void setAuthorityType(String authorityType) {
		this.authorityType = authorityType;
	}
	
	
}
