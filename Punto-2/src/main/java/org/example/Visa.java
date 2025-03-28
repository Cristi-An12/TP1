package org.example;

public class Visa implements Targeta {


    @Override
    public double aplicarDescuento (double costoBebidas, double costoPlato) {
        return costoBebidas * 0.97f + costoPlato;
    }
}
