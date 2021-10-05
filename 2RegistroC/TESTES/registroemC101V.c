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
  char *vetorFINALDURACAO;
  char FINALDURACAO[80];
  int tamanhofinalD;
  char *containsDuracao;
  char copiarduracao[500];
  char duracao[98];

  //--------------PAIS----------------//
  char *vetorFINALPAIS;
  char FINALPAIS[80];
  int tamanhofinalP;
  char *containsPais;
  char copiarpais[1000];
  char pais[105];

  //--------------IDIOMA---------------//
  char *vetorFINALIDIOMA;
  char FINALIDIOMA[80];
  int tamanhofinalI;
  char *containsIdioma;
  char copiaridioma[500];
  char idioma[106];

  //-------------EMISSORA-------------//
  char TRIM[30];
  char *vetorFINALEMISSORA;
  char FINALEMISSORA[80];
  int tamanhofinalEmi;
  char *containsEmissora;
  char copiaremissora[1000];
  char emissora[119];

  //-------------Transmissao-----------//
  char *vetorFINALTRANSMISSAO;
  char FINALTRANSMISSAO[80];
  int tamanhofinalTRANSMISSAO;
  char *containsTransmissao;
  char copiartransmissao[500];
  char transmissao[111];

  //--------------Temporada-----------//
  char *vetorFINALTEMPORADA;
  char FINALTEMPORADA[80];
  int tamanhofinalTEMPORADA;
  char *containsNtemporada;
  char copiarNtemporada[500];
  char Ntemp[107];

  //--------------EPISODIO-----------//
  char *vetorFINALEPISODIO;
  char FINALEPISODIO[80];
  int tamanhofinalEPISODIO;
  char *containsNepisodio;
  char copiarNepisodio[500];
  char Nepi[107];
};

int lerNome(char *ReceberNome, char *FinalNome) //Recebe a String Suja (receberNome, e a String Vazia FinalNome)
{
  struct Serie Slernome;
  bool marcador = false;
  int contador = 0;
  char *vetorSalvar;
  free(vetorSalvar);

  strcpy(Slernome.copiarnome, ReceberNome); //pega a string suja e salva nessa variavel na qual ja estava a string suja porém na funcao diferente

  int tamanhonome = strlen(Slernome.copiarnome);            //pega quantos caracteres tem na string suja
  vetorSalvar = (char *)malloc(tamanhonome * sizeof(char)); //abre o vetor LIMPINHO com a quantidade de caracteres presente na string suja

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
  char *vetorSalvar2;
  free(vetorSalvar2);
  strcpy(Slerformato.copiarformato, ReceberFormato);

  int tamanhoformato = strlen(Slerformato.copiarformato);
  vetorSalvar2 = (char *)malloc(tamanhoformato * sizeof(char));

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

    if (marcador2 == true && Slerformato.copiarformato[i] != '(' && Slerformato.copiarformato[i] != ')' &&
        Slerformato.copiarformato[i] != '>' && Slerformato.copiarformato[i] != '\n' && Slerformato.copiarformato[i] != '\r')
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

int lerDuracao(char *ReceberDuracao, char *FinalDuracao)
{
  struct Serie Slerduracao;
  bool marcador2 = false;
  int contador = 0;
  char *vetorSalvar3;
  free(vetorSalvar3);
  strcpy(Slerduracao.copiarduracao, ReceberDuracao);

  int tamanhoduracao = strlen(Slerduracao.copiarformato);
  vetorSalvar3 = (char *)malloc(tamanhoduracao * sizeof(char));

  for (int i = 0; i < tamanhoduracao; i++)
  {
    if (Slerduracao.copiarduracao[i] == '<')
    {
      marcador2 = false;
    }

    if (Slerduracao.copiarduracao[i] == '>')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Slerduracao.copiarduracao[i] != '>' && Slerduracao.copiarduracao[i] != '\r' && Slerduracao.copiarduracao[i] != '\n')
    {
      vetorSalvar3[contador] = Slerduracao.copiarduracao[i];
      contador++;
    }

    if (Slerduracao.copiarduracao[i] == '\n')
    {
      i = tamanhoduracao - 1;
    }
  }

  strcpy(FinalDuracao, vetorSalvar3);

  int tamfimD = strlen(vetorSalvar3);

  return tamfimD;
}

