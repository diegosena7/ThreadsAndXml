package br.com.alura.bancoDeadlocks;

public class GerenciadorDeTransacao {

	public void begin() {//Gerencia a conex�o

		System.out.println("Come�ando a transa��o");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
