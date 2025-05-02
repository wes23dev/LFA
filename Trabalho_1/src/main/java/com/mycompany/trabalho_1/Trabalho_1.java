/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalho_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Windows
 */
public class Trabalho_1 {
     private static class Transicao {
        int estadoOrigem;
        char simbolo;
        int estadoDestino;

        public Transicao(int origem, char simbolo, int destino) {
            this.estadoOrigem = origem;
            this.simbolo = simbolo;
            this.estadoDestino = destino;
        }
    }

    private static class Aut {
        private final List<Transicao> transicoes;
        private final Set<Integer> estadosFinais;
        private final String alfabeto = "ab";

        public Aut(List<Transicao> transicoes, Set<Integer> estadosFinais) {
            this.transicoes = transicoes;
            this.estadosFinais = estadosFinais;
        }

        public boolean reconhecer(String palavra) {
            int estadoAtual = 0;

            for (char c : palavra.toCharArray()) {
                if (alfabeto.indexOf(c) == -1) {
                    return false;
                }

                boolean transicaoEncontrada = false;

                for (Transicao t : transicoes) {
                    if (t.estadoOrigem == estadoAtual && t.simbolo == c) {
                        estadoAtual = t.estadoDestino;
                        transicaoEncontrada = true;
                        break;
                    }
                }

                if (!transicaoEncontrada) {
                    return false;
                }
            }

            return estadosFinais.contains(estadoAtual);
        }
    }

    private static Aut lerAutomatoDeArquivo() throws IOException {
        InputStream input = Trabalho_1.class.getResourceAsStream("/com/mycompany/automato/automato.csv");

        if (input == null) {
            throw new FileNotFoundException("Arquivo automato.csv nao encontrado.");
        }

        BufferedReader leitor = new BufferedReader(new InputStreamReader(input));

        String primeiraLinha = leitor.readLine();
        String[] finaisStr = primeiraLinha.split(";")[1].trim().split(",");
        Set<Integer> estadosFinais = new HashSet<>();
        for (String f : finaisStr) {
            estadosFinais.add(Integer.parseInt(f.trim()));
        }

        List<Transicao> transicoes = new ArrayList<>();
        String linha;
        while ((linha = leitor.readLine()) != null) {
            if (linha.trim().isEmpty() || linha.startsWith("#")) continue;

            String[] partes = linha.trim().split(";");
            if (partes.length == 3) {
                int origem = Integer.parseInt(partes[0]);
                char simbolo = partes[1].charAt(0);
                int destino = Integer.parseInt(partes[2]);

                transicoes.add(new Transicao(origem, simbolo, destino));
            }
        }

        return new Aut(transicoes, estadosFinais);
    }

    public static void main(String[] args) {
        
         try (Scanner scanner = new Scanner(System.in)) {
            Aut automato = lerAutomatoDeArquivo();
            System.out.println("\nDigite palavras para testar (ou 'sair' para encerrar):");

            while (true) {
                String palavra = scanner.nextLine();
                if (palavra.equalsIgnoreCase("sair")) {
                    break;
                }
                boolean resultado = automato.reconhecer(palavra);
                System.out.println("Palavra \"" + palavra + "\" eh " + (resultado ? "ACEITA!!" : "REJEITADA ❌"));
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o autômato: " + e.getMessage());
        }
    }
    }
    

