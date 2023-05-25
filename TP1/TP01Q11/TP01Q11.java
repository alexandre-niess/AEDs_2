import java.util.Scanner;

public class Palindromo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String palavra = scanner.nextLine();
      if (palavra.equals("FIM")) {
        break;
      }
      boolean ehPalindromo = verificaPalindromo(palavra, 0, palavra.length() - 1);
      if (ehPalindromo) {
        System.out.println("SIM");
      } else {
        System.out.println("NAO");
      }
    }

    scanner.close();
  }

  public static boolean verificaPalindromo(String palavra, int inicio, int fim) {
    if (inicio >= fim) {
      return true;
    }
    if (!Character.isLetterOrDigit(palavra.charAt(inicio))) {
      return verificaPalindromo(palavra, inicio + 1, fim);
    }
    if (!Character.isLetterOrDigit(palavra.charAt(fim))) {
      return verificaPalindromo(palavra, inicio, fim - 1);
    }
    if (palavra.charAt(inicio) != palavra.charAt(fim)) {
      return false;
    }
    return verificaPalindromo(palavra, inicio + 1, fim - 1);
  }
}