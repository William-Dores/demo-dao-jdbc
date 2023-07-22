package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("INFORME O ID DO DEPARTAMENTO QUE DESEJA CONSULTAR");
		int id = sc.nextInt();
		
		DepartmentDao departmentDao = DaoFactory.createDepartmenteDao();
		
		System.out.println("=== EXECUTANDO TEST 1: DEPARTMENT FINDBYID ===");
		Department department = departmentDao.findById(id);
		System.out.println(department);
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("=== EXECUTAND TEST 2: DEPARTMENT FINDALL ===");
		List<Department> listDepartments = departmentDao.findAll();
		for (Department department2 : listDepartments) {
			System.out.println(department2);
		}
		
		
		System.out.println();
		System.out.println();
		
		System.out.println("=== EXECUTANDO TESTE 3: DEPARTMENT INSERT ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("INSERTED! NEW ID = " + newDepartment.getId());
		
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("=== EXECUTANDO TESTE 4: DEPARTMENT UPDATE");
		department = departmentDao.findById(4);
		department.setName("Food");
		departmentDao.update(department);
		System.out.println("UPDATE COMPLETED"); 
		
		
		System.out.println();
		System.out.println();
		
		System.out.println("=== EXECUTANDO TESTE 5: DEPARTMENT DELETE ===");
		departmentDao.deleteById(8);
		System.out.println("DELETE COMPLETED");
		
	}

}
