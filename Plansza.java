package Model;

import java.util.Random;

import java.util.Scanner;	// tylko do testu dzialania metod potem sie wywali


public class Plansza {

	private int iloscKolumn;
	private int iloscSzeregow;
	private Pole[] pola;// = new Pole[25];
	private int rozmiarPlanszy;
	private int iloscMin;
	private int iloscPustychPol;
	private Gracz grajacy;			// tymczasowo 1 gracz tylko
	private boolean[] doOdsloniecia; // przechowywuje info o tym ktore pola zostaly zmienione
	private int ileOdslonic;
	
	// private int liczbaGraczy;
	
	public Plansza()				// domyslnie 25 pol i 10 min
	{
		iloscKolumn = 5;
		iloscSzeregow = 5;
		rozmiarPlanszy = 25;
		iloscMin = 10;
		pola = new Pole[rozmiarPlanszy];
		for (int x = 0; x < rozmiarPlanszy; x++)
		{
			pola[x] = new Pole();
		}
		grajacy = new Gracz();
		UstawMiny();
		WyznaczZawartosc();
		doOdsloniecia = new boolean[rozmiarPlanszy];

		for (int x = 0; x < rozmiarPlanszy; x++)
		{
			doOdsloniecia[x] = false;				// 0 - 0 oznacza ze nie trzeba odslaniac
		}
		ileOdslonic = 0;
		
	}
	
	public Plansza(int ileK,int ileS, int ileMin)		// konstruktor ktoremu podajemy ilosc kolumn i szeregow i ilosc min
	{
		iloscKolumn = ileK;
		iloscSzeregow = ileS;
		iloscMin = ileMin;
		rozmiarPlanszy = ileK * ileS;
		pola = new Pole[rozmiarPlanszy];
		for (int x = 0; x < rozmiarPlanszy; x++)
		{
			pola[x] = new Pole();
		}
		grajacy = new Gracz();
		UstawMiny();
		WyznaczZawartosc();
		doOdsloniecia = new boolean[rozmiarPlanszy];
		
		for (int x = 0; x < rozmiarPlanszy; x++)
		{
			doOdsloniecia[x] = false;				// 0 - 0 oznacza ze nie trzeba odslaniac
		}
		ileOdslonic = 0;
	}
	
	private void UstawMiny()		// metoda do rozstawiania min na planszy nie potrzeba argumentow
	{
		
		// metoda losowa ustawiania min
		
		int numerPola;
		iloscPustychPol = rozmiarPlanszy;
		Random generator = new Random();
		
		for ( int x = 0; x < iloscMin; x++)
		{
			while(true)
			{
				
				numerPola = generator.nextInt(rozmiarPlanszy);
				
				if (pola[numerPola].getCoZawiera() != 9)
				{
					

					pola[numerPola].setCoZawiera(9);		/// ustawienie pola na mine ( 9 )
					iloscPustychPol = iloscPustychPol - 1;
					break;
				}
			}
		}
		
		
		
	}	// metoda generujaca rozstawienie min na planszy
	
	
	
	// miejsce na dodatkowa metode do ustawiania min
	
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	
	public void OdslonPole(int numerPola/*, Gracz grajacy*/)			// metoda odslaniajaca pole i dajaca graczowi odpowiednia ilosc punktow
	{
		
		if (numerPola >= 0 && numerPola <rozmiarPlanszy)
		{
			
			if (pola[numerPola].getCzyOdsloniete() == false)
			{
				System.out.println("Odslaniam pole nr.: " + numerPola);

				
				pola[numerPola].setCzyOdsloniete(true);				
				
				doOdsloniecia[numerPola] = true;
				ileOdslonic++;
				
				int zawartosc = pola[numerPola].getCoZawiera();
				
				if (zawartosc == 0)	// 0 min wokol wiec odslanianie rekurencyjne
				{
					int kolumna = numerPola % iloscKolumn;
					int szereg = numerPola / iloscKolumn;
					int kolumnaDoOdsloniecia;
					int szeregDoOdsloniecia;
					
					
					for (szeregDoOdsloniecia = szereg - 1; szeregDoOdsloniecia <= szereg + 1; szeregDoOdsloniecia++) // przechodzenie po szeregach ( w pionie )
					{
						for (kolumnaDoOdsloniecia = kolumna - 1; kolumnaDoOdsloniecia <= kolumna + 1; kolumnaDoOdsloniecia++) // przechodzenie po kolumnach ( w poziomie )
						{
							
							if (((kolumnaDoOdsloniecia >= 0) && (kolumnaDoOdsloniecia < iloscKolumn)) && ((szeregDoOdsloniecia >= 0) && (szeregDoOdsloniecia < iloscSzeregow)))
							{
								OdslonPole(szeregDoOdsloniecia * iloscKolumn + kolumnaDoOdsloniecia/*, grajacy*/);
							}
						}
					}
				}
				
				else if ((zawartosc != 9) && (zawartosc != 0))		// iles min wokol wiec dodawane punkty i tyle
				{
					grajacy.setIloscPunktow(grajacy.getIloscPunktow() + pola[numerPola].getCoZawiera()); // mozna potem zmienic ilosc przydzielanych punktow
					return;
				}
				else	// zawartosc == 9 wiec mina
				{
					grajacy.setCzyMozeGrac(0);
					return;
				}		
			}
			else
			{
				System.out.println("Pole nr.: " + numerPola + " Jest juz odsloniete");
			}
		}
	}
	
