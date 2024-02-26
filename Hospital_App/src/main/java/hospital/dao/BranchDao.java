package hospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital.dto.Branch;
import hospital.dto.Hospital;

public class BranchDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveBranch(Branch branch,int hid)
	{
		Hospital hospital = entityManager.find(Hospital.class, hid) ;
		if(hospital!=null)
		{
			branch.setHospital(hospital);
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("This "+hid+" id not available");
		}
	}
	
	public void findBranch(int id)
	{
		Branch branch = entityManager.find(Branch.class, id) ;
		if(branch != null)
		{
			System.out.println(branch);
		}
		else
		{
			System.out.println("This "+id+" id not available");
		}
	}
	
	public void deleteBranch(int id)
	{
		Branch branch = entityManager.find(Branch.class, id) ;
		if(branch != null)
		{
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("This "+id+" id not available");
		}
	}
	public void viewBranches()
	{
		Query query = entityManager.createQuery("select b from Branch b") ;
		System.out.println(query.getResultList());
	}
}
