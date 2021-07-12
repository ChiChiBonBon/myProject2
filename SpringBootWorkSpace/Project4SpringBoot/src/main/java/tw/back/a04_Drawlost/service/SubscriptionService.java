package tw.back.a04_Drawlost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.back.a04_Drawlost.dao.SubscriptionDAO;
import tw.back.a04_Drawlost.model.SecuritiesAccount;

public class SubscriptionService implements Subscribable {
	
	@Autowired
	private SubscriptionDAO subscriptionDao;

	@Override
	public List<SecuritiesAccount> selectAll() {
		// TODO Auto-generated method stub
		return subscriptionDao.selectAll();
	}

	@Override
	public SecuritiesAccount selectOne() {
		// TODO Auto-generated method stub
		return subscriptionDao.selectOne();
	}

	@Override
	public List<SecuritiesAccount> insertOne(SecuritiesAccount securitiesAccount) {
		// TODO Auto-generated method stub
		return subscriptionDao.insertOne(securitiesAccount);
	}

	@Override
	public List<SecuritiesAccount> updateOne(SecuritiesAccount securitiesAccount) {
		// TODO Auto-generated method stub
		return subscriptionDao.updateOne(securitiesAccount);
	}

	@Override
	public boolean deleteOne(SecuritiesAccount securitiesAccount) {
		// TODO Auto-generated method stub
		return subscriptionDao.deleteOne(securitiesAccount);
	}

}
