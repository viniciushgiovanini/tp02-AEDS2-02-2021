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
    char url[] = "/mnt/d/PASTAS_AREA_DE_TRABALHO/Faculdade_4_Periodo/AEDS2REMAKE/AEDSPRATICO/tp02/series/";
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

    /*
    printf("--> %c na posicao 86\n", receber[86]);
    printf("--> %c na posicao 87\n", receber[87]);
    printf("--> %c na posicao 88\n", receber[88]);
    printf("--> %c na posicao 89\n", receber[89]);
    printf("--> %c na posicao 90\n", receber[90]);
    printf("--> %c na posicao 91\n", receber[91]);
    printf("--> %c na posicao 92\n", receber[92]);
    printf("--> %c na posicao 93\n", receber[93]);
    printf("--> %c na posicao 94\n", receber[94]);
    //receber[94] = '\0';
    printf("--> %c na posicao 95\n", receber[95]);
    //receber[95] = '\0';
    printf("--> %c na posicao 96\n", receber[96]);
    //receber[96] = '\0';*/

    printf("TAMANHO URL --> %d\n", tamURL);
    printf("TAMANHO DA ENTRADA --> %d\n", tamENTRADA);
    printf("TAMANHO TOTAL --> %d\n", total);
    printf("%c\n", receber[total]);

    FILE *p = fopen(receber, "r");

    if (p != NULL)
    {
      printf("O arquivo abriu\n");
    }
    else
    {
      printf("O Arquivo não está abrindo\n");
    }

    while (!feof(p))
    {
      fgets(linha, 1000, p);

      //printf("%s", linha);
    }

    //printf("String encontrada --> %s\n", linha);

    fgets(entrada, 503, stdin);
    contador++;
  }

  return 0;
}