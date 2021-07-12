package tw.back.a04_Drawlost.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tw.back.a04_Drawlost.model.Drawlots;

public interface DrawableServiceInterface {
	public List<Drawlots> selectAll();
	
	public Drawlots selectOne();
	
	public List<Drawlots> insertOne(Drawlots drawlots);
	
	public List<Drawlots> updateOne(Drawlots drawlots);
	
	public boolean deleteOne(Drawlots drawlots);
}
