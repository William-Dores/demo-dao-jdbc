package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	/*AQUI É */
	private static Connection conn = null;
	
	
	/*AQUI CONECTA AI BANCO DE DADOS*/
	public static Connection getConnection() {
		if(conn == null){
			try {
				Properties props = loadProperties();
				/*É DB URL PORQUE É O QUE ESTÁ DEFIINIDO NO ARQUIVO DB.PROPERTIES*/
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
				System.out.println("CONNECTED DB SUCESSFULLY");
				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
		return conn;
	}
	
	/*AQUI FINALIZA A CONEXÃO COM O BANCO DE DADOS*/
	
	public static void closeConnectionDB() {
		/*AQUI ESTÁ TESTANDO SE A CONEXÃO ESTÁ INSTANCIADA, OU SEJA SE ESTÁ CONECTADA AO BANCO DE DADOS*/
		if (conn != null) {
			try {
				conn.close();
				System.out.println("DESCONNECTD DB SUCESSFULLY");
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}	
	}
	
	/*AQUI LER OS ARQUIVOS QUE ESTÁ SALVO DENTRO DA DO ARQUIVO db.properties*/
	private static Properties loadProperties(){ 
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
	}catch (IOException e) {
		throw new DbException(e.getMessage());
	}
 }
	
	public static void closeStatement(Statement st){
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	
}
