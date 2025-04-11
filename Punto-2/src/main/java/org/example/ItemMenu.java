package org.example;

enum TipoItem {
    BEBIDA,
    PLATO_PRINCIPAL
}

public class ItemMenu {
    private TipoItem tipo;
    private String Nombre;
    private double precio;


    public ItemMenu (String nombre, double precio, TipoItem tipo) {
        Nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public double getPrecio () {
        return precio;
    }

    public TipoItem getTipo () {
        return tipo;
    }


}
