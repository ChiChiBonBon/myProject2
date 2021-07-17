package tw.back.a04_Drawlost.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a04_Drawlost.model.Drawlots;
import tw.back.a04_Drawlost.model.SecuritiesAccount;

@Transactional
@Repository(value = "subscriptionDAO")
public class SubscriptionDAO implements SubscribableDAOInterface {
	
	@Autowired
	private EntityManager em;
	
	@Override
	@SuppressWarnings(value = "unchecked" )
	public List<SecuritiesAccount> selectAll() {
		// TODO Auto-generated method stub
		
		Query query = em.createQuery("from SecuritiesAccount",SecuritiesAccount.class);
		
		return query.getResultList();
	}

	@Override
	public SecuritiesAccount selectOne(String securitiesAccountID) {
		// TODO Auto-generated method stub
		
		SecuritiesAccount securitiesAccount = em.find(SecuritiesAccount.class, securitiesAccountID);
		return securitiesAccount;
	}

	@Override
	public Boolean insertOne(SecuritiesAccount securitiesAccount) {
		// TODO Auto-generated method stub
		
		Boolean result = false;
		try {
			em.persist(securitiesAccount);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public  Boolean  updateOne(SecuritiesAccount securitiesAccount) {
		// TODO Auto-generated method stub
		
		Boolean result = true;
		try {
			em.merge(securitiesAccount);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	@Override
	public Boolean deleteOne(String securitiesAccountID) {
		// TODO Auto-generated method stub
		
		Boolean result = true;
		SecuritiesAccount securitiesAccount = em.find(SecuritiesAccount.class,securitiesAccountID);
		if(securitiesAccount!= null) {
			try {
				em.remove(securitiesAccount);
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
		}
		return result;
	}

}
