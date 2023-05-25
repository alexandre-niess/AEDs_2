import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.*;

class MyIO {

  private static BufferedReader in = new BufferedReader(
      new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
  private static String charset = "ISO-8859-1";

  public static void setCharset(String charset_) {
    charset = charset_;
    in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
  }

  public static void print() {
  }

  public static void print(int x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void print(float x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void print(double x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void print(String x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void print(boolean x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void print(char x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println() {
  }

  public static void println(int x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println(float x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println(double x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println(String x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println(boolean x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void println(char x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.println(x);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static void printf(String formato, double x) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.printf(formato, x);// "%.2f"
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
  }

  public static double readDouble() {
    double d = -1;
    try {
      d = Double.parseDouble(readString().trim().replace(",", "."));
    } catch (Exception e) {
    }
    return d;
  }

  public static double readDouble(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readDouble();
  }

  public static float readFloat() {
    return (float) readDouble();
  }

  public static float readFloat(String str) {
    return (float) readDouble(str);
  }

  public static int readInt() {
    int i = -1;
    try {
      i = Integer.parseInt(readString().trim());
    } catch (Exception e) {
    }
    return i;
  }

  public static int readInt(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readInt();
  }

  public static String readString() {
    String s = "";
    char tmp;
    try {
      do {
        tmp = (char) in.read();
        if (tmp != '\n' && tmp != ' ' && tmp != 13) {
          s += tmp;
        }
      } while (tmp != '\n' && tmp != ' ');
    } catch (IOException ioe) {
      System.out.println("lerPalavra: " + ioe.getMessage());
    }
    return s;
  }

  public static String readString(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readString();
  }

  public static String readLine() {
    String s = "";
    char tmp;
    try {
      do {
        tmp = (char) in.read();
        if (tmp != '\n' && tmp != 13) {
          s += tmp;
        }
      } while (tmp != '\n');
    } catch (IOException ioe) {
      System.out.println("lerPalavra: " + ioe.getMessage());
    }
    return s;
  }

  public static String readLine(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readLine();
  }

  public static char readChar() {
    char resp = ' ';
    try {
      resp = (char) in.read();
    } catch (Exception e) {
    }
    return resp;
  }

  public static char readChar(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readChar();
  }

  public static boolean readBoolean() {
    boolean resp = false;
    String str = "";

    try {
      str = readString();
    } catch (Exception e) {
    }

    if (str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") ||
        str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")) {
      resp = true;
    }

    return resp;
  }

  public static boolean readBoolean(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readBoolean();
  }

  public static void pause() {
    try {
      in.read();
    } catch (Exception e) {
    }
  }

  public static void pause(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    pause();
  }
}

public class LerURL {
  public static void main(String[] args) {
    MyIO.setCharset("UTF-8");
    String nomePagina;
    String endereco;
    boolean notFim;
    String[] arrayLetras = { "a", "e", "i", "o", "u", "á", "é", "í", "ó", "ú", "à", "è", "ì", "ò", "ù", "ã", "õ", "â",
        "ê", "î", "ô", "û" };
    int[] arrayValores = new int[25];

    Scanner in = new Scanner(System.in);
    do {
      nomePagina = in.nextLine();
      notFim = notFim(nomePagina); // Se string for diferente de FIM, a execucao continua
      if (notFim) {
        endereco = in.nextLine();
        zerarArray(arrayValores);
        try {
          lerPagina(endereco, arrayValores, arrayLetras);
        } catch (Exception e) {
          return;
        }

        for (int i = 0; i < 21; i++)
          MyIO.print(arrayLetras[i] + "(" + arrayValores[i] + ") ");

        MyIO.print("<br>(" + arrayValores[23] + ") ");
        MyIO.print("<table>(" + arrayValores[24] + ") ");
        MyIO.println(nomePagina);
        // notFim = false;
      }
    } while (notFim);
  }

  public static void lerPagina(String endereco, int[] arrayValores, String[] arrayLetras) throws Exception {
    String linha = "";
    URL url = new URL(endereco);
    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
    zerarArray(arrayValores);

    while (linha != null) {
      linha = br.readLine();
      if (linha != null) {
        contarValores(linha, arrayValores, arrayLetras);
      }
    }
  }

  /*
   * Verifica se a palavra inserida pelo usuario eh igual a FIM. Se for diferente,
   * retorna True
   */
  public static boolean notFim(String string) {
    boolean notFim = false;

    if (string.charAt(0) != 'F' || string.charAt(1) != 'I' || string.charAt(2) != 'M') {
      notFim = true;
    }

    return notFim;
  }

  /*
   * Set todos valores do array recebido para 0
   */
  public static void zerarArray(int[] entrada) {
    for (int i = 0; i < entrada.length; i++) {
      entrada[i] = 0;
    }
  }

  /*
   * Usar a funcao isConso para pegar consoantes, depois usar charAt() pra
   * descobrir as letras. Para <br> e <table>, pensar jogar
   * na funcao isTable e isLineBreak
   */
  public static void contarValores(String pagina, int[] arrayValores, String[] arrayLetras) {
    MyIO.setCharset("ISO-8859-1");

    int isLineBreak, isTable;
    for (int i = 0; i < pagina.length(); i++) {
      for (int j = 0; j < 21; j++) {
        if (pagina.charAt(i) == arrayLetras[j].charAt(0)) {
          arrayValores[j]++;
          j = arrayLetras.length;
        }
      }
      // A funcao isLineBreak retorna codigo -1 se nao for um <br>, e o numero da
      // posicao de '>' - o numero da posicao de '<', para assim saber quantas casas
      // pular no contador i.
      // IsTable() funciona da mesma maneira
      isLineBreak = isLineBreak(pagina, i);
      isTable = isTable(pagina, i);

      if (isLineBreak != -1) {
        arrayValores[23]++;
        i += isLineBreak;
      } else if (isTable != -1) {
        arrayValores[24]++;
        i += isTable;
      } else if (isConso(pagina.charAt(i))) {
        arrayValores[22]++;
      }
    }
  }

  public static boolean isConso(char entrada) {
    char[] consoantes = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
        'y', 'z' };
    boolean isConso = true;
    int naoConsoante = 0;
    for (int j = 0; j < consoantes.length; j++) {
      // Percore o entrada.charAt(i) por todo array de consoantes. A cada consoante
      // diferente do char, a variavel
      // naoConsoante aumenta em 1. Se seu valor for igual ao do tamanho do array de
      // consoantes, sabemos que a
      // letra nao eh consoante (pois foi diferente de todas).
      if (entrada != consoantes[j]) {
        naoConsoante++;
      }
    }

    if (naoConsoante == consoantes.length) {
      isConso = false;
    }
    return isConso;
  }

  public static int isLineBreak(String entrada, int indexOpenTag) {
    int isLineBreak = -1;
    if (entrada.charAt(indexOpenTag) == '<') {
      for (int i = indexOpenTag; i < entrada.length(); i++) {
        if (entrada.charAt(i) == '>') {
          isLineBreak = i - indexOpenTag;
          for (int j = indexOpenTag + 1; j < i; j++) {
            if (entrada.charAt(j) != ' ' &&
                entrada.charAt(j) != 'b' &&
                entrada.charAt(j) != 'r')

            {
              isLineBreak = -1;
            }

            if (isLineBreak >= 3 &&
                entrada.charAt(j) == 'b' &&
                entrada.charAt(j + 1) != 'r') {
              isLineBreak = -1;
            }
          }
          i = entrada.length();
        }
      }
    }
    return isLineBreak;
  }

  public static int isTable(String entrada, int indexOpenTag) {
    int isTable = -1;
    if (entrada.charAt(indexOpenTag) == '<') {
      for (int i = indexOpenTag; i < entrada.length(); i++) {
        if (entrada.charAt(i) == '>') {
          isTable = i - indexOpenTag;
          for (int j = indexOpenTag + 1; j < i; j++) {
            if ( // CRIAR METODO PRA CHECAR SE EH 'TABLE'
            entrada.charAt(j) != ' ' &&
                entrada.charAt(j) != 't' &&
                entrada.charAt(j) != 'a' &&
                entrada.charAt(j) != 'b' &&
                entrada.charAt(j) != 'l' &&
                entrada.charAt(j) != 'e') {
              isTable = -1;
            }

            if (isTable >= 6 &&
                entrada.charAt(j) == 't' &&
                entrada.charAt(j + 1) != 'a' &&
                entrada.charAt(j + 2) != 'b' &&
                entrada.charAt(j + 3) != 'l' &&
                entrada.charAt(j + 4) != 'e') {
              isTable = -1;
            }
          }
          i = entrada.length();
        }
      }
    }
    return isTable;
  }
}