int lerPais(char *ReceberPais, char *FinalPais)
{
  struct Serie Slerpais;
  bool marcador2 = false;
  int contador = 0;
  char *vetorSalvar4;
  free(vetorSalvar4);
  strcpy(Slerpais.copiarpais, ReceberPais);

  int tamanhopais = strlen(Slerpais.copiarpais);
  vetorSalvar4 = (char *)malloc(tamanhopais * sizeof(char));

  for (int i = 0; i < tamanhopais; i++)
  {
    if (Slerpais.copiarpais[i] == '<')
    {
      marcador2 = false;
    }

    if (Slerpais.copiarpais[i] == '>')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Slerpais.copiarpais[i] != '>' && Slerpais.copiarpais[i] != '&' && Slerpais.copiarpais[i] != '#' &&
        Slerpais.copiarpais[i] != '1' && Slerpais.copiarpais[i] != '6' && Slerpais.copiarpais[i] != '0' && Slerpais.copiarpais[i] != ';' && Slerpais.copiarpais[i] != '\n' && Slerpais.copiarpais[i] != '\r')
    {
      vetorSalvar4[contador] = Slerpais.copiarpais[i];
      contador++;
    }

    if (Slerpais.copiarpais[i] == '\n')
    {
      i = tamanhopais - 1;
    }
  }

  strcpy(FinalPais, vetorSalvar4);

  int tamfimP = strlen(vetorSalvar4);

  return tamfimP;
}

int lerIdioma(char *ReceberIdioma, char *FinalIdioma)
{
  struct Serie Sleridioma;
  bool marcador2 = false;
  int contador = 0;
  char *vetorSalvar5;
  free(vetorSalvar5);
  strcpy(Sleridioma.copiaridioma, ReceberIdioma);

  int tamanhoidioma = strlen(Sleridioma.copiaridioma);
  vetorSalvar5 = (char *)malloc(tamanhoidioma * sizeof(char));

  for (int i = 0; i < tamanhoidioma; i++)
  {
    if (Sleridioma.copiaridioma[i] == '<')
    {
      marcador2 = false;
    }

    if (Sleridioma.copiaridioma[i] == '>')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Sleridioma.copiaridioma[i] != '>' && Sleridioma.copiaridioma[i] != '\n' && Sleridioma.copiaridioma[i] != '\r')
    {
      vetorSalvar5[contador] = Sleridioma.copiaridioma[i];
      contador++;
    }

    if (Sleridioma.copiaridioma[i] == '\n')
    {
      i = tamanhoidioma - 1;
    }
  }

  strcpy(FinalIdioma, vetorSalvar5);

  int tamfimI = strlen(vetorSalvar5);

  return tamfimI;
}

int lerEmissora(char *ReceberEmissora, char *FinalEmissora)
{
  struct Serie SlerEMI;
  bool marcador2 = false;
  int contador = 0;
  char *vetorSalvar6;
  free(vetorSalvar6);
  strcpy(SlerEMI.copiaremissora, ReceberEmissora);

  int tamanhoemissora = strlen(SlerEMI.copiaremissora);
  vetorSalvar6 = (char *)malloc(tamanhoemissora * sizeof(char));

  for (int i = 0; i < tamanhoemissora; i++)
  {
    if (SlerEMI.copiaremissora[i] == '<')
    {
      marcador2 = false;
    }

    if (SlerEMI.copiaremissora[i] == '>')
    {
      marcador2 = true;
    }

    if (marcador2 == true && SlerEMI.copiaremissora[i] != '>' && SlerEMI.copiaremissora[i] != '\n' && SlerEMI.copiaremissora[i] != '\r' && SlerEMI.copiaremissora[i] != '\0')
    {
      vetorSalvar6[contador] = SlerEMI.copiaremissora[i];
      contador++;
    }

    if (SlerEMI.copiaremissora[i] == '\n')
    {
      i = tamanhoemissora - 1;
    }
  }

    strcpy(FinalEmissora, vetorSalvar6);

  int tamfimEMI = strlen(vetorSalvar6);

  return tamfimEMI;
}

