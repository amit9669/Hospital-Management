package hospital.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital.dto.MedItems;
import hospital.dto.MedOrder;

public class MedOrderDao 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveMedOrders(MedOrder medOrder,List<Integer> ids)
	{
		List<MedItems> list = new ArrayList<MedItems>();
		for(Integer id : ids)
		{
			MedItems medItems = entityManager.find(MedItems.class, id) ;
			list.add(medItems);
		}
		medOrder.setMedItems(list);
		entityTransaction.begin();
		entityManager.persist(medOrder);
		entityTransaction.commit();
	}
}
