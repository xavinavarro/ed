using System;

namespace CCategoria
{
	public partial class ActionGroup : Gtk.ActionGroup
	{
		public ActionGroup () :
			base ("CCategoria.ActionGroup")
		{
			this.Build ();
		}
	}
}

