#include <stdbool.h>
#include <stdio.h>
#include <string.h>

bool isPalindromo(char entrada[], int inicio, int fim);

int main() {
  char entrada[1000];
  bool notFim;

  do {
    scanf(" %[^\n]", entrada);
    notFim = strcmp(entrada, "FIM");

    if (notFim) // Se entrada for diferente de FIM, a execucao continua
    {

      if (isPalindromo(entrada, 0, strlen(entrada) - 1)) {
        printf("SIM\n");
      } else {
        printf("NAO\n");
      }
    }
  } while (notFim);

  return 0;
}

/*
 *    Para determinar se eh palindromo, verifica constantemente a letra na
 * posicao inicio com a letra da posicao fim.
 */
bool isPalindromo(char entrada[], int inicio, int fim) {
  if (inicio >= fim) {
    return true;
  }

  if (entrada[inicio] != entrada[fim]) {
    return false;
  }

  return isPalindromo(entrada, inicio + 1, fim - 1);
}
