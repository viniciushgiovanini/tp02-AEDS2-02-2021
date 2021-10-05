#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

struct Serie
{
  char *vetorFINAL;
  char FINALNOME[80];
  int tamanhofinal;
  char *containsNome;
  char copiarnome[200];
  char nome[13];

  //---------------FORMATO------------//
  char *vetorFINALFORMATO;
  char FINALFORMATO[80];
  int tamanhofinalF;
  char *containsFormato;
  char copiarformato[500];
  char formato[98];

  //---------------DURACAO---------//
  char *containsDuracao;
  char *copiarduracao;
  char duracao[98];

  //--------------PAIS----------------//
  char *containsPais;
  char *copiarpais;
  char pais[105];

  //--------------IDIOMA---------------//
  char *containsIdioma;
  char *copiaridioma;
  char idioma[106];

  //-------------EMISSORA-------------//
  char *containsEmissora;
  char *copiaremissora;
  char emissora[121];

  //-------------Transmissao-----------//
  char *containsTransmissao;
  char *copiartransmissao;
  char transmissao[111];

  //--------------Temporada-----------//
  char *containsNtemporada;
  char *copiarNtemporada;
  char Ntemp[107];

  //--------------EPISODIO-----------//
  char *containsNepisodio;
  char *copiarNepisodio;
  char Nepi[107];
};

int lerNome(char *ReceberNome, char *FinalNome) //Recebe a String Suja (receberNome, e a String Vazia FinalNome)
{
  struct Serie Slernome;
  bool marcador = false;
  int contador = 0;

  strcpy(Slernome.copiarnome, ReceberNome); //pega a string suja e salva nessa variavel na qual ja estava a string suja porém na funcao diferente

  int tamanhonome = strlen(Slernome.copiarnome);                  //pega quantos caracteres tem na string suja
  char *vetorSalvar = (char *)malloc(tamanhonome * sizeof(char)); //abre o vetor LIMPINHO com a quantidade de caracteres presente na string suja

  for (int i = 0; i < tamanhonome; i++) //comeca a fazer a busca igual em java
  {
    if (Slernome.copiarnome[i] == '<')
    {
      marcador = false;
    }

    if (Slernome.copiarnome[i] == '>')
    {
      marcador = true;
    }

    if (marcador == true && Slernome.copiarnome[i] != '(' && Slernome.copiarnome[i] != ')' && Slernome.copiarnome[i] != '>')
    {
      vetorSalvar[contador] = Slernome.copiarnome[i];
      contador++;
    }

    if (Slernome.copiarnome[i] == '/')
    {
      i = tamanhonome - 1;
    }
  }

  strcpy(FinalNome, vetorSalvar); //salva a string achada na variavel ponteiro que era um vetor limpo na main

  int tamfim = strlen(vetorSalvar); //retorna a quantidade de caracteres que foi impresso no vetorSalvar

  return tamfim; //retorna a quantidade de caracteres presente no vetorSalvar
}

int lerFormato(char *ReceberFormato, char *FinalFormato)
{
  struct Serie Slerformato;
  bool marcador2 = false;
  int contador = 0;

  strcpy(Slerformato.copiarformato, ReceberFormato);

  int tamanhoformato = strlen(Slerformato.copiarformato);
  char *vetorSalvar2 = (char *)malloc(tamanhoformato * sizeof(char));

  for (int i = 0; i < tamanhoformato; i++)
  {
    if (Slerformato.copiarformato[i] == '<')
    {
      marcador2 = false;
    }

    if (Slerformato.copiarformato[i] == '>')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Slerformato.copiarformato[i] != '(' && Slerformato.copiarformato[i] != ')' && Slerformato.copiarformato[i] != '>' && Slerformato.copiarformato[i] != '\n' && Slerformato.copiarformato[i] != '\r')
    {
      vetorSalvar2[contador] = Slerformato.copiarformato[i];
      contador++;
    }

    if (Slerformato.copiarformato[i] == '\n')
    {
      i = tamanhoformato - 1;
    }
  }

  strcpy(FinalFormato, vetorSalvar2);

  int tamfimF = strlen(vetorSalvar2);

  return tamfimF;
}

void Imprimir(char *nome, char *formato)
{
  printf("%s", nome);
  printf(" ");
  printf("%s\n", formato);
}

