#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 1000

typedef struct {
char nome[100];
int altura;
double peso;
char corDoCabelo[100];
char corDaPele[100];
char corDosOlhos[100];
char anoNascimento[100];
char genero[100];
char homeworld[100];
} Personagem;

Personagem personagens[MAX];

int cmpfunc(const void* a, const void* b) {
Personagem* p1 = (Personagem*)a;
Personagem* p2 = (Personagem*)b;
return strcmp(p1->nome, p2->nome);
}

int buscaBinaria(char* nome, int inicio, int fim) {
if (inicio > fim) return 0;
int meio = (inicio + fim) / 2;
if (strcmp(personagens[meio].nome, nome) == 0) return 1;
if (strcmp(personagens[meio].nome, nome) > 0) return buscaBinaria(nome, inicio, meio - 1);
return buscaBinaria(nome, meio + 1, fim);
}

int main() {
char entrada[MAX][100];
int numEntrada = 0;
char entrada2[MAX][100];
int numEntrada2 = 0;
// Leitura da entrada padrao
do {
    fgets(entrada[numEntrada], 100, stdin);
    entrada[numEntrada][strlen(entrada[numEntrada]) - 1] = '\0';
} while (!strstr(entrada[numEntrada++], "FIM"));

numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

// Preenchimento do vetor de personagens
for (int i = 0; i < numEntrada; i++) {
    personagens[i].altura = 0;
    personagens[i].peso = 0.0;
    sscanf(entrada[i], "%[^,],%d,%lf,%[^,],%[^,],%[^,],%[^,],%[^,],%[^\n]",
        personagens[i].nome,
        &personagens[i].altura,
        &personagens[i].peso,
        personagens[i].corDoCabelo,
        personagens[i].corDaPele,
        personagens[i].corDosOlhos,
        personagens[i].anoNascimento,
        personagens[i].genero,
        personagens[i].homeworld);
}

// Ordenação do vetor de personagens
qsort(personagens, numEntrada, sizeof(Personagem), cmpfunc);

// Leitura da segunda entrada e busca binária
do {
    fgets(entrada2[numEntrada2], 100, stdin);
    entrada2[numEntrada2][strlen(entrada2[numEntrada2]) - 1] = '\0';
} while (!strstr(entrada2[numEntrada2++], "FIM"));

numEntrada2--; // Desconsiderar ultima linha contendo a palavra FIM

for (int i = 0; i < numEntrada2; i++) {
    if (buscaBinaria(entrada2[i], 0, numEntrada - 1)) {
        printf("SIM\n");
    } else {
        printf("NAO\n");
    }
}

printf("%d\n", numEntrada2);

return 0;
}
