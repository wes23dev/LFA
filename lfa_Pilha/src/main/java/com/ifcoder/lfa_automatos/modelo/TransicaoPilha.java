package com.ifcoder.lfa_automatos.modelo;

import com.ifcoder.lfa_automatos.modelo.ChaveTransicao;
import com.ifcoder.lfa_automatos.modelo.TransicaoPilhaUnit;
import java.io.*;
import java.util.*;

public class TransicaoPilha {
    private Map<ChaveTransicao, List<TransicaoPilhaUnit>> transicoes;

    public TransicaoPilha() {
        transicoes = new HashMap<>();
    }

    public void carregarDeArquivo(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(",");
                int origem = Integer.parseInt(partes[0]);
                String simbolo = partes[1]; // "a", "b" ou "-"
                char desempilhar = partes[2].charAt(0);
                char empilhar = partes[3].charAt(0);
                int destino = Integer.parseInt(partes[4]);

                ChaveTransicao chave = new ChaveTransicao(origem, simbolo);
                TransicaoPilhaUnit trans = new TransicaoPilhaUnit(destino, desempilhar, empilhar);

                transicoes.computeIfAbsent(chave, k -> new ArrayList<>()).add(trans);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<TransicaoPilhaUnit> getTransicoes(int estado, String simbolo) {
        return transicoes.getOrDefault(new ChaveTransicao(estado, simbolo), new ArrayList<>());
    }
}