int main() ////////////////////////////CRIAR FUNCAO PARA PESQUISAR NOME, FORMATO ETC
{
  char entrada[50];
  char linha[1000];

  //scanf("%s", &entrada);
  fgets(entrada, 50, stdin);

  struct Serie Snome;
  struct Serie Sformato;
  struct Serie Sduracao;
  struct Serie Spais;
  struct Serie Sidioma;
  struct Serie Semissora;
  struct Serie Stransmissao;
  struct Serie SNtemp;
  struct Serie SNep;

  while (!(entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M'))
  {

    char url[] = "/mnt/d/PASTAS_AREA_DE_TRABALHO/Faculdade_4_Periodo/AEDS2REMAKE/AEDSPRATICO/tp02/series/";
    int turl = strlen(url) - 1;
    int tentrada = strlen(entrada) - 1;
    char receber[200];

    receber[0] = '\0';

    strcat(receber, url);
    strcat(receber, entrada);
    int total = turl + tentrada;
    receber[total + 1] = '\0';

    FILE *p = fopen(receber, "r");

    //colocar variaveis abaixo em struct
    strcpy(Snome.nome, "firstHeading");
    strcpy(Sformato.formato, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Formato</td>");
    strcpy(Sduracao.duracao, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Duração</td>");
    strcpy(Spais.pais, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">País de origem</td>");
    strcpy(Sidioma.idioma, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Idioma original</td>");
    strcpy(Semissora.emissora, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Emissora de televisão original</td>");
    strcpy(Stransmissao.transmissao, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Transmissão original</td>");
    strcpy(SNtemp.Ntemp, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de temporadas</td>");
    strcpy(SNep.Nepi, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de episódios</td>");

    while (!feof(p))
    {
      fgets(linha, 1000, p);
      //printf("%s", linha);

      Snome.containsNome = strstr(linha, Snome.nome);

      if (Snome.containsNome)
      {
        //printf("String encontrada --> %s", Snome.containsNome);

        strcpy(Snome.copiarnome, Snome.containsNome);                         //Pega a string suja e copiar para copiar nome
        Snome.tamanhofinal = lerNome(Snome.copiarnome, Snome.FINALNOME);      //Manda para a funcao a string suja e uma String Limpa, e retonar quantas casas foram gastas para limpar
        Snome.vetorFINAL = (char *)malloc(Snome.tamanhofinal * sizeof(char)); //Pega um array vazio VETOR FINAL, e aloca a quantidade de casas gastas na funcao
        strcpy(Snome.vetorFINAL, Snome.FINALNOME);                            //Grava o vetor FinalNome no vetor Final na qual contem somente a quantidade de casas que foi gasto.
      }

      Sformato.containsFormato = strstr(linha, Sformato.formato);

      if (Sformato.containsFormato)
      {
        fgets(linha, 1000, p);
        strcpy(Sformato.copiarformato, linha);
        //printf("%s", Sformato.copiarformato);
        Sformato.tamanhofinalF = lerFormato(Sformato.copiarformato, Sformato.FINALFORMATO);
        Sformato.vetorFINALFORMATO = (char *)malloc(Sformato.tamanhofinalF * sizeof(char));
        strcpy(Sformato.vetorFINALFORMATO, Sformato.FINALFORMATO);
      }

      Sduracao.containsDuracao = strstr(linha, Sduracao.duracao);

      if (Sduracao.containsDuracao)
      {
        fgets(linha, 1000, p);
        int tamanhoduracao = strlen(linha);
        Sduracao.copiarduracao = (char *)malloc(tamanhoduracao * sizeof(char));
        strcpy(Sduracao.copiarduracao, linha);
      }

      Spais.containsPais = strstr(linha, Spais.pais);

      if (Spais.containsPais)
      {

        fgets(linha, 1000, p);
        int tamanhopais = strlen(linha);
        Spais.copiarpais = (char *)malloc(tamanhopais * sizeof(char));
        strcpy(Spais.copiarpais, linha);
      }

      Sidioma.containsIdioma = strstr(linha, Sidioma.idioma);

      if (Sidioma.containsIdioma)
      {
        fgets(linha, 1000, p);
        int tamanhoidioma = strlen(linha);
        Sidioma.copiaridioma = (char *)malloc(tamanhoidioma * sizeof(char));
        strcpy(Sidioma.copiaridioma, linha);
      }

      Semissora.containsEmissora = strstr(linha, Semissora.emissora);

      if (Semissora.containsEmissora)
      {
        fgets(linha, 1000, p);
        int tamanhoemissora = strlen(linha);
        Semissora.copiaremissora = (char *)malloc(tamanhoemissora * sizeof(char));
        strcpy(Semissora.copiaremissora, linha);
      }

      Stransmissao.containsTransmissao = strstr(linha, Stransmissao.transmissao);

      if (Stransmissao.containsTransmissao)
      {
        fgets(linha, 1000, p);
        int tamanhotransmissao = strlen(linha);
        Stransmissao.copiartransmissao = (char *)malloc(tamanhotransmissao * sizeof(char));
        strcpy(Stransmissao.copiartransmissao, linha);
      }

      SNtemp.containsNtemporada = strstr(linha, SNtemp.Ntemp);

      if (SNtemp.containsNtemporada)
      {
        fgets(linha, 1000, p);
        int tamanhoNtransmissao = strlen(linha);
        SNtemp.copiarNtemporada = (char *)malloc(tamanhoNtransmissao * sizeof(char));
        strcpy(SNtemp.copiarNtemporada, linha);
      }

      SNep.containsNepisodio = strstr(linha, SNep.Nepi);

      if (SNep.containsNepisodio)
      {
        fgets(linha, 1000, p);
        int tamanhoNep = strlen(linha);
        SNep.copiarNepisodio = (char *)malloc(tamanhoNep * sizeof(char));
        strcpy(SNep.copiarNepisodio, linha);
      }
    }

    Imprimir(Snome.vetorFINAL, Sformato.vetorFINALFORMATO);

    /*
    printf("\nString encontrada --> %s", Snome.copiarnome);
    printf("\nString encontrada --> %s", Sformato.copiarformato);
    printf("\nString encontrada --> %s", Sduracao.copiarduracao);
    printf("\nString encontrada --> %s", Spais.copiarpais);
    printf("\nString encontrada --> %s", Sidioma.copiaridioma);
    printf("\nString encontrada --> %s", Semissora.copiaremissora);
    printf("\nString encontrada --> %s", Stransmissao.copiartransmissao);
    printf("\nString encontrada --> %s", SNtemp.copiarNtemporada);
    printf("\nString encontrada --> %s", SNep.copiarNepisodio);*/

    fgets(entrada, 50, stdin);
  }

  free(Sduracao.copiarduracao);
  free(Spais.copiarpais);
  free(Sidioma.copiaridioma);
  free(Semissora.copiaremissora);
  free(Stransmissao.copiartransmissao);
  free(SNtemp.copiarNtemporada);
  free(SNep.copiarNepisodio);

  free(Snome.vetorFINAL);

  return 0;
}