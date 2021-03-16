package br.com.alura.banheiro;

public class Principal {

	public static void main(String[] args) {
		
		Banheiro benheiro = new Banheiro();

		Thread convidado1 = new Thread(new TarefaNumero1(benheiro), "Diego");
		Thread convidado2 = new Thread(new TarefaNumero2(benheiro), "Ryan");
		Thread convidado3 = new Thread(new TarefaNumero2(benheiro), "Nayara");
		Thread convidado4 = new Thread(new TarefaNumero2(benheiro), "Ted");
		
		convidado1.start();
		convidado2.start();
		convidado3.start();
		convidado4.start();
	}
}

/*
 * O que aprendemos?

Um Thread pode ter um nome;
Podemos pegar o Thread atual através do método Thread.currentThread();
Para sincronizar threads, devemos utilizar um bloco synchronized;
O synchronized significa que bloqueamos o objeto para outros threads;
A sincronização é feita através de mutex, que nada mais é do que a chave do objeto.
*/