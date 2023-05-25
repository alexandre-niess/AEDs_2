#include <stdio.h>

int main(void) {
  int n = 0;
  float x = 0, aux = 0;
  scanf("%i", &n);
  FILE *arquivo = fopen("numeros.txt", "w");
  for (int i = 0; i < n; i++) {
    scanf("%f", &x);
    fprintf(arquivo, "%f\n", x);
  }
  fclose(arquivo);

  FILE *arquivo2 = fopen("numeros.txt", "r");
  float numeros[n]; // array para armazenar os números do arquivo
  for (int i = 0; i < n; i++) {
    fscanf(arquivo2, "%f", &numeros[i]);
  }
  fclose(arquivo2);

  // imprimir os números de trás para frente
  for (int i = n - 1; i >= 0; i--) {
    x = numeros[i];
    if (x == (int)x) {
      x = (int)x;
      printf("%.0f\n", x);
    } else {
      printf("%.3f\n", x);
    }
  }
  return 0;
}
