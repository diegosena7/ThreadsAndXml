package br.com.alura.banheiro;

public class Banheiro {

	private boolean ehSujo = true;

	public void fazNumero1() {

		String nome = Thread.currentThread().getName();// M�todo de acesso ao nome da Thread atual
		System.out.println(nome + " batendo na porta");

		// Atrav�s do m�todo synchronized a Thread n�o inicializa juntamente com outra
		// usando o mesmo objeto
		synchronized (this) {

			System.out.println(nome + " entrando no banheiro");

			while (ehSujo) {
				esperaLaFora(nome);
			}

			System.out.println(nome + " fazendo coisa r�pida");
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " escovando os dentes");

			sleepThread(5000);
			
			this.ehSujo = true;

			System.out.println(nome + " lavando o rosto");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();// M�todo de acesso ao nome da Thread atual
		System.out.println(nome + " batendo na porta");

		// Atrav�s do m�todo synchronized a Thread n�o inicializa juntamente com outra usando o mesmo objeto
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");

			while (ehSujo) {
				esperaLaFora(nome);
			}

			System.out.println(nome + " fazendo coisa demorada");
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " tomando banho");

			sleepThread(10000);
			
			this.ehSujo = true;
			
			this.notifyAll();//m�todo respons�vel por notificar as Threads que ela j� pode ser sexecutada ap�s a chamada do m�todo whait.
			
			System.out.println(nome + " enxugando o corpo");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	private void sleepThread(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//M�todo respons�vel por limpar o banheiro
	public void limpar() {
		
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");
		
		this.ehSujo = false;
		
		synchronized(this) {
			System.out.println(nome + " limpando o banheiro");
			
			if (!ehSujo) {
				System.out.println(nome + " est� limpando, vou sair");
				return;
			}

			try {
				Thread.sleep(13000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nome + " enxugando o bahneiro");
			System.out.println(nome + " elavando as m�os");
			System.out.println(nome + " saindo do banheiro");
		}
			
			System.out.println(nome + " entrando no banheiro");
		}

	//M�todo respons�vel por pedir que o convidado aguarde a limpeza do banheiro.
	public void esperaLaFora(String nome) {
		System.out.println(nome + " diz: ecaaa, banheiro t� sujo...");
		try {
			this.wait();//M�todo que faz a Thread aguardar para ser executada
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
