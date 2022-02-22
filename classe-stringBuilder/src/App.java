public class App {
    public static void main(String[] args) {
        StringBuilder string1 = new StringBuilder("João Pedro");

        System.out.printf("string 1 = %s%n", string1.toString());
        System.out.printf("Capacidade = %s%n", string1.capacity());
        System.out.printf("Comprimento = %s%n", string1.length());
        string1.setLength(5);
        System.out.printf("Novo comprimento %d%n", string1.length());
        System.out.printf("string 1 = %s%n", string1.toString());
    }
}
