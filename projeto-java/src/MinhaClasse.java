public class MinhaClasse {

    public static void main(String[] args) {

        int numeroUm = 30, numero2 = 47;
        int resuldado = MinhaClasse.somar(numeroUm, numero2);
    
        System.out.printf("A soma é: %d", resuldado);

    }

    static int somar (int numeroUm, int numero2){

        int resultado = numeroUm + numero2;
        return resultado;
    }
    
}
