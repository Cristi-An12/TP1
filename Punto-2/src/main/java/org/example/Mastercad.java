package org.example;

import java.util.List;

public class Mastercad implements Tarjeta {

    @Override
    public double aplicarDescuento (List<ItemMenu> items) {
        double totalConDescuento = 0;
        for (ItemMenu item : items) {
            if (item.getTipo () == TipoItem.PLATO_PRINCIPAL) {
                totalConDescuento += item.getPrecio ();
            }
        }
        return totalConDescuento * 0.02f;
    }

}
