package com.mycompany.main;

import classe.ExpressaoRegular;

public class Main {

    public static void main(String[] args) {
        ExpressaoRegular er = new ExpressaoRegular();

        // Teste do binário Atividade 1- a)
        er.confere("(0|1)(0|1)(0|1)+", "101");
        
        //Teste de palavras que contenham aa ou bb como subpalavra Atividade 2
        er.confere( er.LETRAS + "(aa|bb)" + er.LETRAS, "aaabbb");

        // Teste do e-mail Atividade 5
        er.confere( er.EMAIL ,"WAMartinsdeAndrade@gmail.com");
        
        //Teste do numero real +/- com expoente (-10.1^2)Atividade 6
        er.confere(er.REAL, "-10.1E+2");
    }
}
