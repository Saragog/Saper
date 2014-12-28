package Model;

public class Pole {
	
		private boolean czyOdsloniete;			// 1 oznacza ze odsloniete | 0 oznacza ze zasloniete
		private int coZawiera;				// ilosc min wokol albo cos innego | 9 oznacza mine
		private int czyWybuchla;			// 0 oznacza ze nie wybuchla | 1 oznacza ze wybuchla
		
		
		public Pole()
		{
			czyOdsloniete = false;
			coZawiera = 0;
			czyWybuchla = 0;
		}
		
		public int getCzyWybuchla()
		{
			return czyWybuchla;
		}
		
		public boolean getCzyOdsloniete()
		{
			return czyOdsloniete;
		}
		
		public int getCoZawiera()
		{
			return coZawiera;
		}
		
		public void setCzyOdsloniete(boolean argument)
		{
			czyOdsloniete = argument;
		}
		
		public void setCoZawiera(int argument)
		{
			coZawiera = argument;
		}
		
		public void setCzyWybuchla(int argument)
		{
			czyWybuchla = argument;
		}
}
