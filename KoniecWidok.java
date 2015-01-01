package View;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class KoniecWidok extends JFrame
{
	
	private JLabel gracz;
	private JLabel iloscPunktow;
	private JPanel panel;
	private JLabel tytul;
	
	public KoniecWidok(int numergrajacego, int liczbaPunktowGrajacego, int stanGry)
	{
		panel = new JPanel();
		
		this.setTitle("Koniec");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		
		
		if (stanGry == 1)
		{
			tytul = new JLabel ("Zwycięstwo!!!");
		}
		else
		{
			tytul = new JLabel ("Porażka:");
		}

		gracz = new JLabel (Integer.toString(numergrajacego));
		iloscPunktow = new JLabel (Integer.toString(liczbaPunktowGrajacego) + "pkt.");
		
		
		tytul.setBounds(240,10,100,40);
		gracz.setBounds(10, 50, 60, 40);
		iloscPunktow.setBounds(100, 50, 60, 40);
		
		panel.add(tytul);
		panel.add(gracz);
		panel.add(iloscPunktow);
		
		this.add(panel);
	}
}
