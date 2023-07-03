package db;

public class DbIntregrityExecption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbIntregrityExecption(String msg){
		super(msg);
		System.out.println("PODE DELETAR ISSO AI NAO DOIDO!!!");
	}

}
