package org.example;

enum TipoItem {
    BEBIDA,
    PLATO_PRINCIPAL
}

public class ItemMenu {
    private TipoItem tipo;
    private String Nombre;
    private double precio;
    private int cantidad;

    public ItemMenu (String nombre, double precio, TipoItem tipo, int cantidad) {
        Nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }


    public double precioPorCantidad () {
        return precio * cantidad;
    }

    public TipoItem tipoDeConsumo () {
        return tipo;
    }

}
