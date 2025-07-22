/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifcoder.lfa_automatos.modelo;

/**
 *
 * @author Windows
 */
import java.util.Objects;

public class ChaveTransicao {
    private int estadoOrigem;
    private String simboloEntrada;

    public ChaveTransicao(int estadoOrigem, String simboloEntrada) {
        this.estadoOrigem = estadoOrigem;
        this.simboloEntrada = simboloEntrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChaveTransicao)) return false;
        ChaveTransicao that = (ChaveTransicao) o;
        return estadoOrigem == that.estadoOrigem &&
               simboloEntrada.equals(that.simboloEntrada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estadoOrigem, simboloEntrada);
    }
}

