//Aluno: Vinícius Henrique Giovanini
//AULA: AEDS2
//MATRICULA: 692225

//OBS DO PROGRAMA, O MAINNN ESTÁ CORRETO, O QUE PODIA SER MELHORADO É O FOR QUE TIRA O HTML NÃO FAZER O LOOP DO TAMANHO DA STRING SOMENTE DEPOIS DO HTML, MAS ASSIM FICOU BOM POIS EVITA ERRO.
//OUTRO PONTO A MELHORAS É SEMPRE USAR O CALLOC E NUNCA O MALLOC, NA FUNCAO PRINCIPAL FOI USADO MALLOC E NÃO ACONTECEU ERRO, PORÉM NAS FUNCOES O MALLOC IMPRIMIU LIXO, TENTEI CONCERTA USANDO
//MALLOC DO CONTADOR DE CARACTERES DO ELEMENTO QUE FOI ACHADO(DESSA FORMA SEM DEIXAR POSICOES VAZIAS OU COM LIXO), DESSA FORMA O VETOR IA FICAR COM AS POSICOES EXATAS, EM ALGUMAS FUNCOES DEU CERTO,
//PORÉM EM OUTRAS CONTINUARAM IMPRIMIR LIXO,
//DESSA FORMA EU FIZ O MALLOC COM A QUANTIDADE DE CARACTERES PARA FICAR SEGURO E DESSA FORMA PAROU DE IMPRIMIR LIXO

//ATUALIZACAO 99% CERTO, QUANDO FOR UTILIZAR O COMANDO CALLOC É NECESSÁRIO SEMPRE ALOCAR MAIS UMA CASA QUE O TAMANHO DA STRING ORIGINAL, PARA SER ALOCADO O \0, DESSA FORMA FINALIZANDO A STRING,
//O CALLOC ACIMA FUNCIONOU PERFEITAMENTE POIS ELE ABRE TODAS AS CASAS COM \0, ENTÃO LOGICAMENTE NA ULTIMA CASA JA TINHA UM \0

//OBS2: ESSE PROGRAMA NÃO É COMPARADO NO VIM DIFF, COM REDIRECIONAMENTO SO CONSEGUE VER O RESULTADO FINAL ABRINDO COM O BLOCO DE NOTAS O TXT GERADO.

//ERRO DO PROGRAMA: O ERRO PRESENTE NESSE PROGRAMA FOI QUE NO ARQUIVO GERADO POR REDIRECIONAMENTO O TXT CRIADO NÃO LE CARACTERES ESPECIAIS EM UTF8.

#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
//#include <locale.h>

struct Serie //O STRUC é a classe em C, porém so serve para guardar as variaveis, no struct não é feito operações como em java na classe
{
  //-------------NOME-----------------//
  char *vetorFINAL;
  char FINALNOME[80];
  int tamanhofinal;
  char *containsNome;
  char copiarnome22[200];
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
  char copiaremissora[2000];
  char emissora[119];

  //-------------Transmissao-----------//
  char *vetorFINALTRANSMISSAO;
  char FINALTRANSMISSAO[80];
  int tamanhofinalTRANSMISSAO;
  char *containsTransmissao;
  char copiartransmissao[2000];
  char transmissao[111];

  //--------------Temporada-----------//
  char *vetorFINALTEMPORADA;
  char FINALTEMPORADA[80];
  int tamanhofinalTEMPORADA;
  char *containsNtemporada;
  char copiarNtemporada[2000];
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
  int i = 0;
  char *vetorSalvar;
  free(vetorSalvar);
  strcpy(Slernome.copiarnome22, ReceberNome); //pega a string suja e salva nessa variavel na qual ja estava a string suja porém na funcao diferente

  int tamanhonome = strlen(Slernome.copiarnome22); //pega quantos caracteres tem na string suja
  tamanhonome -= 2;
  //vetorSalvar = (char *)malloc(tamanhonome * sizeof(char)); //abre o vetor LIMPINHO com a quantidade de caracteres presente na string suja

  for (i = 0; i < tamanhonome; i++) //comeca a fazer a busca igual em java
  {
    if (Slernome.copiarnome22[i] == '<' || Slernome.copiarnome22[i] == '&')
    {
      marcador = false;
    }

    if (Slernome.copiarnome22[i] == '>')
    {
      marcador = true;
    }

    if (marcador == true && Slernome.copiarnome22[i] != '(' && Slernome.copiarnome22[i] != ')' && Slernome.copiarnome22[i] != '>')
    {
      Slernome.copiarnome22[contador] = Slernome.copiarnome22[i]; // AQUI É DIFERENTE DO Q JAVA, AQUI EU PEGO O VALOR DESEJADO E COLOCO NA PRIMEIRA POSICAO DO MESMO VETOR QUE EU TO PROCURANDO
      contador++;                                                 //E CONTO QUANTAS LETRAS FORAM MANDADAS PARA O INICIO DO VETOR
    }

    if (Slernome.copiarnome22[i] == '/')
    {
      i = tamanhonome - 1;
      //vetorSalvar[i] = '\0';
    }
  }

