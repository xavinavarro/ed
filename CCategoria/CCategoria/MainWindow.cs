using System;
using Gtk;
using System.Data;
using MySql.Data.MySqlClient;
using CCategoria;

public partial class MainWindow: Gtk.Window
{
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();


		//Crear treeview categorias
		treeView.AppendColumn ("Id", new CellRendererText (), "text", 0);
		treeView.AppendColumn ("Nombre", new CellRendererText (), "text", 1);
		ListStore listStore = new ListStore (typeof(long), typeof(string));
		treeView.Model = listStore;

	
		//mysql
		App.Instance.DbConnection = new MySqlConnection (
			"Database=dbprueba;User=root;Password=sistemas");
		App.Instance.DbConnection.Open ();


		//operaciones
//		IDbCommand insertdbCommand = dbConnection.CreateCommand ();
//		insertdbCommand.CommandText =
//			"insert into categoria (nombre) values ('categoria 4')";
//		insertdbCommand.ExecuteNonQuery ();


		//App.Instance.DbConnection.Close ();

		CategoriaView categoriaView = new CategoriaView ();

		deleteAction.Activated += delegate {
//			Confirmar el borrado
//			MessageDialog messageDialog= new MessageDialog(
//				this,
//				DialogFlags.Modal,
//				MessageType.Question,
//				ButtonsType.YesNo,
//				"¿Deseas eliminar el registro?"
//				);
//			messageDialog.Title=Title;
//			ResponseType response=(ResponseType)messageDialog.Run();
//			messageDialog.Destroy();
//			if(response!=ResponseType.Yes)
//				return;
			if (!WindowHelper.Confirm (this, "¿Deseas eliminar el registro?"))
				return;



			Console.WriteLine ("delete activated");
			TreeIter treeIter;
			treeView.Selection.GetSelected (out treeIter);
			object id = listStore.GetValue (treeIter, 0);

			Console.WriteLine ("deleteAction Activated id={0}", id);
			IDbCommand deleteDbCommand = App.Instance.DbConnection.CreateCommand ();
			deleteDbCommand.CommandText = "delete from categoria where id= " + id;

		};
		treeView.Selection.Changed += delegate {
			Console.WriteLine ("Selection changed CountSelectedRows()={0}",
			                   treeView.Selection.CountSelectedRows ());
			updateActions ();

		};
		refreshAction.Activated += delegate {
			fillListstore (listStore);
		};
		updateActions ();
 
	}

	private void fillListstore (ListStore listStore)
	{
		IDbCommand dbCommand = App.Instance.DbConnection.CreateCommand ();
		dbCommand.CommandText = "select * from categoria order by id";
		IDataReader dataReader = dbCommand.ExecuteReader ();
		while (dataReader.Read()) {
			listStore.AppendValues (dataReader ["id"], dataReader ["nombre"]);

			//Console.WriteLine ("id={0} nombre={1}", dataReader ["id"], dataReader ["nombre"]);

		}


		//cerramos
		dataReader.Close ();
	}

	private void updateActions ()
	{
		deleteAction.Sensitive = treeView.Selection.CountSelectedRows () > 0;
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}
