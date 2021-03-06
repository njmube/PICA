package co.com.kallsonys.oms.backend.dao.oracle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import co.com.kallsonys.oms.backend.entity.oracle.Campana;


public class CampanaDao {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("KallSonysOms-backend-oracle");
	
	public  List<Campana> getAllCampanas(){
		List<Campana> campanas = null;
		try{
			EntityManager entitymanager = emfactory.createEntityManager( );
			Query query = entitymanager.createNamedQuery("Campana.findAll");
			campanas =  query.getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return campanas;
	}
	
	public  void actualizarCampanas( Campana c ){
		EntityManager entitymanager = emfactory.createEntityManager( );
		try{
			entitymanager.getTransaction().begin();
			Campana campana = entitymanager.find(Campana.class, c.getIdcampana());
			
			campana.setDescripcion(c.getDescripcion());
			campana.setFechafinal(c.getFechafinal());
			campana.setFechainicial(c.getFechainicial());
			campana.setSubtitulocampana(c.getSubtitulocampana());
			campana.setTitulocampana(c.getTitulocampana());
			campana.setUrlimagen(c.getUrlimagen());
			entitymanager.getTransaction().commit();
		}catch( Exception e ){
			e.printStackTrace();
		}
		finally{
			entitymanager.close();
	    }
	}
	
	public void eliminarCampana( Campana c ){
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction().begin();
		Campana campana = entitymanager.find(Campana.class, c.getIdcampana());
		entitymanager.remove(campana);
		entitymanager.getTransaction().commit();
	}
	
}
