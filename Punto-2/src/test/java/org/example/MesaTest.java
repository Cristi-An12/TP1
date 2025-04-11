package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MesaTest {

    private Mesa mesa;
    private ItemMenu bebida1;
    private ItemMenu plato1;
    private ItemMenu bebida2;
    private ItemMenu plato2;

    @BeforeEach
    void setUp () {

        mesa = new Mesa ();

        bebida1 = new ItemMenu ("Coca Cola", 30, TipoItem.BEBIDA);
        plato1 = new ItemMenu ("Papas Fritas", 50, TipoItem.PLATO_PRINCIPAL);
        bebida2 = new ItemMenu ("Pepsi", 20, TipoItem.BEBIDA);
        plato2 = new ItemMenu ("Milanesa de pollo", 70, TipoItem.PLATO_PRINCIPAL);
    }

    @Test
    void calcularCostoCnTarjetaVisa () {

        mesa.agregarItem (bebida1);
        mesa.agregarItem (plato1);
        mesa.agregarItem (bebida2);
        mesa.confirmarPedido ();
        mesa.realizarPago (new Visa (), PorcentajePropinas.TRES_PORCIENTO);
        // Verificar: Calcular el costo correcto con descuento Visa
        // Costo de bebidas: 30 + 20 = 50
        // Descuento Visa (3% sobre bebidas): 50 * 0.03 = 1.5
        // Total con descuento: (30 + 20 + 50) - 1.5 = 98.5
        // Propina (2% del total con descuento): 98.5 * 0.03 = 2.955
        // Total a pagar: 98.5 + 2.955 = 101.455
        //averiguar porque no obtiene el resultado como double
        assertEquals (101.45, mesa.calcularTotal (), 0.01);
    }

    @Test
    void calcularCostoCnTarjetaMastercad () {
        mesa.agregarItem (plato1);
        mesa.agregarItem (bebida1);
        mesa.agregarItem (plato2);
        mesa.confirmarPedido ();
        mesa.realizarPago (new Mastercad (), PorcentajePropinas.TRES_PORCIENTO);
        // Verificar: Calcular el costo correcto con descuento Mastercad
        // Costo de platos: 50 + 70 = 120
        // Descuento Mastercad (3% sobre bebidas): 120 * 0.02 = 2.4
        // Total con descuento: (50 + 70 + 30) - 2.4 = 147.6
        // Propina (3% del total con descuento): 147.6 * 0.03 = 4.428
        // Total a pagar: 147.6 + 4.428 = 152.028
        assertEquals (152.02, mesa.calcularTotal (), 0.01);
    }

    @Test
    void calcularCostoCnTarjetaComarcaPlus () {
        mesa.agregarItem (plato1);
        mesa.agregarItem (bebida1);
        mesa.agregarItem (plato2);
        mesa.agregarItem (bebida2);
        mesa.confirmarPedido ();
        mesa.realizarPago (new ComarcaPlus (), PorcentajePropinas.TRES_PORCIENTO);
        // Verificar: Calcular el costo correcto con descuento Mastercad
        // Costo total: 50 + 70 + 30 + 20 = 170
        // Descuento Comarca plus (2% sobre bebidas): 170 * 0.02 = 3.4
        // Total con descuento: (50 + 70 + 30 + 20) - 3.4 = 166.6
        // Propina (3% del total con descuento): 166.6 * 0.03 = 4.998
        // Total a pagar: 166.6 + 4.998 = 171.598
        assertEquals (171.59, mesa.calcularTotal (), 0.01);

    }

    @Test
    void calcularCostoCnTarjetaViedma () {
        mesa.agregarItem (bebida2);
        mesa.agregarItem (plato2);
        mesa.agregarItem (bebida1);
        mesa.agregarItem (plato1);
        mesa.confirmarPedido ();
        mesa.realizarPago (new OtraTarjeta (), PorcentajePropinas.TRES_PORCIENTO);

        //Costo consumo: 50 + 70 + 30 + 20 = 170
        //propina: 170 * 0.03 = 5.1
        //Costo Total: 170 + 5.1= 175.10
        assertEquals (175.10, mesa.calcularTotal (), 0.01);
    }

    @Test
    void sinConfirmarPedido () {
        mesa.agregarItem (bebida2);
        mesa.agregarItem (plato2);
        mesa.agregarItem (bebida1);
        mesa.agregarItem (plato1);

        assertThrows (IllegalStateException.class, () -> {
            mesa.calcularTotal ();
        });
    }

    @Test
    void AgregarItemDespuesDeComfirmar () {
        mesa.agregarItem (plato1);
        mesa.agregarItem (plato1);
        mesa.confirmarPedido ();
        assertThrows (IllegalStateException.class, () -> {
            mesa.agregarItem (bebida1);
        });
    }

    @Test
    void RealizarPagoSinComfirmar () {
        mesa.agregarItem (bebida1);
        mesa.agregarItem (bebida2);

        assertThrows (IllegalStateException.class, () -> {
            mesa.realizarPago (new Mastercad (), PorcentajePropinas.CINCO_PORCIENTO);
        });
    }
}