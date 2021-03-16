package br.com.alura.lista;

public class Lista {

	private String[] elementos = new String[1000];//Lista fixa com valores do array
	private int indice = 0;

	public void adicionaElementos(String elemento) {
		
		synchronized (this) {
			this.elementos[indice] = elemento;
			this.indice++;
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (indice == this.elementos.length) {
			System.out.println("lista tá cheia, notificando");
			this.notify();//Notificia um único Thread
		}
	}

	public int tamanho() {
		return this.elementos.length;//retorna o tamanho do array
	}

	public String pegaElemento(int posicao) {
		return this.elementos[posicao];//retorna o índice pela posiçao do array
	}
}
