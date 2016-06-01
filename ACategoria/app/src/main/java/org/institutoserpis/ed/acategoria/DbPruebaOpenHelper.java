package org.institutoserpis.ed.acategoria;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xavi on 25/05/2016.
 */
public class DbPruebaOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbprueba.db";
    private static final int DATABASE_VERSION= 1;



    private static Context context;
    public static void init(Context context){
        DbPruebaOpenHelper.context = context;
    }


    private static DbPruebaOpenHelper instance;
    public static DbPruebaOpenHelper getInstance(){
        if (instance == null)
            instance = new DbPruebaOpenHelper(context);
        return instance;
    }

    public static abstract class  TableCategoria implements BaseColumns{
        public static final String NAME = "categoria";
        public static final String COLUMN_NOMBRE = "nombre";
    }

    private static final String CREATE_TABLE_CATEGORIA =
            "create table" + TableCategoria.NAME + " (" +
                    TableCategoria._ID + " integer primary key," +
                    TableCategoria.COLUMN_NOMBRE + " text" +
                    ");";
    private static final String DROP_TABLE_CATEGORIA =
            "drop table if exists" + TableCategoria.NAME;

    public DbPruebaOpenHelper(Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_CATEGORIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion){
        db.execSQL(DROP_TABLE_CATEGORIA);
        onCreate(db);
    }
    public long insertCategoria(String nombre) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableCategoria.COLUMN_NOMBRE, nombre);
        return sqLiteDatabase.insert(TableCategoria.NAME, null, contentValues);
    }

    public List<Categoria> getCategorias(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        //TODO sqLiteDatabase.query();
        String[] columns = new String[]{
                TableCategoria._ID,
                TableCategoria.COLUMN_NOMBRE
        };
        Cursor cursor = sqLiteDatabase.query(
                TableCategoria.NAME,
                columns,
                null,
                null,
                null,
                null,
                null
        );
        List<Categoria> categorias = new ArrayList<>();
        while (cursor.moveToNext())
            categorias.add(new Categoria(cursor.getLong(0),cursor.getString(1)));
        cursor.close();
        return categorias;
    }
}