int lerTransmissao(char *ReceberTransmissao, char *FinalTransmissao)
{
  struct Serie Slertransmissao;
  bool marcador2 = false;
  int contador = 0;
  char *vetorSalvar16;
  free(vetorSalvar16);
  strcpy(Slertransmissao.copiartransmissao, ReceberTransmissao);

  int tamanhotransmissao = strlen(Slertransmissao.copiartransmissao);
  vetorSalvar16 = (char *)malloc(tamanhotransmissao * sizeof(char));

  for (int i = 0; i < tamanhotransmissao; i++)
  {
    if (Slertransmissao.copiartransmissao[i] == '<')
    {
      marcador2 = false;
    }

    if (Slertransmissao.copiartransmissao[i] == '>')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Slertransmissao.copiartransmissao[i] != '>' && Slertransmissao.copiartransmissao[i] != '\n' && Slertransmissao.copiartransmissao[i] != '\r')
    {
      vetorSalvar16[contador] = Slertransmissao.copiartransmissao[i];
      contador++;
    }

    if (Slertransmissao.copiartransmissao[i] == '\n')
    {
      i = tamanhotransmissao - 1;
    }
  }

  strcpy(FinalTransmissao, vetorSalvar16);

  int tamfimT = strlen(vetorSalvar16);

  return tamfimT;
}

int lerTemporada(char *ReceberTemporada, char *FinalTemporada)
{
  struct Serie Slertemporada;
  bool marcador2 = false;
  int contador = 0;
  char *vetorSalvar7;
  free(vetorSalvar7);
  strcpy(Slertemporada.copiarNtemporada, ReceberTemporada);

  int tamanhotemporada = strlen(Slertemporada.copiarNtemporada);
  vetorSalvar7 = (char *)malloc(tamanhotemporada * sizeof(char));

  for (int i = 0; i < tamanhotemporada; i++)
  {
    if (Slertemporada.copiarNtemporada[i] == '<' || Slertemporada.copiarNtemporada[i] == '&')
    {
      marcador2 = false;
    }

    if (Slertemporada.copiarNtemporada[i] == '>' || Slertemporada.copiarNtemporada[i] == '(')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Slertemporada.copiarNtemporada[i] != '>' && Slertemporada.copiarNtemporada[i] != '\n' && Slertemporada.copiarNtemporada[i] != '\r')
    {
      vetorSalvar7[contador] = Slertemporada.copiarNtemporada[i];
      contador++;
    }
  }

  strcpy(FinalTemporada, vetorSalvar7);

  int tamfimTepo = strlen(vetorSalvar7);

  return tamfimTepo;
}

int lerEpisodio(char *ReceberEpisodio, char *FinalEpisodio)
{
  struct Serie Slerepisodio;
  bool marcador2 = false;
  int contador = 0;
  char *vetorSalvar8;
  free(vetorSalvar8);
  strcpy(Slerepisodio.copiarNepisodio, ReceberEpisodio);

  int tamanhoepisodio = strlen(Slerepisodio.copiarNepisodio);
  vetorSalvar8 = (char *)malloc(tamanhoepisodio * sizeof(char));

  for (int i = 0; i < 54; i++)
  {
    if (Slerepisodio.copiarNepisodio[i] == '<' || Slerepisodio.copiarNepisodio[i] == '&')
    {
      marcador2 = false;
    }

    if (Slerepisodio.copiarNepisodio[i] == '>' || Slerepisodio.copiarNepisodio[i] == '(')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Slerepisodio.copiarNepisodio[i] != '>' && Slerepisodio.copiarNepisodio[i] != '\n' && Slerepisodio.copiarNepisodio[i] != '\r')
    {
      vetorSalvar8[contador] = Slerepisodio.copiarNepisodio[i];
      contador++;
    }
  }

  strcpy(FinalEpisodio, vetorSalvar8);

  int tamfimEpi = strlen(vetorSalvar8);

  return tamfimEpi;
}

