package org.example;

enum TipoItem {
    BEBIDA,
    PLATO_PRINCIPAL
}

public class ItemMenu {
    private TipoItem tipo;
    private String Nombre;
    private double precio;


    public ItemMenu (String nombre, double precio, TipoItem tipo, int cantidad) {
        Nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre () {
        return Nombre;
    }

    public double getPrecio () {
        return precio;
    }

    public TipoItem getTipo () {
        return tipo;
    }


}
