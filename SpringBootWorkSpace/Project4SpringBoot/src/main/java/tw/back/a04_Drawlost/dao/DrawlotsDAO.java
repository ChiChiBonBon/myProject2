package tw.back.a04_Drawlost.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import tw.back.a04_Drawlost.model.Drawlots;

public class DrawlotsDAO implements Drawable {

	@Autowired
	private EntityManager em;
	
	@Override
	public List<Drawlots> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Drawlots selectOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Drawlots> insertOne(Drawlots drawlots) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Drawlots> updateOne(Drawlots drawlots) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOne(Drawlots drawlots) {
		// TODO Auto-generated method stub
		return false;
	}

}
