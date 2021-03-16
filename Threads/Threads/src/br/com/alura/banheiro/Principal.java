package br.com.alura.banheiro;

public class Principal {

	public static void main(String[] args) {
		
		Banheiro benheiro = new Banheiro();

		Thread convidado1 = new Thread(new TarefaNumero1(benheiro), "Diego");
		Thread convidado2 = new Thread(new TarefaNumero2(benheiro), "Ryan");
		Thread limpeza = new Thread(new TarefaLimpeza(benheiro), "Limpeza");
		limpeza.setDaemon(true);//M�todo respons�vel por passar para o start a Threar chamada enquantou outras Threads estiverem rodando
		
//		Thread convidado3 = new Thread(new TarefaNumero2(benheiro), "Nayara");
//		Thread convidado4 = new Thread(new TarefaNumero2(benheiro), "Ted");
		
		convidado1.start();
		convidado2.start();
		limpeza.setPriority(Thread.MAX_PRIORITY);//Usamos para dar prioridade a Thread de limpeza dentre as demais Threads
		limpeza.start();
//		convidado3.start();
//		convidado4.start();
	}
}

/*
 * O que aprendemos?
Uma Thread pode ter um nome;
Podemos pegar o Thread atual atrav�s do m�todo Thread.currentThread();
Para sincronizar threads, devemos utilizar um bloco synchronized;
O synchronized significa que bloqueamos o objeto para outros threads;
A sincroniza��o � feita atrav�s de mutex, que nada mais � do que a chave do objeto.

Ao chamar object.wait() a thread fica no estado de espera
estado de espera significa WAITING no mundo de threads
uma thread esperando pode ser notificada pelo m�todo object.notifyAll()
existem daemon threads para executar tarefas ou servi�os secund�rios
daemons ser�o automaticamente desligados quando todas as outras threads terminarem
*/

/*Threads daemon s�o como prestadores de servi�os para outras threads.
 * Elas s�o usadas para dar apoio � tarefas e s� s�o necess�rias rodar quando as threads
 * "normais" ainda est�o sendo executadas. Uma thread daemon n�o impede a JVM de terminar
 * desde que n�o existem mais threads principais em execu��o.*/
 