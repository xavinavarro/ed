using System;

namespace CCategoria
{
	[System.ComponentModel.ToolboxItem (true)]
	public partial class CategoriaView : Gtk.Window
	{
		public CategoriaView () : base(Gtk.WindowType.Toplevel){
			this.Build ();

			saveAction.Activated += delegate {
				IDbCommand dbCommand = App.Instance.DbConnection.CreateCommand ();
				dbCommand.ComandText = 
					"insert into categoria (nombre) values ('El nuevo nombre')";
				String nombre = entryNombre.Text;
				Console.WriteLine ("SaveAction.Activated");


				dbCommandAddParameter(dbCommand, "nombre", nombre);

				dbCommand.ExecuteNonQuery ();
			};
	}
		private void dbCommandAddParameter(IDbCommand dbCommand, string parameterName, object value){
			IDbDataparameter dbDataParameter = dbCommand.CreateParameter ();
			dbDataParameter.ParameterName = parameterName;
			dbDataParameter.Value = value;
			dbCommand.Parameters.Add (dbDataParameter);
		}
	}
}