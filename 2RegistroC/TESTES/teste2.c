#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

int main() ////////////////////////////CRIAR FUNCAO PARA PESQUISAR NOME, FORMATO ETC
{
  char entrada[50];
  char linha[1000];
  int contador = 0;

  //scanf("%s", &entrada);
  fgets(entrada, 500, stdin);

  while (!(entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M'))
  {
    ///tmp/series/
    char url[] = "/tmp/series/";
    int tamURL = strlen(url);
    int tamENTRADA = strlen(entrada);
    int total = tamENTRADA + tamURL;
    char *receber = (char *)malloc(total * sizeof(char));
    //char receber[100];
    bool marcador = false;

    strcat(receber, url);
    strcat(receber, entrada);
    int tamreceber = strlen(receber);

    for (int i = tamURL; i < tamreceber; i++)
    {

      if (receber[i] == 'h')
      {
        if (receber[i + 1] == 't')
        {
          if (receber[i + 2] == 'm')
          {
            if (receber[i + 3] == 'l')
            {
              marcador = true;
              i += 4;
            }
          }
        }
      }

      if (marcador == true)
      {
        receber[i] = '\0';
      }
    }

    FILE *p = fopen("/tmp/series/", "r");

    if (p != NULL)
    {
      printf("O arquivo abriu\n");
    }
    else
    {
      printf("O Arquivo não está abrindo\n");
    }

    printf("String encontrada --> %s\n", linha);
    fgets(entrada, 503, stdin);
    contador++;
  }

  return 0;
}