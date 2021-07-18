package tw.front.a04_Drawlost.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tw.back.a04_Drawlost.model.Drawlots;

public interface DrawableServiceInterface {
	public List<Drawlots> selectAll();
	
	public Drawlots selectOne(String stock_ID);
	
	public Boolean insertOne(Drawlots drawlots);
	
	public Boolean updateOne(Drawlots drawlots);
	
	public Boolean deleteOne(String stock_ID);
	
	public Boolean deleteAll();
}
