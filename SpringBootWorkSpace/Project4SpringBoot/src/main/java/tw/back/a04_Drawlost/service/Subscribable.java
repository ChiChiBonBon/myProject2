package tw.back.a04_Drawlost.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tw.back.a04_Drawlost.model.SecuritiesAccount;

@Service(value = "subscriptionService")
public interface Subscribable {
	public List<SecuritiesAccount> selectAll();
	
	public SecuritiesAccount selectOne();
	
	public List<SecuritiesAccount> insertOne(SecuritiesAccount securitiesAccount);
	
	public List<SecuritiesAccount> updateOne(SecuritiesAccount securitiesAccount);
	
	public boolean deleteOne(SecuritiesAccount securitiesAccount);
}
