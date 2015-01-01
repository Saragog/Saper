package Model;

public class Gracz {
	
	private int iloscPunktow;
	private boolean czyMozeGrac;
	
	public Gracz()
	{
		iloscPunktow = 0;
		czyMozeGrac = true;
	}
	
	public int getIloscPunktow()
	{
		return iloscPunktow;
	}
	
	public boolean czyMozeGrac()
	{
		return czyMozeGrac;
	}
	
	public void setIloscPunktow(int argument)	// podajemy ilosc punktow dla gracza
	{
		iloscPunktow = argument;
	}
	
	public void setCzyMozeGrac(boolean argument) // 1 oznacza ze moze grac | 0 oznacza ze nie moze grac
	{
		czyMozeGrac = argument;
	}
}

