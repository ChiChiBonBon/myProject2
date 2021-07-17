package tw.back.a04_Drawlost.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tw.back.a04_Drawlost.model.SecuritiesAccount;

public interface SubscribableServiceInterface {
	public List<SecuritiesAccount> selectAll();
	
	public SecuritiesAccount selectOne(String securitiesAccountID);
	
	public Boolean insertOne(SecuritiesAccount securitiesAccount);
	
	public Boolean updateOne(SecuritiesAccount securitiesAccount);
	
	public Boolean deleteOne(String securitiesAccountID);
}
