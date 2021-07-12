package tw.back.a04_Drawlost.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import tw.back.a04_Drawlost.model.SecuritiesAccount;

public class SubscriptionDAO implements Subscribable {
	
	@Autowired
	private EntityManager em;
	
	@Override
	public List<SecuritiesAccount> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecuritiesAccount selectOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecuritiesAccount> insertOne(SecuritiesAccount securitiesAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecuritiesAccount> updateOne(SecuritiesAccount securitiesAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOne(SecuritiesAccount securitiesAccount) {
		// TODO Auto-generated method stub
		return false;
	}

}
