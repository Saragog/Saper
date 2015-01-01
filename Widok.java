package View;


import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Widok extends JFrame
{

	private mojJButton[] przyciski;
	private int ilePoziomo;
	private int ilePionowo;

	private ImageIcon mina1;
	private ImageIcon mina2;
	private ImageIcon mina3;
	private ImageIcon mina4;
	private ImageIcon mina5;
	private ImageIcon mina6;
	private ImageIcon mina7;
	private ImageIcon mina8;
	private ImageIcon minawybucha;
	private ImageIcon minapuste;
	
	
	public Widok()				// konstruktor domyslny
	{
		setSize(200,229); // poziomo | pionowo     | ramka na gorze zajmuje doklanie 29 jednostek
		setTitle("Saper");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		przyciski = new mojJButton[25];
		
		ilePoziomo = 5;
		ilePionowo = 5;
		
		int x;
		int y;
		
		for (int i = 0 ; i < 25 ; i++)
		{
			przyciski[i] = new mojJButton(i);
		}
		for (y = 0; y < 5; y++)
		{
			for (x = 0 ; x < 5; x++)
			{
				przyciski[x + y*5].setBounds(x*40, y*40, 40, 40);
				add (przyciski[x + y*5]);

			}
			x = 0;
		}
		pack();
		mina1 = new ImageIcon(getClass().getResource("mina1.jpg"));
		mina2 = new ImageIcon(getClass().getResource("mina2.jpg"));
		mina3 = new ImageIcon(getClass().getResource("mina3.jpg"));
		mina4 = new ImageIcon(getClass().getResource("mina4.jpg"));
		mina5 = new ImageIcon(getClass().getResource("mina5.jpg"));
		mina6 = new ImageIcon(getClass().getResource("mina6.jpg"));
		mina7 = new ImageIcon(getClass().getResource("mina7.jpg"));
		mina8 = new ImageIcon(getClass().getResource("mina8.jpg"));
		minawybucha = new ImageIcon(getClass().getResource("minawybucha.jpg"));
		minapuste = new ImageIcon(getClass().getResource("minapuste.jpg"));
		
	}
	public Widok(int ileK, int ileS)	// ile Kolumn ile Szeregow
	{
		przyciski = new mojJButton[ileK*ileS];
		
		setSize(40*ileK,29+40*ileS);
		setTitle("Saper");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ilePoziomo = ileK;
		ilePionowo = ileS;
		
		int x;
		int y;
		
		for (int i = 0 ; i < ileK*ileS ; i++)
		{
			przyciski[i] = new mojJButton(i);
		}
		for (y = 0; y < ileS; y++)
		{
			for (x = 0 ; x < ileK; x++)
			{
				przyciski[x + y*ileK].setBounds(x*40, y*40, 40, 40);		// distance to right(ile w prawo) | distance down(ile w dol) | width(szerokosc) | height(wysokosc)
				add (przyciski[x + y*ileK]);
				
			}
			x = 0;
		}
		
		mina1 = new ImageIcon(getClass().getResource("mina1.jpg"));
		mina2 = new ImageIcon(getClass().getResource("mina2.jpg"));
		mina3 = new ImageIcon(getClass().getResource("mina3.jpg"));
		mina4 = new ImageIcon(getClass().getResource("mina4.jpg"));
		mina5 = new ImageIcon(getClass().getResource("mina5.jpg"));
		mina6 = new ImageIcon(getClass().getResource("mina6.jpg"));
		mina7 = new ImageIcon(getClass().getResource("mina7.jpg"));
		mina8 = new ImageIcon(getClass().getResource("mina8.jpg"));
		minawybucha = new ImageIcon(getClass().getResource("minawybucha.jpg"));
		minapuste = new ImageIcon(getClass().getResource("minapuste.jpg"));
		
	}

	public void AktualizujWidok(int [] tablicaZawartosci,int[] tablicaOdsloniec)
	{
		System.out.println(tablicaOdsloniec.length);
		
		for (int x = 0; x < tablicaOdsloniec.length;x++)
		{
			System.out.println("usuwam" + tablicaOdsloniec[x]);
			remove(przyciski[tablicaOdsloniec[x]]);
			validate();
			repaint();
			
			int kolumna = tablicaOdsloniec[x] % ilePoziomo;
			int szereg = tablicaOdsloniec[x] / ilePoziomo;
			
			System.out.println("Wstawic trzeba JLabel w kolumne: " + kolumna + " i szereg: " + szereg);
			
			JLabel nowyLabel;
			
			switch (tablicaZawartosci[x])
			{
				case 1:										// 1 mina wokol
				{
					nowyLabel = new JLabel(mina1);
					//pack();
					//nowyLabel = new JLabel("    1   ");
					break;
				}
				case 2:										// 2 miny wokol
				{
					nowyLabel = new JLabel(mina2);
					//nowyLabel = new JLabel("    2   ");
					break;
				}
				case 3:										// 3 miny wokol
				{
					nowyLabel = new JLabel(mina3);
					//nowyLabel = new JLabel("    3   ");
					break;
				}
				case 4:										// 4 miny wokol
				{
					nowyLabel = new JLabel(mina4);
					//nowyLabel = new JLabel("    4   ");
					break;
				}
				case 5:										// 5 min wokol
				{
					nowyLabel = new JLabel(mina5);
					//nowyLabel = new JLabel("    5   ");
					break;
				}
				case 6:										// 6 min wokol
				{
					nowyLabel = new JLabel(mina6);
					//nowyLabel = new JLabel("    6   ");
					break;
				}
				case 7:										// 7 min wokol
				{
					nowyLabel = new JLabel(mina7);
					//nowyLabel = new JLabel("    7   ");
					break;
				}
				case 8:										// 8 min wokol
				{
					nowyLabel = new JLabel(mina8);
					//nowyLabel = new JLabel("    8   ");
					break;
				}
				case 9:										// pole jest mina
				{
					nowyLabel = new JLabel(minawybucha);
					//nowyLabel = new JLabel("    M   ");
					break;
				}
				default:										// pole jest puste
				{
					nowyLabel = new JLabel(minapuste);
					//nowyLabel = new JLabel("    P   ");
				}
			}
			
			nowyLabel.setBounds(kolumna*40, szereg*40, 40, 40);
			add (nowyLabel);
			
			
			// dodanie JLabel w to samo miejsce
		}
	
	}
	
/*
	public void actionPerformed(ActionEvent e)
	{
		JButton przycisk = (JButton)(e.getSource());
		
		System.out.println("Wcisnieto przycisk");
		

		for(int i = 0; i < przyciski.length;i++)
		{
			if ( przyciski[i] == przycisk)
			{
				//System.out.println( "Wlasnie znalazlem index : " + i );	// znajduje index w tablicy wcisnietego przycisku
				number = i;
				break;
			}
		}
	}
	
	public int getNumber ()
	{
		//System.out.println(number);
		return number;
		
	}
*/
	
	
	public void addListener (int ktoryPrzycisk, ActionListener listenerDlaPrzycisku)
	{
		przyciski[ktoryPrzycisk].addActionListener(listenerDlaPrzycisku);
	}
	
	
	public void displayErrorMessage(String errorMessage)
	{
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
