package tw.back.a02_Order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity 
@Table(name = "employee")
@Component("employee")
public class Employee {
	
	@Id 
	@Column(name = "emp_ID")
	private String  emp_ID ;
	
	@Column(name = "emp_acc")
	private String emp_acc;
	
	@Column(name = "emp_psd")
	private String emp_psd;

	
//建構子
	public Employee() {
	}

	public Employee(String emp_ID  ,String emp_acc, String emp_psd) {
		this.emp_ID  = emp_ID ;
		this.emp_acc = emp_acc;
		this.emp_psd = emp_psd;
	}

//get and set 
	public String getEmp_ID() {
		return emp_ID;
	}

	public void setEmp_ID(String emp_ID) {
		this.emp_ID = emp_ID;
	}

	public String getEmp_acc() {
		return emp_acc;
	}

	public void setEmp_acc(String emp_acc) {
		this.emp_acc = emp_acc;
	}

	public String getEmp_psd() {
		return emp_psd;
	}

	public void setEmp_psd(String emp_psd) {
		this.emp_psd = emp_psd;
	}
	
	
	
}
