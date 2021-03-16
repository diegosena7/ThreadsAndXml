package br.com.alura.banheiro;

public class Principal {

	public static void main(String[] args) {
		
		Banheiro benheiro = new Banheiro();

		Thread convidado1 = new Thread(new TarefaNumero1(benheiro), "Diego");
		Thread convidado2 = new Thread(new TarefaNumero2(benheiro), "Ryan");
		Thread limpeza = new Thread(new TarefaLimpeza(benheiro), "Limpeza");
		limpeza.setDaemon(true);//Método responsável por passar para o start a Threar chamada enquantou outras Threads estiverem rodando
		
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
Podemos pegar o Thread atual através do método Thread.currentThread();
Para sincronizar threads, devemos utilizar um bloco synchronized;
O synchronized significa que bloqueamos o objeto para outros threads;
A sincronização é feita através de mutex, que nada mais é do que a chave do objeto.

Ao chamar object.wait() a thread fica no estado de espera
estado de espera significa WAITING no mundo de threads
uma thread esperando pode ser notificada pelo método object.notifyAll()
existem daemon threads para executar tarefas ou serviços secundários
daemons serão automaticamente desligados quando todas as outras threads terminarem
*/

/*Threads daemon são como prestadores de serviços para outras threads.
 * Elas são usadas para dar apoio à tarefas e só são necessárias rodar quando as threads
 * "normais" ainda estão sendo executadas. Uma thread daemon não impede a JVM de terminar
 * desde que não existem mais threads principais em execução.*/
 