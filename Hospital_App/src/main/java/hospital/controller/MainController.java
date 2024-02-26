package hospital.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hospital.dao.BranchDao;
import hospital.dao.EncounterDao;
import hospital.dao.HospitalDao;
import hospital.dao.MedOrderDao;
import hospital.dao.PersonDao;
import hospital.dto.Address;
import hospital.dto.Branch;
import hospital.dto.Encounter;
import hospital.dto.Hospital;
import hospital.dto.MedItems;
import hospital.dto.MedItemsDao;
import hospital.dto.MedOrder;
import hospital.dto.Person;

public class MainController {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in) ;
		System.out.println("1.Visit to Hospital and Branch : \n2.Add Person : \n3.Save Disease :  \n4.Information About Medicine :  \n5.Save Medicine Shifts : \n6.Add Diesase ID with shift ID : ");
		int choice = scanner.nextInt();
		
		Hospital hospital = new Hospital();
		HospitalDao hDao = new HospitalDao();
		Branch branch = new Branch();
		BranchDao bDao = new BranchDao();
		Address address = new Address();
		
		Person person = new Person();
		PersonDao pDao = new PersonDao();
		
		Encounter encounter = new Encounter();
		EncounterDao eDao = new EncounterDao();
		
		MedOrder medOrder = new MedOrder();
		MedOrderDao mDao = new MedOrderDao();
		
		MedItems medItems = new MedItems();
		MedItemsDao miDao = new MedItemsDao();
		
			switch (choice) {
			case 1:
			{
				System.out.println();
				System.out.println("1.Save Hospital : \n2.Add Branch : \n3.Find Branch : \n4.Delete Branch : \n5.View Branch : ");
				int key = scanner.nextInt();
				switch (key) {
				case 1:
				{
					System.out.println("Enter Hospital Name : ");
					String name = scanner.next();
					hospital.setName(name);
					hDao.saveHospital(hospital);
				}
				break;
				case 2:
				{
					System.out.println("Enter Branch Location : ");
					String location = scanner.next();
					branch.setLocation(location);
					
					System.out.println("Enter Hospital ID : ");
					int hid = scanner.nextInt();
					System.out.println("Enter Address : ");
					String address1 = scanner.next();
					System.out.println("Enter Pincode : ");
					int pincode = scanner.nextInt();
					address.setAddress(address1);
					address.setPincode(pincode);
					branch.setAddress(address);
					branch.getHospital();
					bDao.saveBranch(branch,hid); 
				}
				break ;
				case 3:
				{
					System.out.println("Enter Id To Find The Branch : ");
					int id = scanner.nextInt();			
					bDao.findBranch(id);
				}
				break;
				case 4://------->>>Exception
				{
					System.out.println("Enter The ID To Delete The Branch : ");
					int id = scanner.nextInt();					
					bDao.deleteBranch(id);
				}
				break;
				case 5:
				{
					bDao.viewBranches();
				}
				default:
				break;
				}
			}
			break;
			case 2:
			{
				System.out.println("Enter Patient Name : ");
				String name = scanner.next();
				System.out.println("Enter Patient Phone Number : ");
				long phone = scanner.nextLong();
				System.out.println("Enter Patient Address : ");
				String address1 = scanner.next();
				
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address1);				
				pDao.savePerson(person);	
			}
			break ;
			case 3:
			{
				System.out.println("Enter Disease : ");
				String diseaseName = scanner.next();				
				System.out.println("Enter The Person ID To Who's Addicted This Disease : ");
				int pid = scanner.nextInt();
				
				encounter.setDisese(diseaseName);
				eDao.saveDisease(encounter, pid);
			}
			break ;
			case 4:
			{
				System.out.println("Enter the Choice \n1.save Medicine: ");
				int key = scanner.nextInt();
				switch (key) {
				case 1:
				{
					System.out.println("Enter the Medicine Name : ");
					medItems.setName(scanner.next());
					System.out.println("Enter the Medicine Cost : ");
					medItems.setMedcost(scanner.nextDouble());
					miDao.saveMedItems(medItems);
				}
				break;
				default:
				break;
				}
			}
			break;
			case 5:
			{
				miDao.getAllMedItems();
				
				System.out.println("How many Medicine add in shift?");
				int size = scanner.nextInt();
				List<Integer> ids = new ArrayList<Integer>();
				
				for (int i = 1; i <=size; i++) 
				{
					System.out.println("Enter the Medicine ID : ");
					ids.add(scanner.nextInt()) ;
				}
				
				System.out.println("Enter the Shift : ");
				 medOrder.setShift(scanner.next());
				 mDao.saveMedOrders(medOrder, ids);
			}
			break ;
			case 6:
			{
				eDao.getAllDisease();
				
				System.out.println("Select Diesase Id To Add Shift : ");
				int id = scanner.nextInt();
				
                List<Integer> ids = new ArrayList<Integer>();
				
				for (int i = 1; i <=id; i++) 
				{
					System.out.println("Enter the ID : ");
					ids.add(scanner.nextInt()) ;
				}
				System.out.println("Enter the shift ID : ");
				encounter.setId(scanner.nextInt());
				eDao.addDisease(encounter, ids);
				
			}
			default:
			break;
			}

	}
}
