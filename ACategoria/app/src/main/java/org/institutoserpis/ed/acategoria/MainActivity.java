package org.institutoserpis.ed.acategoria;
/**
 * Created by Xavi on 25/05/2016.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbPruebaOpenHelper.init(this);
        /*
        DbPruebaOpenHelper.getInstance().insertCategoria("Categoria 1");
        DbPruebaOpenHelper.getInstance().insertCategoria("Categoria 2");
        DbPruebaOpenHelper.getInstance().insertCategoria("Categoria 3");
        */


        List<Categoria> categorias = DbPruebaOpenHelper.getInstance().getCategorias();

        ListView listview = (ListView)findViewById(R.id.listView);
        ArrayAdapter<Categoria> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                categorias
        );
        listview.setAdapter(arrayAdapter);
    }
}
