package br.com.alura.threads;

public class RespostaMain {

	public static void main(String[] args) {

		ImprimeString tarefaString = new ImprimeString();
		Thread thread = new Thread(tarefaString);
		thread.start();
		
		//Thread com classe an�nima
		new Thread(new Runnable() {
			
			@Override
			public void run() {
			System.out.println("Usando thread com classe an�nima. Nesse caso o compilador gera uma classe an�nima"
					+ "que implementa a interface. � uma forma mais enxuta de usar a tarefa");
			}
		}).start();
	}
}

/*
 			O que aprendemos?
Atrav�s das Threads podemos executar tarefas em paralelo;
Uma classe que implementa a interface Runnable define a tarefa que o Thread executar�;
O construtor da classe Thread recebe esse Runnable;
Devemos inicializar uma Thread explicitamente atrav�s do m�todo start();
Atrav�s do Thread.sleep(millis) podemos mandar uma thread dormir.
 */