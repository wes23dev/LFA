package com.ifcoder.lfa_automatos.modelo;

import com.ifcoder.lfa_automatos.modelo.TransicaoPilhaUnit;
import java.util.*;

public class Automato {
    private String sentenca;
    private TransicaoPilha matriz;
    private int estadoInicial;
    private List<Integer> estadosFinais;

    public Automato() {
        this.sentenca = "";
        this.estadoInicial = 0;
        this.estadosFinais = new ArrayList<>();
        this.estadosFinais.add(3);
        this.estadosFinais.add(2);
        this.matriz = new TransicaoPilha();
        this.matriz.carregarDeArquivo("transicoes.txt");
    }

    public boolean verificaSentenca(String sentenca) {
        this.sentenca = sentenca;
        Stack<Character> pilha = new Stack<>();
        pilha.push('Z'); // símbolo inicial da pilha
        return processa(estadoInicial, sentenca, 0, pilha);
    }

    private boolean processa(int estadoAtual, String entrada, int pos, Stack<Character> pilha) {
        System.out.println("Estado: " + estadoAtual + ", posicao: " + pos + ", pilha: " + pilha + ", proximo simbolo: " + (pos < entrada.length() ? entrada.charAt(pos) : "ε"));
    
        if (pos == entrada.length()) {
            // Verifica transição epsilon no fim
            List<TransicaoPilhaUnit> transicoes = matriz.getTransicoes(estadoAtual, "-");
            for (TransicaoPilhaUnit trans : transicoes) {
                if (podeDesempilhar(pilha, trans.getSimboloDesempilhar())) {
                    Stack<Character> novaPilha = copiaPilha(pilha);
                    desempilhar(novaPilha, trans.getSimboloDesempilhar());
                    empilhar(novaPilha, trans.getSimboloEmpilhar());
                    if (processa(trans.getEstadoDestino(), entrada, pos, novaPilha)) return true;
                }
            }
            return (pilha.isEmpty() || (pilha.peek() == 'Z' && pilha.size() == 1));
          }

        String simboloAtual = String.valueOf(entrada.charAt(pos));
        List<TransicaoPilhaUnit> transicoes = matriz.getTransicoes(estadoAtual, simboloAtual);

        for (TransicaoPilhaUnit trans : transicoes) {
            if (podeDesempilhar(pilha, trans.getSimboloDesempilhar())) {
                Stack<Character> novaPilha = copiaPilha(pilha);
                desempilhar(novaPilha, trans.getSimboloDesempilhar());
                empilhar(novaPilha, trans.getSimboloEmpilhar());
                if (processa(trans.getEstadoDestino(), entrada, pos + 1, novaPilha)) return true;
            }
        }

        return false;
    }

    private boolean podeDesempilhar(Stack<Character> pilha, char simbolo) {
        return simbolo == '-' || (!pilha.isEmpty() && pilha.peek() == simbolo);
    }

    private void desempilhar(Stack<Character> pilha, char simbolo) {
        if (simbolo != '-') pilha.pop();
    }

    private void empilhar(Stack<Character> pilha, char simbolo) {
        if (simbolo != '-') pilha.push(simbolo);
    }

    // Método para copiar a pilha sem usar clone() e evitar warning unchecked
    private Stack<Character> copiaPilha(Stack<Character> pilha) {
        Stack<Character> nova = new Stack<>();
        nova.addAll(pilha);
        return nova;
    }
}
