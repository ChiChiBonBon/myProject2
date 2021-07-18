package tw.front.a04_Drawlost.dao;

import java.util.List;

import tw.back.a04_Drawlost.model.Drawlots;

public interface DrawableDAOInterface {
	
	public List<Drawlots> selectAll();
	
	public Drawlots selectOne(String stock_ID);
	
	public Boolean insertOne(Drawlots drawlots);
	
	public Boolean updateOne(Drawlots drawlots);
	
	public Boolean deleteOne(String stock_ID);
	
	public Boolean deleteAll();
}
