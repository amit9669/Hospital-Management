package hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital.dto.Encounter;
import hospital.dto.MedItems;
import hospital.dto.MedOrder;
import hospital.dto.Person;

public class EncounterDao 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveDisease(Encounter encounter, int pid)
	{
		Person person = entityManager.find(Person.class, pid) ;
		if(person!=null)
		{
			encounter.setPerson(person);
			entityTransaction.begin();
			entityManager.persist(encounter);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("This "+pid+" id not available");
		}
	}
	
	public void getAllDisease()
	{
		Query query = entityManager.createQuery("select e from Encounter e") ;
		List <MedItems> list = query.getResultList();
		  System.out.println(list);
	}
	
	public void addDisease(Encounter encounter,List<Integer> ids)
	{
		List<MedOrder> list = new ArrayList<MedOrder>();
		for(Integer id : ids)
		{
			MedOrder medOrder = entityManager.find(MedOrder.class, id) ;
			list.add(medOrder);
		}
		encounter.setMedOrders(list);
		entityTransaction.begin();
		entityManager.persist(encounter);
		entityTransaction.commit();
	}
}
