import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

class Personagem {
	private String nome;
	private int altura;
	private int peso;
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

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
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

        try {
            if (temp.equals("unknown"))
			this.peso = 0;
		else
			this.peso = Integer.parseInt(temp.replace(",", "."));
        } catch (Exception e) {
            this.peso = 72;
        }

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

class TP02Q15 {
    public static void sort(int n, Personagem[] array) {
        //Array para contar o numero de ocorrencias de cada peso
        int maiorPeso = getMaiorPeso(n, array);
        int[] count = new int[maiorPeso + 1];
        Personagem[] ordenado = new Personagem[n];
    
        //Inicializar cada posicao do array de contagem 
        for (int i = 0; i < count.length; count[i] = 0, i++);
    
        //Agora, o count[i] contem o numero de elementos com peso igual a i
        for (int i = 0; i < n; count[array[i].getPeso()]++, i++);
        
        //Agora, o count[i] contem o numero de elementos com peso menor ou igual a i
        for(int i = 1; i < count.length; count[i] += count[i-1], i++);
    
        //Ordenando
        for(int i = n-1; i >= 0; ordenado[count[array[i].getPeso()]-1] = array[i], count[array[i].getPeso()]--, i--);
    
        //Copiando para o array original
        for(int i = 0; i < n; array[i] = ordenado[i], i++);
    }
    
    /**
     * Retorna o maior peso dos personagens no array.
     * @return maior peso
     */
    public static int getMaiorPeso(int n, Personagem[] array) {
        int maiorPeso = array[0].getPeso();
    
        for (int i = 0; i < n; i++) {
            if(maiorPeso < array[i].getPeso()){
                maiorPeso = array[i].getPeso();
            }
        }
        return maiorPeso;	
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
        sort(numEntrada, personagens);
        for(int i = 0; i < numEntrada; i++){
            personagens[i].imprimir();
        }
        sc.close();
    }
}
