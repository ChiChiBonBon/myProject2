package tw.back.a04_Drawlost.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.back.a04_Drawlost.model.Drawlots;

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
