public class TestePerf {
    public static void main(String[] args)  {
        long inicio = System.currentTimeMillis();
        concatString(30_000);
        long fim  = System.currentTimeMillis();
        System.out.println(":Concatenação:");
        System.out.println("Tempo gasto para String " + (fim - inicio) + "ms");

        inicio = System.currentTimeMillis();
        concatStringBuilder(30_000);
        fim  = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuilder " + (fim - inicio) + "ms");

    }


    private static void concatString(int tamanho){
        String texto = "";
        for(int i =0; i < tamanho; i++){
            texto +=i;
        }
    }

    private static void concatStringBuilder(int tamanho){
            StringBuilder sb = new StringBuilder();
            for(int i =0; i < tamanho; i++){
                sb.append(i);
            }
        }
    }

