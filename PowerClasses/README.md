## java.lang.String 
É utilizada para representar textos através de uma cadeia de caracteres,
todos literais em string são implementados com essa classe no Java, após atribuídos não
podem ser alterados.

**Alternativas de instanciação de objetos com construtor ou métodos singleton:**

Utilizando construtor para instanciar um Objeto String: String texto = **new**

String("Instanciando um novo objeto tipo String");

Utilizando método Singleton para Instanciar :

A implementação consiste em um construtor privado e um campo para armazenar seu
resultado, além de um método de acesso estático com o nome **getInstance()**.

O campo privado pode ser atribuído de dentro de um bloco inicializador estático ou usando
um inicializador. O método **getInstance()**, que deve ser público, retorna a esta instância.

>public class Singleton {
>
>private static Singleton singleton = new Singleton();

//Um construtor privado impede que a classe seja instanciada

>private Singleton() {}
>
>public static Singleton getInstance() {
>
>return singleton;
>
>}

// Método protegido pela instância da classe

>protected static void imprimeMensagem() {
>
>String mensagem = "Hello Word";
>
>System.out.println (mensagem);
>
>}
>
>}

Para executar o método **imprimeMensagem()**, que está protegido na classe Singleton,
devemos pegar uma instância da classe para poder ter acesso:


>public class ExemploSingleton {
>
>public static void main (String [] args) {
>
>Singleton singleton = Singleton.getInstance ();
>
>singleton.imprimeMensagem();
>
>}
>
>}


O resultado da execução acima será: “Hello, Singleton” e toda vez que o método for
executado, a JVM utilizará a mesma instância da classe para responder e nenhum novo
objeto do tipo será instanciado.


**Métodos:**

__compareToIgnoreCase(String exemplo)__ - Método compara duas strings ignorando
se é maiuscula ou minuscula. Retorna um int sendo 0 verdadeiro -1 falso;

__format(String exemplo, “argumento”)__ - Método formata a string a partir de
argumentos, retorna o valor do argumento a string

__concat(String exemplo)__ - Método concatena a string especificada ao final da string
onde método foi chamado.

__split(String exemplo )__ - Método Divide esta string em várias substrings a partir de
um delimitador indicado pelo usuário;

**Método sobrecarregado:**

>@Override
>public String toString(){
>
>return "Esse é meu objeto Random";
>
>}

**Demonstração adaptando o uso dos métodos:**

- Verificação de Banco de dados : login.compareToIgnoreCase(String exemplo) -
Método compararia se o login corresponde a string que usei no ao logar site.

- Realizar cadastro no banco de dados: nome.format(String exemplo, “argumento”)
para atribuir um dados para operação do crud.

- Também no cadastro e banco de dados : nome.concat(sobrenome) para concatenar
nomes, endereço ou qualquer outra informação de cadastro;

