package tw.back.a04_Drawlost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.back.a04_Drawlost.dao.DrawableDAOInterface;
import tw.back.a04_Drawlost.dao.DrawlotsDAO;
import tw.back.a04_Drawlost.model.Drawlots;

@Service(value = "drawlotsService")
public class DrawlotsService implements DrawableServiceInterface {

	@Autowired
	private DrawableDAOInterface drawlotsDao = new DrawlotsDAO();
	
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
