package org.example;

import java.util.List;

public class Mesa {
    private List<ItemMenu> consumos;
    private Tarjeta targetaPago;
    private PorcentajePropinas propinas;

    public Mesa (int capacidad, List<ItemMenu> consumos) {
        this.consumos = new ArrayList<>();
    }

   public void agregarItem (ItemMenu item){
        if( pedidoComfirmado){
            throw new IllegalStateExceptin("No se pueden agregar items despues de comfirmar el pedido");
        }
        consumos.add(item);
   }

   private boolean pedidoComfirmado = false;

    public void confirmarPedido (){
        pedidoComfirmado=true;
    }
    public void realizarPago (Tarjeta tarjeta, PorcentajePropinas){
        if(!pedidoComfirmado){
            throw new IllegalStateException("Debe confirmar el pedido antes de establecer el pago");
        }
        this.targetaPago = tarjeta;
        this.propinas = propinas;
    }

    public double calcularTotal (){
        if(!pedidoComfirmado){
            throw new IllegalStateException("Debe confirmar el pedido antes de calcular el costo");
        }
        double totalSinDescuento;
        for(ItemMenu item : consumos){
            totalSinDescuento+ = item.getPrecio;
        }

        double descuento = tarjetaPago.apicarDescuento(consumos);
        double totalConDescuento = totalSinDescuento - descuento;
        double propinaMonto = totalConDescuento * propinas.getValor();

        return totalConDescuento + propinaMonto;
    }

}

enum PorcentajePropinas {
    //CALCULAR LOS PORCENTAJES PARA CADA PROPINA
    DOS_PORCIENTO(0.02);
    TRES_PORCIENTO(0.03);
    CINCO_PORCIENTO(0.05);

    private final double valor;
    PorcentajePropinas (double Valor){
        valor = Valor;
    }

    public double getValor () {
        return valor;
    }
}