void Imprimir(char *nome, char *formato, char *duracao, char *pais, char *idioma, char *emissora,
              char *transmissao, char *temporada, char *episodio)
{
  printf("%s", nome);
  printf(" ");
  printf("%s", formato);
  printf(" ");
  printf("%s", duracao);
  printf(" ");
  printf("%s", pais);
  printf(" ");
  printf("%s", idioma);
  printf(" ");
  printf("%s", emissora);
  printf(" ");
  printf("%s", transmissao);
  printf(" ");
  printf("%s", temporada);
  printf(" ");
  printf("%s", episodio);
  printf("\n");
}

int main() ////////////////////////////CRIAR FUNCAO PARA PESQUISAR NOME, FORMATO ETC
{
  char entrada[50];
  char linha[1000];

  //scanf("%s", &entrada);
  fgets(entrada, 50, stdin);

  struct Serie Sserie;

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

    FILE *p = fopen(receber, "r");

    //colocar variaveis abaixo em struct
    strcpy(Sserie.nome, "firstHeading");
    strcpy(Sserie.formato, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Formato</td>");
    strcpy(Sserie.duracao, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Duração</td>");
    strcpy(Sserie.pais, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">País de origem</td>");
    strcpy(Sserie.idioma, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Idioma original</td>");
    strcpy(Sserie.emissora, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Emissora de televisão original</td>");
    strcpy(Sserie.transmissao, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Transmissão original</td>");
    strcpy(Sserie.Ntemp, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de temporadas</td>");
    strcpy(Sserie.Nepi, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de episódios</td>");

    while (!feof(p))
    {
      fgets(linha, 1000, p);
      //printf("%s", linha);

      Sserie.containsNome = strstr(linha, Sserie.nome);

      if (Sserie.containsNome)
      {
        //printf("String encontrada --> %s", Snome.containsNome);

        strcpy(Sserie.copiarnome, Sserie.containsNome);                         //Pega a string suja e copiar para copiar nome
        Sserie.tamanhofinal = lerNome(Sserie.copiarnome, Sserie.FINALNOME);     //Manda para a funcao a string suja e uma String Limpa, e retonar quantas casas foram gastas para limpar
        Sserie.vetorFINAL = (char *)malloc(Sserie.tamanhofinal * sizeof(char)); //Pega um array vazio VETOR FINAL, e aloca a quantidade de casas gastas na funcao
        strcpy(Sserie.vetorFINAL, Sserie.FINALNOME);                            //Grava o vetor FinalNome no vetor Final na qual contem somente a quantidade de casas que foi gasto.
      }

      Sserie.containsFormato = strstr(linha, Sserie.formato);

      if (Sserie.containsFormato)
      {
        fgets(linha, 1000, p);
        strcpy(Sserie.copiarformato, linha);
        //printf("%s", Sformato.copiarformato);
        Sserie.tamanhofinalF = lerFormato(Sserie.copiarformato, Sserie.FINALFORMATO);
        Sserie.vetorFINALFORMATO = (char *)malloc(Sserie.tamanhofinalF * sizeof(char));
        strcpy(Sserie.vetorFINALFORMATO, Sserie.FINALFORMATO);
      }

      Sserie.containsDuracao = strstr(linha, Sserie.duracao);

      if (Sserie.containsDuracao)
      {
        fgets(linha, 1000, p);
        strcpy(Sserie.copiarduracao, linha);
        Sserie.tamanhofinalD = lerDuracao(Sserie.copiarduracao, Sserie.FINALDURACAO);
        Sserie.vetorFINALDURACAO = (char *)malloc(Sserie.tamanhofinalD * sizeof(char));
        strcpy(Sserie.vetorFINALDURACAO, Sserie.FINALDURACAO);
      }

      Sserie.containsPais = strstr(linha, Sserie.pais);

      if (Sserie.containsPais)
      {

        fgets(linha, 1000, p);
        strcpy(Sserie.copiarpais, linha);
        Sserie.tamanhofinalP = lerPais(Sserie.copiarpais, Sserie.FINALPAIS);
        Sserie.vetorFINALPAIS = (char *)malloc(Sserie.tamanhofinalP * sizeof(char));
        strcpy(Sserie.vetorFINALPAIS, Sserie.FINALPAIS);
      }

      Sserie.containsIdioma = strstr(linha, Sserie.idioma);

      if (Sserie.containsIdioma)
      {
        fgets(linha, 1000, p);
        strcpy(Sserie.copiaridioma, linha);
        Sserie.tamanhofinalI = lerIdioma(Sserie.copiaridioma, Sserie.FINALIDIOMA);
        Sserie.vetorFINALIDIOMA = (char *)malloc(Sserie.tamanhofinalI * sizeof(char));
        strcpy(Sserie.vetorFINALIDIOMA, Sserie.FINALIDIOMA);
      }

      Sserie.containsEmissora = strstr(linha, Sserie.emissora);

      if (Sserie.containsEmissora)
      {

        fgets(linha, 1000, p);
        strcpy(Sserie.copiaremissora, linha);
        Sserie.tamanhofinalEmi = lerEmissora(Sserie.copiaremissora, Sserie.FINALEMISSORA);
        Sserie.vetorFINALEMISSORA = (char *)malloc(Sserie.tamanhofinalEmi * sizeof(char));
        strcpy(Sserie.vetorFINALEMISSORA, Sserie.FINALEMISSORA);
      }

      Sserie.containsTransmissao = strstr(linha, Sserie.transmissao);

      if (Sserie.containsTransmissao)
      {
        fgets(linha, 1000, p);
        strcpy(Sserie.copiartransmissao, linha);
        Sserie.tamanhofinalTRANSMISSAO = lerTransmissao(Sserie.copiartransmissao, Sserie.FINALTRANSMISSAO);
        Sserie.vetorFINALTRANSMISSAO = (char *)malloc(Sserie.tamanhofinalTRANSMISSAO * sizeof(char));
        strcpy(Sserie.vetorFINALTRANSMISSAO, Sserie.FINALTRANSMISSAO);
      }

      Sserie.containsNtemporada = strstr(linha, Sserie.Ntemp);

      if (Sserie.containsNtemporada)
      {
        fgets(linha, 1000, p);
        strcpy(Sserie.copiarNtemporada, linha);
        Sserie.tamanhofinalTEMPORADA = lerTemporada(Sserie.copiarNtemporada, Sserie.FINALTEMPORADA);
        Sserie.vetorFINALTEMPORADA = (char *)malloc(Sserie.tamanhofinalTEMPORADA * sizeof(char));
        strcpy(Sserie.vetorFINALTEMPORADA, Sserie.FINALTEMPORADA);
      }

      Sserie.containsNepisodio = strstr(linha, Sserie.Nepi);

      if (Sserie.containsNepisodio)
      {
        fgets(linha, 1000, p);
        strcpy(Sserie.copiarNepisodio, linha);
        Sserie.tamanhofinalEPISODIO = lerEpisodio(Sserie.copiarNepisodio, Sserie.FINALEPISODIO);
        Sserie.vetorFINALEPISODIO = (char *)malloc(Sserie.tamanhofinalEPISODIO * sizeof(char));
        strcpy(Sserie.vetorFINALEPISODIO, Sserie.FINALEPISODIO);
      }
    }

    Imprimir(Sserie.vetorFINAL, Sserie.vetorFINALFORMATO, Sserie.vetorFINALDURACAO, Sserie.vetorFINALPAIS,
             Sserie.vetorFINALIDIOMA, Sserie.vetorFINALEMISSORA, Sserie.vetorFINALTRANSMISSAO, Sserie.vetorFINALTEMPORADA, Sserie.vetorFINALEPISODIO);

    fgets(entrada, 50, stdin);
  }

  free(Sserie.vetorFINAL);
  free(Sserie.vetorFINALFORMATO);
  free(Sserie.vetorFINALDURACAO);
  free(Sserie.vetorFINALPAIS);
  free(Sserie.vetorFINALIDIOMA);
  free(Sserie.vetorFINALEMISSORA);
  free(Sserie.vetorFINALTRANSMISSAO);
  free(Sserie.vetorFINALTEMPORADA);
  free(Sserie.vetorFINALEPISODIO);

  return 0;
}