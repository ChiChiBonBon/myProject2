package tw.back.a02_Order.model;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.back.a06_Company.bean.ProfitAnalysis_6;

@Repository("employeetDao")
@Transactional
public class EmployeeDAO {

	@Autowired 
    private EntityManager session;
	
	
	public  Employee insert(Employee emp) {
			emp.getEmp_acc();
			emp.getEmp_psd();
			session.persist(emp);
			System.out.println(emp);
			return emp;
	}
	
	
}
