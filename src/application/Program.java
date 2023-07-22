package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
		
		System.out.println();
		System.out.println();
		
		
		
		System.out.println("=== EXECUTANDO TESTE 3: SELLER FINDALL ===");
		listSeller = sellerDao.findAll();
		for (Seller obj : listSeller) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("=== EXECUTANDO TESTE 4: SELLER INSERT ===");
		//PARA FINS DIDATICOS NÃO IREI ESTÁ OBTENDO AINDA O QUE O USUARIO DIGITAR, ENTÃO A INSERÇÃO SERA FEITA DE FORMA MANUAL AQUI NO CONSOLE =)  
		Seller newSeller = new Seller(null, "Greg", "gregGgmail", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("INSERTED! NEW ID = " + newSeller.getId()); 
		
		System.out.println();
		System.out.println();
		
		System.out.println("=== EXECUTANDO TESTE 5: SELLER UPDATE ===");
		seller = sellerDao.findById(12);
		seller.setEmail("greg@gmail.com");
		sellerDao.update(seller);
		System.out.println("UPDATE COMPLETED!");
		
		System.out.println();
		System.out.println();

		System.out.println("=== EXECUTANDO TESTE 6: SELLER DELETE ===");
		sellerDao.deleteById(18);
		System.out.println("DELETE COMPLETED");
	}
}
