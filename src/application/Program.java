package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("INFORME O ID QUE DESEJA CONSULTAR NO DB");
		int id = sc.nextInt();
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== EXECUTANDO TESTE 1: SELLER FINDBYID ===");
		Seller seller = sellerDao.findById(id);
		System.out.println(seller);
		
		System.out.println();
		System.out.println();
		
		System.out.println("=== EXECUTANDO TESTE 2: SELLER FINDBYDEPARTMENT ===");
		Department department = new Department(id, null);
		List<Seller> listSeller = sellerDao.findByDepartment(department);
		for (Seller obj : listSeller) {
			System.out.println(obj);
		}
	}

}
