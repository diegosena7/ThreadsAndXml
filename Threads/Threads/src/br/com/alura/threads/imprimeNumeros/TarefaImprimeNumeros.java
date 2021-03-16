package br.com.alura.threads.imprimeNumeros;

public class TarefaImprimeNumeros implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {

			Thread threadAtual = Thread.currentThread();
			System.out.println(threadAtual.getId() + " - " + i);

		}
	}
}

/*
O que aprendemos?
Java suporta Threads nativamente
Java mapeia os Threads para o Sistema Operacional
A ordem de execu��o depende da JVM e n�o do nosso c�digo
*/