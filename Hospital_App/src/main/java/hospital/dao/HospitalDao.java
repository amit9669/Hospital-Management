package hospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital.dto.Hospital;

public class HospitalDao 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveHospital(Hospital hospital)
	{
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
	}
}
