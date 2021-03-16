package br.com.alura.threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AcaoBotao implements ActionListener {

	private JTextField primeiro;
	private JTextField segundo;
	private JLabel resultado;
	
	public AcaoBotao(JTextField primeiro, JTextField segundo, JLabel resultado) {
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.resultado = resultado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Implementa o método TarefaMultiplicacao da classe TarefaMultiplicacao que implementa a interface Runnable
		TarefaMultiplicacao tarefa = new TarefaMultiplicacao(primeiro, segundo, resultado);
		Thread threadCalculo = new Thread(tarefa, "Thread Calculadora");//Cria um objeto do tipo Thread e recebe o objeto do tipo Runnable como parâmetro
		threadCalculo.start();//Inicia a tarefa
	}
}