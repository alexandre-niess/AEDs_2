import java.util.*;
public class Ciframento {
    public static String cifrar(String texto) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            
            resultado += (char)((int) texto.charAt(i) + 3 );
        }
        return resultado;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
       String mensagem = " ";
      do {
        mensagem = sc.nextLine();
        String mensagemCifrada = cifrar(mensagem);
        
        System.out.println(mensagemCifrada);
       
       }while (mensagem.compareTo("FIM") != 0);
      sc.close();
    }
}