package br.com.alura.bancoDeadlocks;

public class TarefaAcessaBanco implements Runnable {

	private GerenciadorDeTransacao tx;
	private PoolDeConexao pool;

	public TarefaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		
		synchronized (pool) {
			System.out.println("Conex�o inicializada...");
			pool.getConnection();//Conex�o
			
			synchronized(tx) {
				System.out.println("Inicializou o gerenciamento de transa��es...");
				tx.begin();//Transa��o
			}
		}
	}
}
