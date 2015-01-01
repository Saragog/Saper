package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.mojJButton;

import Model.Plansza;
import View.Widok;
import View.MenuWidok;
import View.KoniecWidok;

public class KontrolerSapera
{
	
	protected MenuWidok menu;
	protected KoniecWidok koniec;
	protected Widok theView;
	protected Plansza theBoard;
	
	public KontrolerSapera(MenuWidok menu)
	{
		this.menu = menu;
		menu.addCalculationListener(new ListenerMenu());
		//menu.setVisible(true);
/*
		
		this.theBoard = theBoard;
		this.theView = theView;
		
		for(int x = 0; x < theBoard.getRozmiarPlanszy(); x++)
		{
			MojListener nowyListener = new MojListener();
			
			theView.addListener(x, nowyListener);
		}
		theBoard.PrzedstawPlansze();
*/		
	}
	
	public void pokazWynik()
	{
		System.out.println("Wypsuje wszystko to co trzeba");
		if (theBoard.getIloscPustychPol() == 0)
		{
			koniec = new KoniecWidok(theBoard.getiloscgraczy(),theBoard.getwynik(),1);	// zwyciestwo
		}
		else
		{
			koniec = new KoniecWidok(theBoard.getiloscgraczy(),theBoard.getwynik(),0);	// porazka
		}
		koniec.setVisible(true);
		
	}
	
	class ListenerMenu implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int liczbaPoziom = 0;
			int liczbaPion = 0;
			int liczbaMin = 0;
			
			try
			{
				
				liczbaPoziom = menu.GetLiczbaPoziom();
				liczbaPion = menu.GetLiczbaPion();
				liczbaMin = menu.GetLiczbaMin();
				
				//Widok theView = new Widok(10,10);
				//Plansza thePlansza = new Plansza(10,10,15);
				
				
				theBoard = new Plansza(liczbaPoziom,liczbaPion,liczbaMin);
				theView = new Widok(liczbaPoziom,liczbaPion);
				
				
				for(int x = 0; x < theBoard.getRozmiarPlanszy(); x++)
				{
					MojListener nowyListener = new MojListener();
					
					theView.addListener(x, nowyListener);
				}
				theBoard.PrzedstawPlansze();
				
				menu.WylaczSie();
				
				theView.setVisible(true);				
				
			}
			catch (NumberFormatException ex)
			{
				menu.displayErrorMessage("Musisz podac wszystko!");
			}
		}
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
				
				if (!theBoard.SprawdzCzyMoznaGrac() && koniec == null)
				{
					System.out.println("Koniec gry");
				
					System.out.println("Ilosc zdobytych punktow: " + theBoard.DajIloscPunktowGracza(0));
					
					pokazWynik();
				}
			}
			catch(NumberFormatException ex)
			{
				theView.displayErrorMessage("Popsulo sie");
			}
		}
	}
}
