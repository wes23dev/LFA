/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifcoder.lfa_automatos.modelo;

/**
 *
 * @author Windows
 */
public class TransicaoPilhaUnit {
    private int estadoDestino;
    private char simboloDesempilhar;
    private char simboloEmpilhar;

    public TransicaoPilhaUnit(int estadoDestino, char simboloDesempilhar, char simboloEmpilhar) {
        this.estadoDestino = estadoDestino;
        this.simboloDesempilhar = simboloDesempilhar;
        this.simboloEmpilhar = simboloEmpilhar;
    }

    public int getEstadoDestino() {
        return estadoDestino;
    }

    public char getSimboloDesempilhar() {
        return simboloDesempilhar;
    }

    public char getSimboloEmpilhar() {
        return simboloEmpilhar;
    }
}

