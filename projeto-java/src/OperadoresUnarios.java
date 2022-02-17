public class OperadoresUnarios{

    public static void main(String [] args){
       
        int numero = 10;
		
        // numero negativo
        System.out.println(- numero);

        //incrementando mais 1 ao numero
        numero ++;
        System.out.println(numero);

        //printa primeiro e depois incrementa, printa 10
        System.out.println(numero ++);// ops algo de errado não está certo

        System.out.println(numero);// agora printa 11

        //incrementa primeiro e printa o numero com o incremento direto
        System.out.println(++ numero);

        boolean verdadeiro = true;

        System.out.println("Virou " + !verdadeiro);
        
    }
    
}
