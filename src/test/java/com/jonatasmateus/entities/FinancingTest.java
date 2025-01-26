package com.jonatasmateus.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinancingTest {

    @Test
    void deveCriarObjetoQuandoDadosVálidosForemPassados() {
        assertDoesNotThrow(() -> {
            new Financing(20000.0, 4000.0, 8);
        });
    }

    @Test
    void deveLançarExceçãoQuandoInstânciaPossuiDadosInválidos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Financing(20000.0, 4000.0, 4);
        });
    }

    @Test
    void deveAtualizarQuantiaTotalComDadosVálidos() {
        assertDoesNotThrow(() -> {
            var financing = new Financing(20000.0, 4000.0, 8);
            financing.setTotalAmount(18000.0);
        });
    }

    @Test
    void deveLançarExceçãoQuandoQuantiaNãoÉVálida() {
        assertThrows(IllegalArgumentException.class, () -> {
            var financing = new Financing(20000.0, 4000.0, 8);
            financing.setTotalAmount(40000.0);
        });
    }

    @Test
    void deveAtualizarRendaMensalComDadosVálidos() {
        assertDoesNotThrow(() -> {
            var financing = new Financing(20000.0, 4000.0, 8);
            financing.setIncome(6000.0);
        });
    }

    @Test
    void deveLançarExceçãoQuandoRendaMensalNãoÉVálida() {
        assertThrows(IllegalArgumentException.class, () -> {
            var financing = new Financing(20000.0, 4000.0, 8);
            financing.setIncome(2000.0);
        });
    }

    @Test
    void deveAtualizarMesesComDadosVálidos() {
        assertDoesNotThrow(() -> {
            var financing = new Financing(20000.0, 4000.0, 8);
            financing.setMonths(10);
        });
    }

    @Test
    void deveLançarExceçãoQuandoMesesNãoÉVálido() {
        assertThrows(IllegalArgumentException.class, () -> {
            var financing = new Financing(20000.0, 4000.0, 8);
            financing.setMonths(4);
        });
    }

    @Test
    void deveCalcularCorretamenteValorEntrada() {
        var financing = new Financing(100000.0, 2000.0, 80);
        assertEquals(20000.0, financing.entry());
    }

    @Test
    void deveCalcularCorretamenteValorPrestação() {
        var financing = new Financing(100000.0, 2000.0, 80);
        assertEquals(1000.0, financing.quota());
    }
}