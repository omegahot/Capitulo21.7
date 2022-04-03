package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println("==== teste insert ====");
		Department newDep = new Department(null, "Sales");
		//departmentDao.insert(newDep);
		//System.out.println(newDep.getId());
		
		System.out.println("==== teste findByID ====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("==== teste update ====");
		dep.setId(6);
		dep.setName("Manutenção");
		departmentDao.update(dep);
		
		System.out.println("==== teste findAll ====");
		List<Department> lista = departmentDao.findAll();
		lista.forEach(System.out::println);
		
		System.out.println("==== teste delete ====");
		//departmentDao.deleteById(6);
		
		
	}

}
