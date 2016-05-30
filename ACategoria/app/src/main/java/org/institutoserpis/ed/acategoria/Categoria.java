package org.institutoserpis.ed.acategoria;

/**
 * Created by Xavi on 30/05/2016.
 */
public class Categoria {
    public long id;
    public String nombre;

    public Categoria(long id, String nombre){
        this.id;
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return String.format("[%d] %s", id, nombre);
    }
}
