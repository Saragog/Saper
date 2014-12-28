package Model;

public class Gracz {
	
	private int iloscPunktow;
	private int czyMozeGrac;
	
	public Gracz()
	{
		iloscPunktow = 0;
		czyMozeGrac = 1;
	}
	
	public int getIloscPunktow()
	{
		return iloscPunktow;
	}
	
	public int czyMozeGrac()
	{
		return czyMozeGrac;
	}
	
	public void setIloscPunktow(int argument)	// podajemy ilosc punktow dla gracza
	{
		iloscPunktow = argument;
	}
	
	public void setCzyMozeGrac(int argument) // 1 oznacza ze moze grac | 0 oznacza ze nie moze grac
	{
		czyMozeGrac = argument;
	}
}
