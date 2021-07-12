package tw.back.a04_Drawlost.dao;

import java.util.List;

import tw.back.a04_Drawlost.model.Drawlots;

public interface DrawableDAOInterface {
	
	public List<Drawlots> selectAll();
	
	public Drawlots selectOne();
	
	public List<Drawlots> insertOne(Drawlots drawlots);
	
	public List<Drawlots> updateOne(Drawlots drawlots);
	
	public boolean deleteOne(Drawlots drawlots);
}
