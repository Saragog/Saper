package View;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


public class MenuWidok extends JFrame
{
	private JTextField liczbaPoziom = new JTextField(10);
	private JLabel napis1 = new JLabel("Podaj liczbę pól w poziomie: ");
	private JTextField liczbaPion = new JTextField(10);
	private JLabel napis2 = new JLabel("Podaj liczbę pól w pionie: ");
	private JTextField liczbaMin = new JTextField(10);
	private JLabel napis3 = new JLabel("Podaj liczbę min: ");
	

	
	private JButton przyciskZatwierdz = new JButton ("Zatwierdz");
	
	private JPanel panel;
	
	public MenuWidok()
	{
		panel = new JPanel();
		
		this.setTitle("SaperMenu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(530, 225);
		
		panel.setLayout(null);
		panel.setBackground(Color.RED);
		
		napis1.setBounds(10, 10, 240, 40);
		panel.add(napis1);

		liczbaPoziom.setBounds(240, 15, 30, 30);
		panel.add(liczbaPoziom);
		
		napis2.setBounds(10, 50, 240, 40);
		panel.add(napis2);
		
		liczbaPion.setBounds(240, 55, 30, 30);
		panel.add(liczbaPion);
		
		napis3.setBounds(10, 90, 240, 40);
		panel.add(napis3);
		
		liczbaMin.setBounds(240, 95, 30,30);
		panel.add(liczbaMin);
		
		przyciskZatwierdz.setBounds(400,150,120,40);
		panel.add(przyciskZatwierdz);
		
		this.add(panel);
	}
	
	public void WylaczSie()	// metoda wylacza okno menu
	{
		remove(panel);
		validate();
		repaint();
		dispose();
	}
	
	
	public int GetLiczbaPoziom()
	{
		return Integer.parseInt(liczbaPoziom.getText());
	}
	
	public int GetLiczbaPion()
	{
		return Integer.parseInt(liczbaPion.getText());
	}
	
	public int GetLiczbaMin()
	{
		return Integer.parseInt(liczbaMin.getText());
	}
	
	public void addCalculationListener(ActionListener listener)
	{
		przyciskZatwierdz.addActionListener(listener);
	}
	
	public void displayErrorMessage(String errorMessage)
	{
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
