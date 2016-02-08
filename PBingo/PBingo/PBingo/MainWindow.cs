using System;
using Gtk;

public partial class MainWindow: Gtk.Window
{	
	private Random random;
	private Table table;
	private List<Button> Buttons;
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
	

		Build ();
		random = new Random ();
		random.Next(90)
		
		table = new Table (9, 10, true);
		List <int> numeros=new List <int> ();

		for (uint index=0;index<90; index++){
			uint row= index / 10;
			uint column = index %10;
			int numero = index+1;
			Button button = new Button();
			button.Label=numero.ToString();
			button.Visible = true;
			table.Attach (button, column, column +1, row, row+1);
			buttons.Add (button);
			numeros.Add (numero);
		}






		button = new Button ();
		button.Label = "1";
		button.Visible = true;

		table.Attach (button, 0, 1, 0, 1);
		table.Visible = true;
		vbox1.Add (table);
		vbox1.Add (button);

		Button b = new Button();
		b.ModifyBg(StateType.Normal, new Gdk.Color(0,255,0));
		Process.Start ("espeak", "-v es" + indexAleatorio);

		table.Visible = true;
		vbox1.Add (table);
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}