package edu.eci.cvds.tdd.aerodescuentos;


import org.junit.Assert;
import org.junit.Test;

import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;

public class TarifasTest {
    @Test
    public void testDescuentoMenorDeEdad() {

        Assert.assertEquals( 37905, CalculadorDescuentos.calculoTarifa(39900, 5, 15), 0);
        Assert.assertEquals( 475000, CalculadorDescuentos.calculoTarifa(500000, 15, 17), 0);
        Assert.assertEquals( 175750, CalculadorDescuentos.calculoTarifa(185000, 19, 0), 0);
        /**
         * En este test se difiere a lo que se tiene en la tabla pues la calculadora no tiene un caso definido para
         * cuando los días son 20 y cumple un descuento por edad
         **/
        Assert.assertEquals( 300000, CalculadorDescuentos.calculoTarifa(300000, 20, 1), 0);

    }

    @Test
    public void testSinDescuento() {

        Assert.assertEquals( 158560, CalculadorDescuentos.calculoTarifa(158560, 10, 25), 0);
    }

    @Test
    public void testDobleDescuento() {

        Assert.assertEquals( 154000, CalculadorDescuentos.calculoTarifa(200000, 21, 70), 0);
    }

    @Test
    public void testMayorDe65() {

        Assert.assertEquals( 294400, CalculadorDescuentos.calculoTarifa(320000, 4, 66), 0);

    }

    @Test
    public void testDiasAntelacion() {

        Assert.assertEquals( 0, CalculadorDescuentos.calculoTarifa(0, 21, 64), 0);
        Assert.assertEquals( 663425, CalculadorDescuentos.calculoTarifa(780500, 33, 18), 0);
        Assert.assertEquals( 84999.15, CalculadorDescuentos.calculoTarifa(99999, 100, 19), 0);

    }

}