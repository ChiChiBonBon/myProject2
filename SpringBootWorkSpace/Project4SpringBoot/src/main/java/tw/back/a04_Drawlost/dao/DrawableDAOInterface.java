package tw.back.a04_Drawlost.dao;

import java.util.List;

import tw.back.a04_Drawlost.model.Drawlots;

public interface DrawableDAOInterface {
	
	public List<Drawlots> selectAll();
	
	public Drawlots selectOne(Integer stock_ID);
	
	public Boolean insertOne(Drawlots drawlots);
	
	public Boolean updateOne(Drawlots drawlots);
	
	public Boolean deleteOne(Integer stock_ID);
	
	public Boolean deleteAll();
}
