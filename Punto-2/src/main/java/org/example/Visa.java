package org.example;

import java.util.List;

public class Visa implements Tarjeta {

    @Override
    public double aplicarDescuento (List<ItemMenu> items) {
        double totalConDescuento = 0;
        for (ItemMenu item : items) {
            if (item.getTipo () == TipoItem.BEBIDA) {
                totalConDescuento += item.getPrecio ();
            }
        }
        return totalConDescuento * 0.03;

    }
}
