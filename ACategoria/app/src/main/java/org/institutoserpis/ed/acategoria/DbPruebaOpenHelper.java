package org.institutoserpis.ed.acategoria;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.provider.BaseColumns;

/**
 * Created by Xavi on 25/05/2016.
 */
public class DbPruebaOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbprueba.db";
    private static final int DATABASE_VERSION= 1;

    public static abstract class  TableCategoria implements BaseColumns{
        public static final String NAME = "categoria";
        public static final String COLUMN_NOMBRE = "nombre";
    }

    private static final String CREATE_TABLE_CATEGORIA =
            "create table" + TableCategoria.NAME + " (" +
                    TableCategoria._ID + " " + "," +
                    TableCategoria.COLUMN_NOMBRE + " text" +
                    ");";

    public DbPruebaOpenHelper(Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_CATEGORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion){
    }
}
