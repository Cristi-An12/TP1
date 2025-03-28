package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemMenu> item;
    private boolean comfirmado;

    public Pedido (boolean comfirmado, List<ItemMenu> item) {
        this.comfirmado = false;
        this.item = new ArrayList<> ();
    }

    public void agregarItem (String nombre, double precio, TipoItem tipo, int cantidad) {
        if (!comfirmado) {
            item.add (new ItemMenu (nombre, precio, tipo, cantidad));
        } else {
            throw new IllegalStateException ("No se puede modificar un pedido confirmado");
        }
    }

    public void comfirmar () {
        comfirmado = true;
    }

    public boolean estaComfirmado () {
        return comfirmado;
    }

    public double costoBebidas () {
        double total = 0.0;  // Variable para almacenar la suma de los subtotales

        for (ItemMenu item : item) {  // Recorremos la lista de items
            if (item.tipoDeConsumo () == TipoItem.BEBIDA) {  // Filtramos solo las bebidas
                total += item.precioPorCantidad ();  // Sumamos el subtotal de la bebida
            }
        }
        return total;  // Retornamos el costo total de las bebidas
    }

    public double costoPlato () {
        double total = 0.0;

        for (ItemMenu item : item) {
            if (item.tipoDeConsumo () == TipoItem.PLATO_PRINCIPAL) {
                total += item.precioPorCantidad ();
            }
        }
        return total;
    }

    //aun no se contempla la propina, [hacer una clase propina]
    public double costoConsumoTotal () {
        return costoBebidas () + costoPlato ();
    }
}
