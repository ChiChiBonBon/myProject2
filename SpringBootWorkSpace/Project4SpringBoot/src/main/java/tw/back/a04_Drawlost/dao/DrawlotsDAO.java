package tw.back.a04_Drawlost.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a04_Drawlost.model.Drawlots;
import tw.back.a06_Company.bean.ProfitAnalysis_6;

@Transactional
@Repository(value = "drawlotsDAO")
public class DrawlotsDAO implements DrawableDAOInterface {

	@Autowired
	private EntityManager em;
	
	@SuppressWarnings(value = "unchecked" )
	public List<Drawlots> selectAll() {
		// TODO Auto-generated method stub
		
		Query query = em.createQuery("from Drawlots",Drawlots.class);
	
		return query.getResultList();
	}

	@Override
	public Drawlots selectOne(String stock_ID) {
		// TODO Auto-generated method stub
		Drawlots drawlots = em.find(Drawlots.class, stock_ID);
		return drawlots;
	}

	@Override
	public Boolean insertOne(Drawlots drawlots) {
		// TODO Auto-generated method stub
		Boolean result = false;
		try {
			em.persist(drawlots);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean updateOne(Drawlots drawlots) {
		// TODO Auto-generated method stub
		Boolean result = true;
		try {
			em.merge(drawlots);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	@Override
	public Boolean deleteOne(String stock_ID) {
		// TODO Auto-generated method stub
		Boolean result = true;
		Drawlots drawlots = em.find(Drawlots.class, stock_ID);
		if(drawlots != null) {
			try {
				em.remove(drawlots);
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
		}
		return result;
	}

	@Override
	public Boolean deleteAll() {
		// TODO Auto-generated method stub
		Boolean result = false;
		String sql = "delete from Drawlots";
		
		try {
			em.createQuery(sql).executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
