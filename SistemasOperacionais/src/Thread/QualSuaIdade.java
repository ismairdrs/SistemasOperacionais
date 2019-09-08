package Thread;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class QualSuaIdade extends JFrame{

	JLabel tempo = new JLabel("0");
	JLabel tempo2 = new JLabel("0");
	JLabel idade = new JLabel();
	int segundos =0;
	int segundos2 =0;
	
	public QualSuaIdade() 
	{
		editarLayout();
		new contartempo(200,1).start();
		new contartempo(2000,2).start();
		mostrarMensagem();
		
	}
	
	public void editarLayout()
	{
		Font fonte = new Font("Arial", Font.BOLD, 50);
		Font fonte2 = new Font("Arial", Font.BOLD, 30);
		Font fonte3 = new Font("Arial", Font.BOLD, 30);
		
		add(BorderLayout.NORTH, tempo);
		add(BorderLayout.CENTER, idade);
		add(BorderLayout.AFTER_LAST_LINE, tempo2);
		
		tempo.setHorizontalAlignment(SwingConstants.CENTER);
		idade.setHorizontalAlignment(SwingConstants.CENTER);
		tempo2.setHorizontalAlignment(SwingConstants.LEFT);
		
		idade.setFont(fonte);
		tempo.setFont(fonte2);
		tempo2.setFont(fonte3);
		
		
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void mostrarMensagem()
	{
		int anoNasc = Integer.parseInt(JOptionPane.showInputDialog("Em que ano você nasceu?"));
		int anoAtual = Integer.parseInt(JOptionPane.showInputDialog("Em que ano estamos?"));
		int resultado = anoAtual-anoNasc;
		idade.setText("Sua idade é: "+resultado);
		JOptionPane.showMessageDialog(null, "Você gastou " +segundos+" segundos para responder!");
	}
	
	public static void main(String[] args)
	{
		new QualSuaIdade();
	}
	
	public class contartempo extends Thread
	{
		private int tempox;
		private int label;
		public contartempo(int tempo, int label)
		{
			this.tempox = tempo;
			this.label = label;
		}
		public void run()
		{
			while(true)
			{
				try 
				{
					Thread.sleep(tempox);
				}catch (Exception e) {}
				
				if(this.label==1) {
				segundos++;
				tempo.setText(segundos+"");
				}else {
					segundos2++;;
					tempo2.setText(segundos2+"");
				}
			}
		}
	}
}
