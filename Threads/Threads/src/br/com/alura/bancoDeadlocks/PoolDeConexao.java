package br.com.alura.bancoDeadlocks;

public class PoolDeConexao {
	
	public String getConnection() {//Classe de conexão

		System.out.println("Emprestando conexão");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "connection";
	}
}
