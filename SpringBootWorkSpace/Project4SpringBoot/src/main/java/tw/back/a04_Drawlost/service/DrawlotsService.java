package tw.back.a04_Drawlost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.back.a04_Drawlost.dao.DrawlotsDAO;
import tw.back.a04_Drawlost.model.Drawlots;

public class DrawlotsService implements Drawable {

	@Autowired
	private DrawlotsDAO drawlotsDao;
	
	@Override
	public List<Drawlots> selectAll() {
		// TODO Auto-generated method stub
		return drawlotsDao.selectAll();
	}

	@Override
	public Drawlots selectOne() {
		// TODO Auto-generated method stub
		return drawlotsDao.selectOne();
	}

	@Override
	public List<Drawlots> insertOne(Drawlots drawlots) {
		// TODO Auto-generated method stub
		return drawlotsDao.insertOne(drawlots);
	}

	@Override
	public List<Drawlots> updateOne(Drawlots drawlots) {
		// TODO Auto-generated method stub
		return drawlotsDao.updateOne(drawlots);
	}

	@Override
	public boolean deleteOne(Drawlots drawlots) {
		// TODO Auto-generated method stub
		return drawlotsDao.deleteOne(drawlots);
	}

}
