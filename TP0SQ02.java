
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class TP02Q02 {

    public static void main(String[] args) {
    }
}

class Nba {

    private int id;
    private int altura;
    private int peso;
    private int anoNascimento;
    private String nome, universidade, cidadeNascimento, estadoNascimento;

    public Nba() {
        this.nome = this.nome = this.universidade = this.cidadeNascimento = this.anoNascimento = this.estadoNascimento = null;
        this.id = 0;
        this.altura = 0;
        this.peso = 0;
        this.anoNascimento = 0;

    }

    public Nba(int id, int altura, int peso, int anoNascimento, String nome, String universidade,
            String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.altura = altura;
        this.peso = peso;
        this.anoNascimento = anoNascimento;
        this.nome = nome;
        this.universidade = universidade;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setanoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setuniversidade(String universidade) {
        this.universidade = universidade;
    }

    public void setcidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public void setestadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public String getNome() {
        return this.nome;
    }

    public int getAltura() {
        return this.altura;
    }

    public int getPeso() {
        return this.peso;
    }

    public int getId() {
        return this.id;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }

    public String getUniversidade() {
        return this.universidade;
    }

    public String getCidadeNascimento() {
        return this.cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return this.estadoNascimento;
    }

    public Nba Clone() {

        Nba clonado = new Nba();

        clonado.nome = this.nome;
        clonado.altura = this.altura;
        clonado.peso = this.peso;
        clonado.id = this.id;
        clonado.estadoNascimento = this.estadoNascimento;
        clonado.anoNascimento = this.anoNascimento;
        clonado.cidadeNascimento = this.cidadeNascimento;
        clonado.universidade = this.universidade;

        return clonado;
    }

    public void Imprimir() {
        System.out.print(" ## " + nome + " ## " + altura + " ## ");

        if ((peso % 1) == 0)
            System.out.print((int) peso);
        else
            System.out.printf(Locale.ENGLISH, "%.1f", peso);

        System.out.println(" ## " + corDoCabelo + " ## " + corDaPele + " ## " + corDosOlhos + " ## " + anoNascimento
                + " ## " + genero + " ## " + homeworld + " ## ");
    }

    public void Ler(String ender) {

        try {
            FileReader fr = new FileReader(ender);
            BufferedReader br = new BufferedReader(fr);
            String texto, tid, taltura, tpeso, tanoNascimento;
            String[] linhas;
            texto = br.readLine();
            linhas = texto.split("',");
            
            tid = linhas[0].substring(12, linhas[0].length());
            nome = linhas[1].substring(12, linhas[1].length());
            taltura = linhas[2].substring(12, linhas[2].length());
            tpeso = linhas[3].substring(12, linhas[3].length());
            universidade = linhas[4].substring(12, linhas[4].length());
            tanoNascimento  = linhas[5].substring(12, linhas[5].length());
            cidadeNascimento = linhas[6].substring(12, linhas[6].length());
            estadoNascimento= linhas[7].substring(12, linhas[7].length());

            this.corDoCabelo = linhas[3].substring(16, linhas[3].length());
            this.corDaPele = linhas[4].substring(16, linhas[4].length());
            this.corDosOlhos = linhas[5].substring(15, linhas[5].length());
            this.anoNascimento = linhas[6].substring(16, linhas[6].length());
            this.genero = linhas[7].substring(12, linhas[7].length());
            this.homeworld = linhas[8].substring(15, linhas[8].length());

            if (tPeso.contains(",")) {
                tPeso = tPeso.replace(",", "");
            }

            if (tAlt.equals("unknown"))
                this.altura = 0;
            else
                this.altura = Integer.parseInt(tAlt);

            if (tPeso.equals("unknown"))
                this.peso = 0;
            else
                this.peso = Double.parseDouble(tPeso);

            br.close();
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

}