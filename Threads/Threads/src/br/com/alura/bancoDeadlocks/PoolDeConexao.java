package br.com.alura.bancoDeadlocks;

public class PoolDeConexao {
	
	public String getConnection() {//Classe de conex�o

		System.out.println("Emprestando conex�o");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "connection";
	}
}
