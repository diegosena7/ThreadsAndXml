package br.com.alura.threads;

public class RespostaMain {

	public static void main(String[] args) {

		ImprimeString tarefaString = new ImprimeString();
		Thread thread = new Thread(tarefaString);
		thread.start();
		
		//Thread com classe anônima
		new Thread(new Runnable() {
			
			@Override
			public void run() {
			System.out.println("Usando thread com classe anônima. Nesse caso o compilador gera uma classe anônima"
					+ "que implementa a interface. É uma forma mais enxuta de usar a tarefa");
			}
		}).start();
	}
}

/*
 			O que aprendemos?
Através das Threads podemos executar tarefas em paralelo;
Uma classe que implementa a interface Runnable define a tarefa que o Thread executará;
O construtor da classe Thread recebe esse Runnable;
Devemos inicializar uma Thread explicitamente através do método start();
Através do Thread.sleep(millis) podemos mandar uma thread dormir.
 */