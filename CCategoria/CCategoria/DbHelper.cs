using System;

namespace CCategoria
{
	public class DbHelper
	{
		public static void DbCommandAddParameter(IDbCommand dbCommand, string parameterName){
			IDbDataParameter dbDataParameter=dbCommand.CreateParameter();
			dbDataParameter.ParameterName = parameterName;
			dbDataParameter.Value=value;
			dbCommand.Parameters.Add(dbDataParameter);
		}
			
	}
}

