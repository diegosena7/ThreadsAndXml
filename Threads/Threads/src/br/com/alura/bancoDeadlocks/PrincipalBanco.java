package br.com.alura.bancoDeadlocks;

public class PrincipalBanco {

	public static void main(String[] args) {

		GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();
        
        new Thread(new TarefaAcessaBanco(pool, tx)).start();//Cria e inicializa a Thread
        new Thread(new TarefaAcessaBancoProcedimento(pool, tx)).start();//Cria e inicializa a Thread
	}
}

/*O que aprendemos?
Podemos usar um bloco synchronized dentro do outro.
Ao obter os recursos, pode acontecer um impasse (interbloqueio).
O impasse também é chamado deadlock.
Podemos evitar o impasse obtendo as chaves dos objetos na mesma ordem, em todos os threads.
 */