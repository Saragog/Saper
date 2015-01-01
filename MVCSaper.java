
import Model.Plansza;
import View.MenuWidok;
import View.Widok;
import Controller.KontrolerSapera;

public class MVCSaper {


	public static void main(String[] args)
	{
		MenuWidok menu = new MenuWidok();
		KontrolerSapera theGra = new KontrolerSapera(menu);
		
		menu.setVisible(true);
	}

}
