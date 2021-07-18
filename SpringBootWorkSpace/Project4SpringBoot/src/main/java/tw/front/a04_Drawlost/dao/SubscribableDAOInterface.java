package tw.front.a04_Drawlost.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import tw.back.a04_Drawlost.model.SecuritiesAccount;


public interface SubscribableDAOInterface {
	public List<SecuritiesAccount> selectAll();
	
	public SecuritiesAccount selectOne(String securitiesAccountID);
	
	public Boolean insertOne(SecuritiesAccount securitiesAccount);
	
	public Boolean updateOne(SecuritiesAccount securitiesAccount);
	
	public Boolean deleteOne(String securitiesAccountID);
}