- Caso eu tenha um cadastro e CPF e precise transformar as informações num array
posso usar o método split, basta aplicar o método Split da seguinte forma: cpf.split("
. ");



## java.util.StringJoiner
StringJoiner é usado para construir uma sequência de caracteres separados por um _delimitador_ e, opcionalmente, começando com um _prefixo_ fornecido e terminando com um _sufixo_ fornecido.

_Delimitador_ a sequência de caracteres a ser usada entre
cada elemento adicionado ao valor StringJoiner
_Exemplo:_ ( " , "  )

_Prefixo_  a sequência de caracteres a ser usada no início _Exemplo:_ ( " [ ")

_Sufixo_ a sequência de caracteres a ser usada no final   _Exemplo:_( " ] " )

![Captura_de_tela_de_2022-02-22_11-51-10 readme](https://user-images.githubusercontent.com/86434650/155159138-bd63975a-e13e-4db5-8330-d4cc302473e7.png)



**CONSTRUTORES:**

**StringJoiner (CharSequence delimiter)**
Constrói um StringJoiner sem caracteres, sem prefixo ou sufixo e uma cópia do delimitador fornecido.

**StringJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix)** Constrói um StringJoiner sem caracteres usando cópias do prefixo, delimitador e sufixo fornecidos.

Exemplos:

A String " [ Miguel:Pedro]" pode ser construída da seguinte forma:


>StringJoiner nome  = new StringJoiner( ":" , "[" ,"]");
>
>nome.add("Miguel");
>
>nome.add("Pedro");

**Saída:**
>[Miguel:Pedro]




**MÉTODOS:**

__toString()__
é usado para converter StringJoiner em String. Ele retorna o valor atual, consistindo no prefixo, os valores adicionados até agora separados pelo delimitador e o sufixo, a menos que nenhum elemento tenha sido adicionado.

>Sintaxe:
public String toString()


Retorna: Este método retorna a representação de string deste StringJoiner.

import java.util.StringJoiner;

    public class testes {
        public static void main(String[] args) {

        StringJoiner nome  = new StringJoiner(",","[","]");
            
            nome.add("Miguel");
            nome.add("Pedro");

            System.out.println("Nomes: "
                    + nome.toString());


**Saída:**
>Nomes: [Miguel,Pedro]




__merge()__
adiciona o conteúdo do StringJoiner fornecido sem prefixo e sufixo como o próximo elemento se não estiver vazio. Se o StringJoiner fornecido estiver vazio, a chamada não terá efeito.


>Sintaxe:
public StringJoiner merge(StringJoiner other)



Parâmetros: Este método aceita um parâmetro obrigatório outro que é o StringJoiner cujo conteúdo deve ser mesclado com este

Retorna: Este método retorna este StringJoiner

Exceção: este método lança **NullPointerException** se o outro StringJoiner for nulo

import java.util.StringJoiner;

    public class testes {
        public static void main(String[] args) {

          StringJoiner nome  = new StringJoiner(",","[","]");

            nome.add("Miguel");
            nome.add("Pedro");

            System.out.println("Nomes: "
                    + nome.toString());

            // criamos uma nova cadeia de caracteres
            StringJoiner country = new StringJoiner(",","{","}");
            country.add("Peru");
            country.add("Brasil");

            System.out.println("Cidades: "
                    + country.toString());

            // Podemos mesclar dois joiners usando merge().
            
            StringJoiner merged = nome.merge(country);

            System.out.println(merged.toString());


        }

    }

**Saída:**

>Nomes: [Miguel,Pedro]
>
>Cidades: {Peru,Brasil}
>
>[Miguel,Pedro,Peru,Brasil]




__lenght()__
é usado para descobrir o comprimento do StringJoiner em caracteres. Ele retorna o comprimento da representação String deste StringJoiner.


import java.util.StringJoiner;

    public class testes {
        public static void main(String[] args) {

           StringJoiner nome  = new StringJoiner(",","[","]");
            
            nome.add("Miguel");
            nome.add("Pedro");

            System.out.println("Nomes: "
                    + nome.toString());

            System.out.println(nome.length());

**Saída:**

>Nomes: [Miguel,Pedro]
>
>14


## java.lang.StringBuilder
Uma String é um tipo de variável que armazena um conjunto de caracteres, porém não é possível modificá-la, seja em conteúdo ou tamanho.
O StringBuilder permite a criação de variáveis do tipo String modificáveis, possibilitando como por exemplo
armazenar caracteres de acordo com a capacidade estabelecida e caso ela seja
excedida o tamanho da String é aumentado para armazenar os caracteres adicionais.

A classe pode ser instanciada de várias formas:

// Forma padrão, objeto com capacidade padrão de 16 caracteres

> StringBuilder string1 = new StringBuilder();

//Objeto com a capacidade inicial de caracteres especificado

>StringBuilder string2 = new StringBuilder(50);

//Objeto com uma String sendo passada direta nos parâmetros

//A capacidade dessa instância é o número de caracteres inseridos mais os 16
padrões
 
> StringBuilder string3 = new StringBuilder(“Hello World”);

//Lembrando que em todas as situações a capacidade de caracteres pode ser alterada
posteriormente.

//Ao realizar:
 
>System.out.printf(“string1 = \”%s\”%n”, string1);
>
>System.out.printf(“string2 = \”%s\”%n”, string2);
>
>System.out.printf(“string3 = \”%s\”%n”, string3);

O resultado da execução será:

>string1 = “”
>
>string2 = “”
>
>string3 = “Hello World”

**MÉTODOS:**

 __append__  Utilizado para adicionar uma representação de String de um
argumento. Ele é um método sobrecarregado (sobrecarga ou Overload) ou seja
permite a existência de vários métodos com o mesmo nome, porém com uma lista de
argumentos diferentes. É do tipo StringBuilder e retorna uma StringBuilder.

O método append é muito usado na concatenação de strings que é uma
característica importante no StringBuilder, pois aloca as novas strings para o mesmo
objeto melhorando o desempenho do sistema, pois evita a criação de cópias dos
objetos diferentemente do método concat da classe String. Utilizar muitos appends
numa String de 15-20 concatenações fica complicado de ler depois de um tempo.

 __length__ Método do tipo int que retorna o número de caracteres armazenados no
momento no objeto StringBuilder.

__capacity__  Método do tipo int que retorna o número de caracteres que podem ser
armazenados no objeto sem a necessidade de alocar mais memória.

__SetLength__ - Método do tipo void, logo sem retorno, aumenta ou diminui o comprimento de um objeto, onde o novo comprimento é especificado no parâmetro e no caso da diminuição se o objeto já possuir um conteúdo os caracteres que excederem o novo comprimento serão “perdidos”.

__Métodos de manipulação (dois exemplos):__ 

_Método charAt_ – método do tipo char querecebe um inteiro como argumento e retorna o caractere armazenado no objeto, na
posição desse número de índice.

_Método setCharAt_ método do tipo void que recebe dois argumentos: um inteiro e um
caractere, gravando o caractere passado na posição especificada pelo valor inteiro.

Como dito antes o método append é um método sobrecarregado como podemos ver
nas sobrecargas abaixo, onde todas irão retornar um objeto StringBuilder:

>public StringBuilder append(Object obj)
>
>public StringBuilder append(String str)
>
>public StringBuilder append(StringBuffer sb)
>
>public StringBuilder append(CharSequence s)
>
>public StringBuilder append(CharSequence s, int start, int end)
>
>public StringBuilder append(char[] str)
>
>public StringBuilder append(char[] str, int offset, int len)
>
>public StringBuilder append(boolean b)
>
>public StringBuilder append(char c)
>
>public StringBuilder append(int i)
>
>public StringBuilder append(long lng)
>
>public StringBuilder append(float f)
>
>public StringBuilder append(double d)

Como exemplo do cotidiano temos o próprio exercício da aula passada, onde na classe
ContratoService tínhamos uma situação de concatenação de strings que com a utilização
do método append foi possível melhorar o desempenho da aplicação já que a
concatenação utilizando StringBuilder é muito mais rápida em relação a forma normal, e foi
utilizado também o método toString() para o método retornar um string e não uma
StringBuilder.

![StringBuilder2](https://user-images.githubusercontent.com/86434650/155191580-3c24c2fa-5ff7-42ae-bbe0-8729599b02d1.png)

**Outros exemplos**

Teste dos métodos

    public class TesteMetodos {

    public static void main(String[] args) {
  
        StringBuilder string1 = new StringBuilder("João Pedro");
        System.out.printf("string 1 = %s%n", string1.toString());
        System.out.printf("Capacidade = %s%n", string1.capacity());
        System.out.printf("Comprimento = %s%n", string1.length());
        
        string1.setLength(4);
        System.out.printf("Novo comprimento %d%n", string1.length());
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

Teste de performance

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

    

**Observação/curiosidade:** Objetos StringBuilder não são seguros em threads múltiplas. Se vários threads precisarem acessar a mesma informação de string dinâmica, é recomendável usar a classe StringBuffer, que é um método sincronizado que possui a mesma funcionalidade da classe StringBuilder, mas com segurança em threads.


**REFERÊNCIAS:**

#### java.lang.String 

* [Site Guj](https://www.guj.com.br/)

* [Site Code Snippet](https://codesnippet.com.br/)

#### java.util.StringJoiner

* [Documentação Oracle](https://docs.oracle.com/javase/8/docs/api/java/util/StringJoiner.html#toString--)

* [Site Acervo Lima](https://acervolima.com/java-util-stringjoiner-em-java8/)


#### java.lang.StringBuilder

* [stackoverflow](https://pt.stackoverflow.com/questions/16050/string-e-sua-efici%C3%AAncia)

* [Documentação Oracle](https://docs.oracle.com/javase/tutorial/java/data/buffers.html)

* [Documentação Microsoft](https://docs.microsoft.com/pt-br/dotnet/api/system.text.stringbuilder?view=net-6.0)

* [Vídeo Classe StringBuilder em Java (parte 1) - Instanciação, comprimento e capacidade do objeto](https://www.youtube.com/watch?v=J3zkS3dgaiM)

* [Vídeo 108 - Classes Utilitárias - Strings pt 01](https://www.youtube.com/watch?v=vH7izlkNewI&list=PL62G310vn6nFIsOCC0H-C2infYgwm8SWW&index=110)






