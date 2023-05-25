import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

class Personagem {
	private String nome;
	private int altura;
	private double peso;
	private String corDoCabelo;
	private String corDaPele;
	private String corDosOlhos;
	private String anoNascimento;
	private String genero;
	private String homeworld;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCorDoCabelo() {
		return corDoCabelo;
	}

	public void setCorDoCabelo(String corDoCabelo) {
		this.corDoCabelo = corDoCabelo;
	}

	public String getCorDaPele() {
		return corDaPele;
	}

	public void setCorDaPele(String corDaPele) {
		this.corDaPele = corDaPele;
	}

	public String getCorDosOlhos() {
		return corDosOlhos;
	}

	public void setCorDosOlhos(String corDosOlhos) {
		this.corDosOlhos = corDosOlhos;
	}

	public String getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(String anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	protected Personagem clone() throws CloneNotSupportedException {
		Personagem novo = new Personagem();
		novo.nome = this.nome;
		novo.altura = this.altura;
		novo.corDoCabelo = this.corDoCabelo;
		novo.corDaPele = this.corDaPele;
		novo.corDosOlhos = this.corDosOlhos;
		novo.anoNascimento = this.anoNascimento;
		novo.genero = this.genero;
		novo.homeworld = this.homeworld;
		return novo;
	}

	public void ler(String nomeArquivo) throws Exception {
		FileReader file = new FileReader(nomeArquivo);
		BufferedReader buffer = new BufferedReader(file);
		String json = "";
		String line = buffer.readLine();
		while (line != null) {
			json += line;
			line = buffer.readLine();
		}

		buffer.close();
		file.close();

		String temp;
		temp = json.substring(json.indexOf("name") + 8);
		temp = temp.substring(0, temp.indexOf("',"));
		this.nome = temp;

		temp = json.substring(json.indexOf("height") + 10);
		temp = temp.substring(0, temp.indexOf("',"));
		if (temp.equals("unknown"))
			this.altura = 0;
		else
			this.altura = Integer.parseInt(temp);

		temp = json.substring(json.indexOf("mass") + 8);
		temp = temp.substring(0, temp.indexOf("',"));
		if (temp.equals("unknown"))
			this.peso = 0;
		else
			this.peso = Double.parseDouble(temp.replace(",", ""));

		temp = json.substring(json.indexOf("hair_color") + 14);
		temp = temp.substring(0, temp.indexOf("',"));
		this.corDoCabelo = temp;

		temp = json.substring(json.indexOf("skin_color") + 14);
		temp = temp.substring(0, temp.indexOf("',"));
		this.corDaPele = temp;

		temp = json.substring(json.indexOf("eye_color") + 13);
		temp = temp.substring(0, temp.indexOf("',"));
		this.corDosOlhos = temp;

		temp = json.substring(json.indexOf("birth_year") + 14);
		temp = temp.substring(0, temp.indexOf("',"));
		this.anoNascimento = temp;

		temp = json.substring(json.indexOf("gender") + 10);
		temp = temp.substring(0, temp.indexOf("',"));
		this.genero = temp;

		temp = json.substring(json.indexOf("homeworld") + 13);
		temp = temp.substring(0, temp.indexOf("',"));
		this.homeworld = temp;
	}

	public void imprimir() {
		System.out.println(toString());
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.##");
		String resp = " ## " + nome + " ## " + altura + " ## ";
		resp += df.format(peso) + " ## " + corDoCabelo + " ## ";
		resp += corDaPele + " ## " + corDosOlhos + " ## ";
		resp += anoNascimento + " ## " + genero + " ## ";
		resp += homeworld + " ## ";
		return resp;
	}

	public void imprimirNome() {
		System.out.println(nome);
	}

}

class TP02Q13 {
    static class ArrayDePersonagens {
        Personagem[] array;
        int n;

        ArrayDePersonagens(Personagem[] array, int n) {
            this.array = array;
            this.n = n;
        }

        public void mostrar(){
            for(int i = 0; i < n; i++){
                array[i].imprimir();
            }
        }
    }

    public static void sort(ArrayDePersonagens a) {
        Personagem[] array = a.array;
        int n = a.n;

        //Alterar o vetor ignorando a posicao zero
        Personagem[] tmp = new Personagem[n+1];
        for(int i = 0; i < n; i++){
            tmp[i+1] = array[i];
        }
        array = tmp;

        //Contrucao do heap
        for(int tamHeap = 2; tamHeap <= n; tamHeap++){
            construir(tamHeap,array);
        }

        //Ordenacao propriamente dita
        int tamHeap = n;
        while(tamHeap > 1){
            swap(1, tamHeap--,array);
            reconstruir(tamHeap, array);
        }

        //Alterar o vetor para voltar a posicao zero
        tmp = array;
        array = new Personagem[n];
        for(int i = 0; i < n; i++){
            array[i] = tmp[i+1];
        }

        a.array = array;
    }


    public static void construir(int tamHeap, Personagem [] array){
        for(int i = tamHeap; i > 1 && array[i].getAltura() > array[i/2].getAltura(); i /= 2){
            swap(i, i/2, array);
        }
    }

    public static void reconstruir(int tamHeap, Personagem [] array){
        int i = 1;
        while(i <= (tamHeap/2)){
            int filho = getMaiorFilho(i, tamHeap, array);
            if(array[i].getAltura() < array[filho].getAltura()){
                swap(i, filho, array);
                i = filho;
            }else{
                i = tamHeap;
            }
        }
    }

    public static int getMaiorFilho(int i, int tamHeap, Personagem [] array){
        int filho;
        if (2*i == tamHeap || array[2*i].getAltura() > array[2*i+1].getAltura()){
            filho = 2*i;
        } else {
            filho = 2*i + 1;
        }
        return filho;
    }

    public static void swap(int i, int j, Personagem [] array){
        Personagem tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static boolean isFim(String str){
        return (str.length() >= 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }
    
    public static void main (String args[]) throws Exception{
        String[] entrada = new String[1000];
        int numEntrada = 0;

        Scanner sc = new Scanner(System.in);
        //Leitura da entrada padrao
        do {
            entrada[numEntrada] = sc.nextLine();
        } while (isFim(entrada[numEntrada++]) == false);

        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
        Personagem[] personagens = new Personagem[numEntrada];

        

        for(int i = 0; i < numEntrada; i++){
            personagens[i] = new Personagem();
            personagens[i].ler(entrada[i]);
        }

        ArrayDePersonagens a = new ArrayDePersonagens(personagens, numEntrada);
        sort(a);
        a.mostrar();
        sc.close();
    }
}
