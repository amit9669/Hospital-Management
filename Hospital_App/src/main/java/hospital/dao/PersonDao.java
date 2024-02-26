package hospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital.dto.Person;

public class PersonDao 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void savePerson(Person person)
	{
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
}
