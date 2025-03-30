package org.example;

public class Visa implements Targeta {

    @Override
    public double aplicarDescuento (List <ItemMenu> items) {
        double totalConDescuento;
        for (ItemMenu item : items){
            if (item.getItem().getTipo() == TipoItem.BEBIDA) {
                totalConDescuento += item.getPrecio();
            }
        }
        return totalConDescuento;

    }
}
