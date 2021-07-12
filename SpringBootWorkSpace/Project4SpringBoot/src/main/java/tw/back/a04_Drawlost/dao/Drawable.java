package tw.back.a04_Drawlost.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import tw.back.a04_Drawlost.model.Drawlots;

@Repository(value = "drawlotsDAO")
public interface Drawable {
	public List<Drawlots> selectAll();
	
	public Drawlots selectOne();
	
	public List<Drawlots> insertOne(Drawlots drawlots);
	
	public List<Drawlots> updateOne(Drawlots drawlots);
	
	public boolean deleteOne(Drawlots drawlots);
}
