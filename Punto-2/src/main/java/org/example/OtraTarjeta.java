package org.example;

import java.util.List;

public class OtraTarjeta implements Tarjeta {
    @Override
    public double aplicarDescuento (List<ItemMenu> items) {
        //sin descuento
        return 0;
    }
}
