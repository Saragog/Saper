package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.mojJButton;

import Model.Plansza;
import View.Widok;

public class KontrolerSapera
{
	private Widok theView;
	private Plansza theBoard;
	
	public KontrolerSapera(Plansza theBoard, Widok theView)
	{
		this.theBoard = theBoard;
		this.theView = theView;
		
		for(int x = 0; x < theBoard.getRozmiarPlanszy(); x++)
		{
			MojListener nowyListener = new MojListener();
			
			theView.addListener(x, nowyListener);
		}
		theBoard.PrzedstawPlansze();
		
	}
	
	class MojListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int number = -1;	// -1 oznacza ze nie ustawiony i nie bedzie mialo to wplywu na odslanianie pola bo takie pole nie istnieje
			
			
			try
			{
				
				mojJButton przycisk = (mojJButton)(e.getSource());
				
				System.out.println("Wcisnieto przycisk");
				
				number = przycisk.getNumerPola();

				System.out.println("Numer przyslany do kontrolera wynosi: " + number);
				theBoard.OdslonPole(number/*, grajacy*/);
				

				int[] tablicaZawartosci = theBoard.getZawartoscOdslonietych();
				int[] tablicaOdsloniec = theBoard.getKtoreOdsloniete();
				
				theView.AktualizujWidok(tablicaZawartosci, tablicaOdsloniec);			// wysyla numery pol do odsloniecia oraz zawartosc odslanianych pol
				
				
			}
			catch(NumberFormatException ex)
			{
				theView.displayErrorMessage("Popsulo sie");
			}
		}
	}
}
