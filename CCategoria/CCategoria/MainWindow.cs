using System;
using Gtk;
using System.Data;
using MySql.Data.MySqlClient;

public partial class MainWindow: Gtk.Window
{
	public MainWindow () : base (Gtk.WindowType.Toplevel)
	{
		Build ();

		treeView.AppendColumn ("id", new CellRendererText (), "text", 0);
		treeView.AppendColumn ("nombre", new CellRendererText (), "text", 1);

		ListStore listStore = new ListStore (typeof(long), typeof(string));
		treeView.Model = ListStore;

		App.Instance.DbConnection = new MySqlConnection(
			"Database=dbprueba;User=root;Password=sistemas");
		App.Instance.DbConnection.Open ();



		IDbConnection DbConnection = new MySqlConnection (
			"Database=dbprueba;User=root;Password=sistemas");
		dbConnection.Open ();

		/*IdbCommand insertDbCommand = dbConnection.CreateCommand ();
		insertDbCommand.CommandText = "insert into categoria (nombre) values ('categoria 4')";
		insertDbCommand.ExecuteNonQuery ();
		*/


		IDbCommand dbCommand = dbConnection.CreateCommand ();
		dbCommand.CommandText = "select * from categoria";
		IDataReader dataReader = dbCommand.ExecuteReader ();
		while (dataReader.Read ())
			listStore.AppendValues (dataReader ["id"], dataReader ["nombre"]);
			//Console.WriteLine ("id={0} nombre={1}" , dataReader ["id"], dataReader ["nombre"]);
		dataReader.Close();
		
		dbConnection.Close ();
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}
