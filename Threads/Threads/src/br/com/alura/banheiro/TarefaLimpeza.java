package br.com.alura.banheiro;

public class TarefaLimpeza implements Runnable {

	private Banheiro banheiro;

	public TarefaLimpeza(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {

		while (true) {
			banheiro.limpar();

			sleepThread(2000);
		}
	}

	private void sleepThread(long milis) {
		try {
			Thread.sleep(milis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
