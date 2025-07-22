
package com.ifcoder.lfa_automatos;

import com.ifcoder.lfa_automatos.modelo.Automato;


public class LFA_Automatos {

    public static void main(String[] args) {
        Automato linguagemAABB = new Automato();        

        if (linguagemAABB.verificaSentenca("ab")) {
            System.out.println("Aceita");
        }else{
            System.out.println("Rejeita");
        }
    }
}
