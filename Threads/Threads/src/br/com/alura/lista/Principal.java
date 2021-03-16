package br.com.alura.lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		//Abaixo 2 formas de usar lista com Thread sincronizadas
		List<String> lista = Collections.synchronizedList(new ArrayList<>());
		//List<String> lista = new Vector<String>();
		
		for(int i = 0; i < 10; i++) {//Adicionando 10 Threads
			new Thread(new TarefaAdicionarElemento(lista, i)).start();//Cria e inicializa a Thread
		}
		Thread.sleep(2000);
		
		for(int i = 0; i < lista.size(); i ++) {//Percorre a lista e imprime a posi��o do �ndice
			System.out.println(i + " - " + lista.get(i));
		}
	}
}

/*
O que aprendemos?
Ao modificar o objeto concorrentemente, coisas inesperadas podem aparecer;
Thread safe significa que o c�digo funciona corretamente mesmo com v�rios threads compartilhando o objeto;
H� cole��es thread safe, como o java.util.Vector para lista ou java.util.Hashtable para mapas.
wait() e notify() sempre devem ser chamados dentro de um bloco synchronized;
Temos que ter cuidado para n�o mandar um thread esperar quando n�o h� necessidade;
*/
