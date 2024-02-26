package hospital.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MedItemsDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveMedItems(MedItems medItems)
	{
		entityTransaction.begin();
		entityManager.persist(medItems);
		entityTransaction.commit();
	}
	
	public void getAllMedItems()
	{
	  Query query = entityManager.createQuery("select m from MedItems m") ;
	  List <MedItems> list = query.getResultList();
	  System.out.println(list);
	}
}
