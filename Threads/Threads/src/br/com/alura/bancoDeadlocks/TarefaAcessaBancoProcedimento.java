package br.com.alura.bancoDeadlocks;

public class TarefaAcessaBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {

		synchronized(pool) {
			System.out.println("Inicializou o pool de conexões...");
			pool.getConnection();//Conexão
			
			synchronized (tx) {
				System.out.println("Inicializou a tx...");
				tx.begin();//Transação
			}
		}
	}
}
