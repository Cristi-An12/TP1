package org.example;

import java.util.List;

public class ComarcaPlus implements Tarjeta {
    
    @Override
    public double aplicarDescuento (List<ItemMenu> items) {
        double totalConDescuento = 0;
        for (ItemMenu item : items) {
            totalConDescuento += item.getPrecio ();
        }
        return totalConDescuento * 0.02f;
    }
}
