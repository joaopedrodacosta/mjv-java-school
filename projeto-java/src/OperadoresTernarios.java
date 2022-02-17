public class OperadoresTernarios {

    public static void main(String [] args){
        int notaCorte = 6;
        int nota = 10;
        /*
        if(notaCorte==nota)
        resultado = "verdadeiro";
        else
        resultado = "falso";
        */
        String resultado = (notaCorte<=nota) ? "aprovado" : "reprovado";
        System.out.println(resultado);

    }
    
}
