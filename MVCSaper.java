import Model.Plansza;
import View.Widok;
import Controller.KontrolerSapera;

public class MVCSaper {


	public static void main(String[] args)
	{
		Widok theView = new Widok(10,10);
		Plansza thePlansza = new Plansza(10,10,10);
		KontrolerSapera theGra = new KontrolerSapera(thePlansza,theView);
		
		theView.setVisible(true);
	}

}
