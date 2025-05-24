package classe;


public class ExpressaoRegular {
    public String BRANCO, BRANCOS;     //' ' (espaço), '\t' TAB, '\n' new line, '\r' volta o cursos para o inicio da linha, '\f' avanço de pagina, '\v' vertical TAB - (usado em configuraçoes de impressora)
    public String DIGITO, DIGITOS;
    public String LETRA , LETRAS;
    public String IDENT;
    public String EXPONENCIAL;
    public String FRACIONARIA;
    public String REAL;
    public String IMAGEM;
    public String DATA;
    
    public String INTEIRO;
    public String NUMEROS;
    public String ATRIBUICAO;
    public String INTERIORVETOR;   
    public String INDEXADOR;    
    public String DESIGNADOR;
    public String EMAIL;
    public String SINAL;

    public ExpressaoRegular() {
        this.BRANCO = "(\\s)";
        this.BRANCOS = BRANCO + "*";
        this.DIGITO = "([0-9])";
        this.DIGITOS = DIGITO + "*";
        this.LETRA = "([A-Za-z])";
        this.LETRAS = LETRA + "*";
        this.SINAL = "(-)?";
        
        this.IDENT = "(" + LETRA + "(" + LETRA + "|" 
                + DIGITO + ")*)"; 
        
        this.EXPONENCIAL = "(E(\\+|-)" + DIGITOS + ")";
        this.FRACIONARIA = "\\.?" + DIGITOS + EXPONENCIAL+"?";
        
        //Atividade 6
        this.REAL = SINAL + DIGITOS + FRACIONARIA + EXPONENCIAL;
        this.IMAGEM = ".*(\\.png|\\.jpe?g|\\.bmp)";
        this.DATA = DIGITO+"{2}" + "/" + DIGITO + DIGITO
                + "/" + DIGITO+"{4}";
        this.INTEIRO = INTEIRO;
        this.NUMEROS = NUMEROS;
        this.ATRIBUICAO = ATRIBUICAO;
        this.INTERIORVETOR = INTERIORVETOR;
        this.INDEXADOR = INDEXADOR;
        this.DESIGNADOR = DESIGNADOR;
        
        //Atividade 5
        this.EMAIL = "(" + LETRAS + "|" + DIGITOS + ")+" + 
             "@" + 
             "(" + LETRAS + "|" + DIGITOS + ")+" + 
             "\\." + 
             LETRAS;

    }
    

    
    
    public void confere(String exp, String sentenca){
        if((sentenca != null)&& !sentenca.isEmpty()){
            if(sentenca.matches(exp)){
            System.out.println("W: '" + sentenca + "'......ACEITA!");
            }else{
                System.out.println("W: '" + sentenca + "'.....REJEITADA.");
            }
        }else{ 
            System.out.println("Sentenca vazia.");
        }
    }   
}
