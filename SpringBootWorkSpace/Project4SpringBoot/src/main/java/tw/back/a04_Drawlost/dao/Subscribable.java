package tw.back.a04_Drawlost.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import tw.back.a04_Drawlost.model.SecuritiesAccount;

@Repository(value = "subscriptionService")
public interface Subscribable {
	public List<SecuritiesAccount> selectAll();
	
	public SecuritiesAccount selectOne();
	
	public List<SecuritiesAccount> insertOne(SecuritiesAccount securitiesAccount);
	
	public List<SecuritiesAccount> updateOne(SecuritiesAccount securitiesAccount);
	
	public boolean deleteOne(SecuritiesAccount securitiesAccount);
}
