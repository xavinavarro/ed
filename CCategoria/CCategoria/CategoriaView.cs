using System;
using System.Data;

namespace CCategoria
{
	public partial class CategoriaView : Gtk.Window
	{
		public CategoriaView () : base(Gtk.WindowType.Toplevel){
			this.Build ();
			saveAction.Activated += delegate {
				IDbCommand dbCommand= App.Instance.DbConnection.CreateCommand();
				dbCommand.CommandText="insert into categoria (nombre) values (@nombre)";
				string nombre = entryNombre.Text;


				dbCommandAddParameter(dbCommand, "nombre", nombre);
				dbCommand.ExecuteNonQuery();

				Console.WriteLine ("saveAction.Activated");
			};
		}
		private void dbCommandAddParameter(IDbCommand dbCommand, 
		   string parameterName, object value){
			/*IDbDataParameter dbDataParameter=dbCommand.CreateParameter();
			dbDataParameter.ParameterName = parameterName;
			dbDataParameter.Value=value;
			dbCommand.Parameters.Add(dbDataParameter);*/

		}
	}
}

