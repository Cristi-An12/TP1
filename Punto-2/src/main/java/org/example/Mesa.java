package org.example;

import java.util.List;

public class Mesa {
    private int capacidad;
    private List<ItemMenu> consumos;
    private Pedido pedidoActual;

    public Mesa (int capacidad, List<ItemMenu> consumos) {
        this.capacidad = capacidad;
        this.consumos = consumos;
    }

    void calcularPrecio (List<ItemMenu> consumos, Targeta targeta) {

    }

    public void crearPedido () {
        if (pedidoActual != null && !pedidoActual.estaComfirmado ()) {
            throw new IllegalStateException ("ya existe un pedido sin comfirmar");
        }
        pedidoActual = new Pedido (false, consumos);
    }

    public void agregarItemsAlPedido (String nombre, double precio, TipoItem tipo, int cantidad) {
        if (pedidoActual == null) {
            throw new IllegalStateException ("No hay un pedido activo");
        }
        pedidoActual.agregarItem (nombre, precio, tipo, cantidad);
    }

    public void comfirmarPedido () {
        if (pedidoActual == null) {
            throw new IllegalStateException ("no hay pedido activo");
        }
        pedidoActual.comfirmar ();
    }

    public Pedido pedidoActual () {
        return pedidoActual;
    }


}
