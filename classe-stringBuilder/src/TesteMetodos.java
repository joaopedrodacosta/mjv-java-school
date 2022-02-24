public class TesteMetodos {
    public static void main(String[] args) {
        StringBuilder string1 = new StringBuilder(30);
        string1.append("Raimundo fhiuhafuiahsfiusdhfiusfesfsefsefesfsfsfsefsjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        string1.setLength(30);
        System.out.printf("string 1 = %s%n", string1.toString());
        System.out.printf("Capacidade = %s%n", string1.capacity());
        System.out.printf("Comprimento = %s%n", string1.length());
        System.out.printf("string 1 = %s%n", string1.toString());
        System.out.printf("Caractere na posição 0: %s%nCaractere na posição 3: %s%n%n",string1.charAt(0), string1.charAt(3));

        char[] arrayCaracteres = new char[string1.length()];
        string1.getChars(0, string1.length(), arrayCaracteres, 0);
        System.out.print("Os caracteres armazenados são: ");
        for (char c : arrayCaracteres)
           System.out.print(c);
           string1.setCharAt(0, 'o');
           string1.setCharAt(3, 'J');
        System.out.printf("%n%nstring1 = %s", string1.toString());
        string1.reverse();
        System.out.printf("%n%nstring1 = %s", string1.toString());

        
      
    }
}
