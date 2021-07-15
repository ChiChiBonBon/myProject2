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
	public Drawlots selectOne(String stock_ID) {
		// TODO Auto-generated method stub
		return drawlotsDao.selectOne(stock_ID);
	}

	@Override
	public Boolean insertOne(Drawlots drawlots) {
		// TODO Auto-generated method stub
		return drawlotsDao.insertOne(drawlots);
	}

	@Override
	public Boolean updateOne(Drawlots drawlots) {
		// TODO Auto-generated method stub
		return drawlotsDao.updateOne(drawlots);
	}

	@Override
	public Boolean deleteOne(String stock_ID) {
		// TODO Auto-generated method stub
		return drawlotsDao.deleteOne(stock_ID);
	}

	@Override
	public Boolean deleteAll() {
		// TODO Auto-generated method stub
		return drawlotsDao.deleteAll();
	}
	
	/*
	public Boolean deleteAll() {
		return padao.deleteAll();
	}
	
	public Boolean delete(Integer company_ID) {
		return padao.delete(company_ID);
	}
	*/

}