  int j = 0;
  int Ultimaposicao = contador; //salvei o contador para ultiama posicao, pois se for a serie 24 vai contar 2 valores
  contador += 1;                //adicionei mais um, pois o \0 tem que ir depois do 24, então tem que ser alocado 3 casas 2 para o 24 e uma para o \0
  //ABRO UM NOVO VETOR E DOU UM MALLOC COM A QUANTIDADE DE POSICOES CONTADAS POR CONTADORES
  vetorSalvar = (char *)malloc(contador * sizeof(char));

  //LOGO EM SEGUIDA COM ESSE FOR PASSO AS PRIMEIRAS POSICOES DA STRING SUJA QUE COPIEI O VALOR DESEJADO PARA AS PRIMEIRAS POSICOES E COPIO PARA O VETOR COM MALLOC DAS POSICOES EXATAS
  for (j = 0; j < contador; j++)
  {
    vetorSalvar[j] = Slernome.copiarnome22[j];

    if (j == Ultimaposicao) //j comeca contando em 0 então a ultima posicao vai ser o 2, pois ele conta 0, 1 e 2, então 0 e 1 vao ser ocupados com 2 e 4, e
                            //a posição 2 vai ser ocupado com \0, então ultima posicao ta guardando o valor 2 que sera da ultima posicao, dessa forma incrementando nessa posição
                            //o \0;
    {
      vetorSalvar[j] = '\0';
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
  //vetorSalvar2 = (char *)malloc(tamanhoformato * sizeof(char));

  for (int i = 0; i < tamanhoformato; i++)
  {
    if (Slerformato.copiarformato[i] == '<' || Slerformato.copiarformato[i] == '&')
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
      Slerformato.copiarformato[contador] = Slerformato.copiarformato[i];
      contador++;
    }

    if (Slerformato.copiarformato[i] == '\n')
    {
      i = tamanhoformato - 1;
    }
  }

  int ultimaposi = contador;
  contador += 1;
  vetorSalvar2 = (char *)malloc(contador * sizeof(char));

  for (int j = 0; j < contador; j++)
  {
    vetorSalvar2[j] = Slerformato.copiarformato[j];

    if (j == ultimaposi)
    {
      vetorSalvar2[j] = '\0';
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
  tamanhoduracao -= 2;
  //vetorSalvar3 = (char *)malloc(tamanhoduracao * sizeof(char));

  for (int i = 0; i < tamanhoduracao; i++)
  {
    if (Slerduracao.copiarduracao[i] == '<' || Slerduracao.copiarduracao[i] == '&')
    {
      marcador2 = false;
    }

    if (Slerduracao.copiarduracao[i] == '>')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Slerduracao.copiarduracao[i] != '>' && Slerduracao.copiarduracao[i] != '\r' && Slerduracao.copiarduracao[i] != '\n')
    {
      Slerduracao.copiarduracao[contador] = Slerduracao.copiarduracao[i];
      contador++;
    }

    if (Slerduracao.copiarduracao[i] == '\n')
    {
      i = tamanhoduracao - 1;
    }
  }

  //ESSA FUNCAO EU USEI CALLOC POIS MESMO FAZENDO MALLOC COM POSICAO EXATA ESTAVA IMPRIMINDO LIXO DA MEMORIA
  vetorSalvar3 = (char *)calloc(contador, sizeof(char));

  for (int j = 0; j < contador; j++)
  {
    vetorSalvar3[j] = Slerduracao.copiarduracao[j];
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
  //vetorSalvar4 = (char *)malloc(tamanhopais * sizeof(char));

  for (int i = 0; i < tamanhopais; i++)
  {
    if (Slerpais.copiarpais[i] == '<' || Slerpais.copiarpais[i] == '&')
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
      Slerpais.copiarpais[contador] = Slerpais.copiarpais[i];
      contador++;
    }

    if (Slerpais.copiarpais[i] == '\n')
    {
      i = tamanhopais - 1;
    }
  }

  //EXPLICACAO DO CALLOC FOI FEITA NA FUNCAO DE CIMA
  vetorSalvar4 = (char *)calloc(contador, sizeof(char));

  for (int F = 0; F < contador; F++)
  {
    vetorSalvar4[F] = Slerpais.copiarpais[F];
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
  //vetorSalvar5 = (char *)malloc(tamanhoidioma * sizeof(char));

  for (int i = 0; i < tamanhoidioma; i++)
  {
    if (Sleridioma.copiaridioma[i] == '<' || Sleridioma.copiaridioma[i] == '&')
    {
      marcador2 = false;
    }

    if (Sleridioma.copiaridioma[i] == '>')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Sleridioma.copiaridioma[i] != '>' && Sleridioma.copiaridioma[i] != '\n' && Sleridioma.copiaridioma[i] != '\r')
    {
      Sleridioma.copiaridioma[contador] = Sleridioma.copiaridioma[i];
      contador++;
    }

    if (Sleridioma.copiaridioma[i] == '\n')
    {
      i = tamanhoidioma - 1;
    }
  }

  int ultimaposi = contador;
  contador += 1;
  vetorSalvar5 = (char *)malloc(contador * sizeof(char));

  for (int j = 0; j < contador; j++)
  {
    vetorSalvar5[j] = Sleridioma.copiaridioma[j];

    if (j == ultimaposi)
    {
      vetorSalvar5[j] = '\0';
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
  bool marcador3 = false;
  int contador = 0;
  char *vetorSalvar6;
  free(vetorSalvar6);
  strcpy(SlerEMI.copiaremissora, ReceberEmissora);

  int tamanhoemissora = strlen(SlerEMI.copiaremissora);
  //vetorSalvar6 = (char *)malloc(tamanhoemissora * sizeof(char));

  for (int i = 0; i < tamanhoemissora; i++)
  {
    if (SlerEMI.copiaremissora[i] == '<' || SlerEMI.copiaremissora[i] == '&')
    {
      marcador2 = false;
    }

    if (SlerEMI.copiaremissora[i] == '>')
    {
      marcador2 = true;
    }

    if (marcador2 == true && SlerEMI.copiaremissora[i] != '>' && SlerEMI.copiaremissora[i] != '\n' && SlerEMI.copiaremissora[i] != '\r' && SlerEMI.copiaremissora[i] != '\0')
    {
      SlerEMI.copiaremissora[contador] = SlerEMI.copiaremissora[i];
      contador++;
    }
  }

  int ultimaposi = contador;
  contador += 1;
  vetorSalvar6 = (char *)malloc(contador * sizeof(char));

  for (int j = 0; j < contador; j++)
  {
    vetorSalvar6[j] = SlerEMI.copiaremissora[j];

    if (j == ultimaposi)
    {
      vetorSalvar6[j] = '\0';
    }
  }

  strcpy(FinalEmissora, vetorSalvar6);
  int tamfimEMI = strlen(vetorSalvar6);

  return tamfimEMI;
}

int lerTransmissao(char *ReceberTransmissao, char *FinalTransmissao) //EXPLICAÇÃO DA UTIILIZAÇÃO DO CALLOC
{
  struct Serie Slertransmissao;
  bool marcador2 = false;
  int contador = 0;
  char *vetorSalvar16;
  free(vetorSalvar16);
  //char vetorSalvar16[2500];
  strcpy(Slertransmissao.copiartransmissao, ReceberTransmissao);

  int tamanhotransmissao = strlen(Slertransmissao.copiartransmissao);
  tamanhotransmissao -= 2;
  //vetorSalvar16 = (char *)malloc(50 * sizeof(char));

  for (int i = 0; i < tamanhotransmissao; i++)
  {
    if (Slertransmissao.copiartransmissao[i] == '<' || Slertransmissao.copiartransmissao[i] == '&')
    {
      marcador2 = false;
    }

    if (Slertransmissao.copiartransmissao[i] == '>' || Slertransmissao.copiartransmissao[i] == '(')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Slertransmissao.copiartransmissao[i] != '>' && Slertransmissao.copiartransmissao[i] != '\n' && Slertransmissao.copiartransmissao[i] != '\r')
    {
      Slertransmissao.copiartransmissao[contador] = Slertransmissao.copiartransmissao[i];
      contador++;
    }
  }

  vetorSalvar16 = (char *)calloc(contador, sizeof(char)); //O calloc inicia todas as casas com \0, então a ultima casa sera um \0, dessa forma não encontrando e imprimindo lixo.
                                                          //Por isso usando calloc não é necessario a adição do \0 no final da string.

  for (int j = 0; j < contador; j++)
  {
    vetorSalvar16[j] = Slertransmissao.copiartransmissao[j];
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
  //vetorSalvar7 = (char *)malloc(88 * sizeof(char));

  for (int i = 0; i < tamanhotemporada; i++)
  {
    if (Slertemporada.copiarNtemporada[i] == '<' || Slertemporada.copiarNtemporada[i] == '&' || Slertemporada.copiarNtemporada[i] == '(')
    {
      marcador2 = false;
    }

    if (Slertemporada.copiarNtemporada[i] == '>')
    {
      marcador2 = true;
    }

    if (marcador2 == true && Slertemporada.copiarNtemporada[i] != '>' && Slertemporada.copiarNtemporada[i] != '\n' && Slertemporada.copiarNtemporada[i] != '\r')
    {
      Slertemporada.copiarNtemporada[contador] = Slertemporada.copiarNtemporada[i];
      contador++;
    }
  }

  int ultimaposi = contador;
  contador += 1;
  vetorSalvar7 = (char *)malloc(contador * sizeof(char));

  for (int j = 0; j < contador; j++)
  {
    vetorSalvar7[j] = Slertemporada.copiarNtemporada[j];

    if (j == ultimaposi)
    {
      vetorSalvar7[j] = '\0';
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
  //vetorSalvar8 = (char *)malloc(tamanhoepisodio * sizeof(char));

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

    if (marcador2 == true && Slerepisodio.copiarNepisodio[i] != '>' && Slerepisodio.copiarNepisodio[i] != '\n' && Slerepisodio.copiarNepisodio[i] != '\r' && Slerepisodio.copiarNepisodio[i] != ' ')
    {
      Slerepisodio.copiarNepisodio[contador] = Slerepisodio.copiarNepisodio[i];
      contador++;
    }
  }

  int ultimaposi = contador;
  contador += 1;
  vetorSalvar8 = (char *)malloc(contador * sizeof(char));

  for (int j = 0; j < contador; j++)
  {
    vetorSalvar8[j] = Slerepisodio.copiarNepisodio[j];

    if (j == ultimaposi)
    {
      vetorSalvar8[j] = '\0';
    }
  }

  strcpy(FinalEpisodio, vetorSalvar8);

  int tamfimEpi = strlen(vetorSalvar8);

  return tamfimEpi;
}

//ESSA FUNCAO IMPRIME OS VALORES
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
  char url[] = "/tmp/series/";
  int tamURL = strlen(url); //PEGA O TAMANHO DA STRING DO DIRETORIO QUE ESTÁ ARMAZENADA EM URL
  char linha[2000];

  //scanf("%s", &entrada);
  fgets(entrada, 50, stdin);

  struct Serie Sserie;

  while (!(entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M')) //ESSE WHILE SO PARA QUANDO A STRING DA ENTRADA QUE É O ARQUIVO.HTML FOR ESCRITO FIM
  {

    ///tmp/series/

    int tamENTRADA = strlen(entrada);                   //PEGA O TAMANHO DA ENTRADA
    int total = tamENTRADA + tamURL;                    // SOMA O DIRETORIO COM A ENTRADA QUE É O NOMEDASERIE.HTML
    char *receber = (char *)calloc(1000, sizeof(char)); //CRIA UM VETOR RECEBER COM CALLOC QUE TRANSFORMA O VETOR RECEBER COM 1000 POSICOES E INICIALIZA TODAS AS POSICOES COM \0;
    //char receber[100];
    bool marcador = false;

    strcat(receber, url);             //PEGA A STRING DA URL E JOGA PRA RECEBER
    strcat(receber, entrada);         //PEGA STRING ENTRADA E JOGA NA URL, CRIANDO ASSIM O DIRETORIO QUE VAI SER LIDO PELO FOPEN, PORÉM AQUI TEM UM PORÉM, A STRING TEM UM \N NO FINAL
    int tamreceber = strlen(receber); //PEGA O TAMANHO DA STRING RECEBER, DEPOIS DE CONTATENADA

    for (int i = tamURL; i < tamreceber; i++) //ESSA FOR VAI COMECAR A LER O DIRETORIO CONCATENADO A PARTIR DA ULTIMA POSICAO DO URL, QUE SEMPRE VAI SER A MESMA, E VAI ENTAO "VARRER", A STRING ENTRADA
                                              //QUE É A STRING QUE MUDA DEPOIS QUE FOI LIDO H DEPOIS L DEPOIS M DEPOIS L ELE COLOCA O MARCADOR IGUAL TRUE, E A PARTIR DAI TODA POSICAO VAI RECEBER \0 ATÉ O FINAL
                                              //DA STRING DESSA FORMA ELMINANDO O \N
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

    FILE *p = fopen(receber, "r"); //VAI ABRIR O ARQUIVO

    if (p == NULL) //Se o arquivo for digita errado ou ele não for encontrado no diretorio da esse printf e acaba o programa
    {
      printf("ARQUIVO NÃO ENCONTRADO =( \n");
      return 0;
    }

    //ESSES SAO AS LINHAS ONDE TEM QUE PARAR EM CADA ARQUIVO PARA ENCONTRAR OS ELEMENTOS NECESSARIO
    strcpy(Sserie.nome, "firstHeading");
    strcpy(Sserie.formato, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Formato</td>");
    strcpy(Sserie.duracao, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Duração</td>");
    strcpy(Sserie.pais, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">País de origem</td>");
    strcpy(Sserie.idioma, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Idioma original</td>");
    strcpy(Sserie.emissora, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Emissora de televisão original</td>");
    strcpy(Sserie.transmissao, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Transmissão original</td>");
    strcpy(Sserie.Ntemp, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de temporadas</td>");
    strcpy(Sserie.Nepi, "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de episódios</td>");

    while (!feof(p)) //ESSE WHILE VAI LER ATE FECHAR O ARQUIVO, E VAI LER O PRIMEIRO COM FGETS, QUANDO A STRING PRESENTE EM SSERIE.NOME FOR IGUAL A ENCONTRADA EM LINHA VAI PASSAR PARA CONTAINS NOME
                     //E ASSIM VAI ENTRAR NO IF, VOU COPIAR PARA OUTRA VARIAVEL E VOU MANDAR PARA A FUNCAO A STRING ACHADA MAIS UM VETOR DE STRING VAZIO, DEPOIS QUE A FUNCAO FOR EXECUTADA NO C NAO PRECISA RETORNAR
                     //PONTEIRO POIS ESTÁ MUDANDO OS VALORES NA MEMORIA ENTAO A STRING SSERIE.FINALNOME EX, VAI SER ATUALIZADA COM O VALOR DO ELEMENTO PRONTO, E A FUNCAO TEM UM CONTADOR PARA CONTAR QUANTOS CARACTERES
                     //TEM O ELEMENTO DA FUNCAO RETORNARDA PELA MEMORIA, COM ESSE CONTADOR DE CARACTERES EU CRIO UM VETOR MALLOC EXATAMENTO COM A QUANTIDADE DE CARACTERES PARA NÃO IMPRIMIR LIXO DA MEMORIA, E COPIO COM
                     //STRCPY PARA ESSA FUNCAO ABERTA COM MALLOC
    {
      //setlocale(LC_ALL, "UTF-8");
      fgets(linha, 2000, p);
      //printf("%s", linha);

      Sserie.containsNome = strstr(linha, Sserie.nome);

      if (Sserie.containsNome)
      {
        //printf("String encontrada --> %s", Snome.containsNome);

        strcpy(Sserie.copiarnome22, Sserie.containsNome);                       //Pega a string suja e copiar para copiar nome
        Sserie.tamanhofinal = lerNome(Sserie.copiarnome22, Sserie.FINALNOME);   //Manda para a funcao a string suja e uma String Limpa, e retonar quantas casas foram gastas para limpar
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
        fgets(linha, 1000, p); //ALGUMAS FUNCÕES TEM UM FGETS DENTRO POIS A LINHA DO CONTAINS NÃO CONTÉM O ELEMENTO SOMENTE UMA LINHA DEPOIS ENTÃO ESSE FGETS PULA PARA A LINHA DE BAIXO
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
        fgets(linha, 1500, p);
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

    //DEPOIS QUE TODAS AS FUNCOES FOREM LIDAS E PEGAR O ELEMTENTO ELE IMPRIME COM A FUNCAO IMPRIMIR
    Imprimir(Sserie.vetorFINAL, Sserie.vetorFINALFORMATO, Sserie.vetorFINALDURACAO, Sserie.vetorFINALPAIS,
             Sserie.vetorFINALIDIOMA, Sserie.vetorFINALEMISSORA, Sserie.vetorFINALTRANSMISSAO, Sserie.vetorFINALTEMPORADA, Sserie.vetorFINALEPISODIO);

    fgets(entrada, 50, stdin); //LER NOVAMENTE OUTRO ARQUIVO.HTML
  }

  //AQUI TODOS OS VETORES QUE FORAM ABERTOS COM MALLOC VAO SER DESALOCADOS
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