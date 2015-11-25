using System;
using Gtk;

public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();
		random = new Random ();
		random.Next(90)
		Table table = new Table (9, 10, true);

		Button button = new Button ();
		button.Label = "1";
		button.Visible = true;

		table.Attach (button, 0, 1, 0, 1);
		table.Visible = true;
		vbox1.Add (table);
		vbox1.Add (button);

		Button b = new Button();
		b.ModifyBg(StateType.Normal, new Gdk.Color(0,255,0));

		table.Visible = true;
		vbox1.Add (table);
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}