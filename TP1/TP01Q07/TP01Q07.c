#include <stdio.h>
#include <ctype.h>

// Função que verifica se a string é composta somente por vogais
int ehVogal(char str[]) {
    int i;
    for (i = 0; str[i] != '\0'; i++) {
        if (str[i] != 'a' && str[i] != 'e' && str[i] != 'i' && str[i] != 'o' && str[i] != 'u' &&
            str[i] != 'A' && str[i] != 'E' && str[i] != 'I' && str[i] != 'O' && str[i] != 'U') {
            return 0;
        }
    }
    return 1;
}

// Função que verifica se a string é composta somente por consoantes
int ehConsoante(char str[]) {
    int i;
    for (i = 0; str[i] != '\0'; i++) {
        if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u' ||
            str[i] == 'A' || str[i] == 'E' || str[i] == 'I' || str[i] == 'O' || str[i] == 'U' || 
            !isalpha(str[i])) {
            return 0;
        }
    }
    return 1;
}

// Função que verifica se a string é um número inteiro
int ehInteiro(char str[]) {
    int i;
    for (i = 0; str[i] != '\0'; i++) {
        if (!isdigit(str[i])) {
            return 0;
        }
    }
    return 1;
}

// Função que verifica se a string é um número real
int ehReal(char str[]) {
    int i;
    int pontoDecimal = 0;
    for (i = 0; str[i] != '\0'; i++) {
        if (str[i] == '.' && !pontoDecimal) {
            pontoDecimal = 1;
        } else if (!isdigit(str[i])) {
            return 0;
        }
    }
    return 1;
}

int main() {
    char str[1000];
    while (fgets(str, 1000, stdin)) {
        int x1 = ehVogal(str);
        int x2 = ehConsoante(str);
        int x3 = ehInteiro(str);
        int x4 = ehReal(str);
        printf("%s %s %s %s\n", (x1 ? "SIM" : "NAO"), (x2 ? "SIM" : "NAO"), (x3 ? "SIM" : "NAO"), (x4 ? "SIM" : "NAO"));
    }
    return 0;
}
