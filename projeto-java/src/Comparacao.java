public class Comparacao {

    public static void main(String[] args) {

        String nome1 = "JAVA";
        String nome2 = "JAVA";
        
        System.out.println(nome1 == nome2); //verdadeiro, comparando conteúdo

        String nome3 = new String("JAVA");
        
        System.out.println(nome1 == nome3); //falso, objetos diferentes

        String nome4 = nome3;

        System.out.println(nome3 == nome4); //true
        
        //equals 
        System.out.println(nome1.equals(nome2)); //true
        System.out.println(nome2.equals(nome3)); //true
        System.out.println(nome3.equals(nome4)); //true

    }

    }
    

