package tw.back.a04_Drawlost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.back.a04_Drawlost.dao.SubscribableDAOInterface;
import tw.back.a04_Drawlost.dao.SubscriptionDAO;
import tw.back.a04_Drawlost.model.SecuritiesAccount;

@Service(value = "subscriptionService")
public class SubscriptionService implements SubscribableServiceInterface {
	
	@Autowired
	private SubscribableDAOInterface subscriptionDao;

	@Override
	public List<SecuritiesAccount> selectAll() {
		// TODO Auto-generated method stub
		return subscriptionDao.selectAll();
	}

	@Override
	public SecuritiesAccount selectOne(String securitiesAccountID) {
		// TODO Auto-generated method stub
		return subscriptionDao.selectOne(securitiesAccountID);
	}

	@Override
	public Boolean insertOne(SecuritiesAccount securitiesAccount) {
		// TODO Auto-generated method stub
		return subscriptionDao.insertOne(securitiesAccount);
	}

	@Override
	public Boolean updateOne(SecuritiesAccount securitiesAccount) {
		// TODO Auto-generated method stub
		return subscriptionDao.updateOne(securitiesAccount);
	}

	@Override
	public Boolean deleteOne(String securitiesAccountID) {
		// TODO Auto-generated method stub
		return subscriptionDao.deleteOne(securitiesAccountID);
	}

}
