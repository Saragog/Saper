package View;

import javax.swing.JButton;

public class mojJButton extends JButton
{
	private int numerPola;
	
	mojJButton(int liczba)
	{
		super("");
		this.numerPola = liczba;
	
	}
	
	public void setNumerPola(int argument)
	{
		numerPola = argument;
	}
	
	public int getNumerPola()
	{
		return numerPola;
	}
}