	public void WyznaczZawartosc()		// Metoda wyznaczajaca ilosc min wokol kazdego pola
	{
		for ( int x = 0; x < rozmiarPlanszy; x++)
		{
			int zawartosc = 0;
			int ktoraKolumna = x % iloscKolumn;
			int ktorySzereg = x / iloscKolumn;
			int numer;
			
			int aktualnySzereg;
			int aktualnaKolumna;
			System.out.println("Dla x: "+x);
			//System.out.println("pole kol: "+ktoraKolumna + "pole szer: "+ktorySzereg);
			if (pola[x].getCoZawiera() != 9) // nie jest miną
			{
				for (aktualnySzereg = ktorySzereg - 1;aktualnySzereg <= ktorySzereg + 1; aktualnySzereg++)
				{
					for (aktualnaKolumna = ktoraKolumna - 1; aktualnaKolumna <= ktoraKolumna + 1; aktualnaKolumna++)
					{
						numer = aktualnySzereg * iloscKolumn + aktualnaKolumna;
						if (((aktualnaKolumna >= 0) && (aktualnaKolumna < iloscKolumn)) && ((aktualnySzereg >= 0) && (aktualnySzereg < iloscSzeregow)))
						{
							if (pola[numer].getCoZawiera() == 9)
							{
								//System.out.println("na pozycji kol: "+aktualnaKolumna +" szer: "+ aktualnySzereg + "jest mina");
								zawartosc++;
							}
						}
					}
				}
				//System.out.println("zawartosc na koniec: "+zawartosc);
				pola[x].setCoZawiera(zawartosc);
			}
		}
	}
	
	public int getIloscKolumn()
	{
		return iloscKolumn;
	}
	
	public int getIloscSzeregow()
	{
		return iloscSzeregow;
	}
	
	public int getRozmiarPlanszy()
	{
		return rozmiarPlanszy;
	}
	
	public int getIloscMin()
	{
		return iloscMin;
	}
	
	public int getIloscPustychPol()
	{
		return iloscPustychPol;
	}
	
	public int[] getZawartoscOdslonietych()		// daje wartosci odslanianych pol
	{
		int[] zawartoscOdslonietych = new int[ileOdslonic];
		int x = 0;
		
		for (int y = 0; y < ileOdslonic; y++)
		{
			for (; x < rozmiarPlanszy; x++)
			{
				if (doOdsloniecia[x] == true)
				{
					zawartoscOdslonietych[y] = pola[x].getCoZawiera();
					x++;
					break;
				}
			}
		}
		
		return zawartoscOdslonietych;
	}
	
	public int[] getKtoreOdsloniete()		// daje numery pol do odsloniecia
	{
		int[] ktoreOdsloniete = new int[ileOdslonic];
		int x = 0;
		for (int y = 0; y < ileOdslonic; y++)
		{
			for (; x < rozmiarPlanszy; x++)
			{
				if (doOdsloniecia[x] == true)
				{
					ktoreOdsloniete[y] = x;
					x++;
					break;
				}
			}
		}
		
		for (x = 0; x < rozmiarPlanszy; x++)
		{
			doOdsloniecia[x] = false;				// 0 - 0 oznacza ze nie trzeba odslaniac
		}
		ileOdslonic = 0;

		return ktoreOdsloniete;
	}
	
	
// *****************************************************************************************
// tylko dla celow sprawdzania poprawnosci metod
// potem zamienic trzeba na View
	
	public void PrzedstawPlansze()
	{
		
		for (int x = 0; x < iloscSzeregow; x++)
		{
			for (int y = 0; y < iloscKolumn; y++)
			{
				System.out.print(pola[x*iloscKolumn + y].getCoZawiera());
			}
			System.out.println();
		}
		
		
		return;
	}

// *****************************************************************************************

/*	public static void main(String[] args)
	{
		Plansza nowa = new Plansza(10,5,10);

		nowa.PrzedstawPlansze();

		Scanner in = new Scanner(System.in);
		System.out.println("Podaj numer pola do odsloniecia\n");

		int numer = in.nextInt();


		nowa.OdslonPole(numer, nowa.grajacy);

		System.out.println(nowa.grajacy.getIloscPunktow());
		

		numer = in.nextInt();
		
		nowa.OdslonPole(numer, nowa.grajacy);
		
		System.out.println(nowa.grajacy.getIloscPunktow());

	}*/
}
