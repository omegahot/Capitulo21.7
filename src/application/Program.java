package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("=== test findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== test findById ====");
		Department dep = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(dep);

		list.forEach(System.out::println);
		
		System.out.println("\n=== test findAll ====");
		List<Seller> listaTudo = sellerDao.findAll();
		listaTudo.forEach(System.out::println);
		
		/*
		System.out.println("\n=== test insert ====");
		Seller newSeller = new Seller(null, "Davidy", "davidy@email.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New ID: "+ newSeller.getId());
		*/
		
		/*
		System.out.println("\n=== test update ====");
		seller = sellerDao.findById(8);
		seller.setName("Leonardo Rosalino");
		seller.setEmail("lerosalino@email.com");
		sellerDao.update(seller);
		System.out.println(seller);
		*/
		
		System.out.println("\n=== test delete ====");
		seller = sellerDao.findById(10);
		sellerDao.deleteById(seller.getId());
		System.out.println("Registro deletado.");
		
	}

}
