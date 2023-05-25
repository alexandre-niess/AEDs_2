import java.util.Scanner;
public class VerificacaoDeString {
    
    // Método que verifica se a string é composta somente por vogais
    public static boolean ehVogal(String str) {
        for (char c : str.toCharArray()) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
                c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                return false;
            }
        }
        return true;
    }
    
    // Método que verifica se a string é composta somente por consoantes
    public static boolean ehConsoante(String str) {
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || 
                !Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
    
    // Método que verifica se a string é um número inteiro
    public static boolean ehInteiro(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    // Método que verifica se a string é um número real
    public static boolean ehReal(String str) {
        boolean pontoDecimal = false;
        for (char c : str.toCharArray()) {
            if (c == '.' && !pontoDecimal) {
                pontoDecimal = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            boolean x1 = ehVogal(str);
            boolean x2 = ehConsoante(str);
            boolean x3 = ehInteiro(str);
            boolean x4 = ehReal(str);
            System.out.println((x1 ? "SIM" : "NAO") + " " + (x2 ? "SIM" : "NAO") + " " + 
                               (x3 ? "SIM" : "NAO") + " " + (x4 ? "SIM" : "NAO"));
        }
    }
}
