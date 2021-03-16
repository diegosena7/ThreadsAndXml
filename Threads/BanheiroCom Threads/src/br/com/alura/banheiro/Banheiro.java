package br.com.alura.banheiro;

public class Banheiro {

	public void fazNumero1() {
		
		String nome = Thread.currentThread().getName();// Método de acesso ao nome da Thread atual
		System.out.println(nome + " batendo na porta");

		//Através do método synchronized a Thread não inicializa juntamente com outra usando o mesmo objeto
		synchronized (this) {
			System.out.println(nome + " fazendo coisa rápida");
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " escovando os dentes");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(nome + " lavando o rosto");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();// Método de acesso ao nome da Thread atual
		System.out.println(nome + " batendo na porta");

		//Através do método synchronized a Thread não inicializa juntamente com outra usando o mesmo objeto
		synchronized (this) {
			System.out.println(nome + " fazendo coisa demorada");
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " tomando banho");

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nome + " enxugando o corpo");
			System.out.println(nome + " saindo do banheiro");
		}
	}
}
