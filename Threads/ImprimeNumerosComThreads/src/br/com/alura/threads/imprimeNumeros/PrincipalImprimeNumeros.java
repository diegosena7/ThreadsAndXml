package br.com.alura.threads.imprimeNumeros;

public class PrincipalImprimeNumeros {

	public static void main(String[] args) {
		new Thread(new TarefaImprimeNumeros()).start();
		new Thread(new TarefaImprimeNumeros()).start();
	}
}
