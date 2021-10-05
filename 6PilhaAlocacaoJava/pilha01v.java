//Aluno: Vinícius Henrique Giovanini
//Matricula: 692225
//Matéria: AEDS2

//ANOTACOES: PROGRAMA DEU 100% DE ACERTO, PERFECT!!!!!!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class SeriePILHA {

  private String nome;
  private String formato;
  private String duracao;
  private String pais;
  private String idioma;
  private String emissora;
  private String transmissao;
  private int ntemp;
  private String receberntemp;
  private int nepisodio;
  private String recebernepisodio;
  public String juntado;

  // NA CLASSE TODAS RECEBEM A STRING TODA SUJA PELO SET NOME E MANDA PRO GETNOME,
  // QUANDO É ACIONADO O BUSCAR NO MAIS, O MÉTODO BUSCAR PEGA A STRING SUJA E
  // COMECA A LIMPAR, E ELE LIMPA SEMPRE ENTRE > < DEIXANDO SOMENTE O CONTÉUDO
  // DENTRO DESSE ELEMENTOS PRESENTE NA STRING, ELE FAZ ESSA "LIMPEZA", COPIANDO
  // OS ELEMENTOS DENTRO DE > < PARA OUTRO ARRAY.

  // ------------------------------NOME------------------------------//

  public String getNome() {
    return this.nome;
  }

  public void setNome(String recebernome) {
    this.nome = recebernome;
  }

  public void buscanome() {

    String buscar = getNome();// MANDOU A STRING SUJA QUE ESTAVA EM GETNOME PARA A VARIAVEL BUSCAR
    char[] vetor = buscar.toCharArray();// SETOU ESSE VETOR COM CADA POSICAO UM ELEMENTO PRESENTE NA STRING SUJA
    char[] vetorreceber = new char[buscar.length()];// SETOU UM VETOR VAZIO COM O TAMANHO DO VETOR SUJO
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {// CADA MÉTODO TEM SUA ESPECIFICAÇÃO NESSA PARTE, O MÉTODO BUSCAR NOME
                                               // BUSCAR O NOME ATÉ ENCONTRAR UMA "/", QUANDO ELE ENCONTRA UMA BARRA ELE
                                               // FINALIZA A BUSCA PARA ECONOMIZAR PROCESSOS, E NESSE MÉTODO É IGNORADO
                                               // PARENTESES.

      if (vetor[k] == '<') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '(' && vetor[k] != ')' && vetor[k] != '>') {// QUANDO É ENCONTRADO UM VALOR
                                                                                      // ENTRE > < ESSE VALOR É COPIADO
                                                                                      // PARA A PRIMEIRA POSICAO DO
                                                                                      // VETORRECEBER, ISSO OCORRE POIS
                                                                                      // SE NÃO FOR FEITO ISSO A STRING
                                                                                      // VAI FICAR NA POSICAO ONDE FOI
                                                                                      // ACHADA QUE GERALMENTE NÃO É A
                                                                                      // PRIMEIRA POSIÇÃO

        vetorreceber[contador] = vetor[k];
        contador++;
      }

      if (vetor[k] == '/') {

        k = buscar.length() - 1;

      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {// ESSE FOR ESTÁ PRESENTE EM TODOS OS MÉTODOS, ELE É ENCARREGADO DE
                                                   // CONTAR QUANTAS POSIÇÕES DO VETOR ESTÁ PRESENTE ALGUM TIPO DE
                                                   // VALOR, POIS COMO FOI
                                                   // FEITO NO ÍNICIO O VETOR RECEBER FOI SETADO COM A QUANTIDADE DE
                                                   // POSICOES PRESENTE NA STRING SUJA, QUANDO ELA FOI LIMPADA E FOI
                                                   // COPIADO PARA ESSE VETOR FICOU SOBRANDO AS POSIÇÕES NÃO COPIADAS, E
                                                   // DESSA FORMA O CONTADORF, CONTA QUANTAS POSIÇÕES ESTÃO COM VALOR NO
                                                   // VETOR RECEBER.

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {// DEPOIS DE CONTAR A QUANTIDADE DE POSICOES SEM ESTAR VAZIA, ESSE FOR VAI
                                         // FAZER EXATAMENTE O LOOP DE QUANTIDADE DE VALORES VALIDOS, JÁ QUE OS VALORES
                                         // DO VETOR RECBER FORAM COPIADOS PARA A POSICAO 1,2,3 ASSIM EM DIANTE, É SO
                                         // COPIAR ESSAS POSIÇÕES INICIAIS PARA OUTRO VETOR, E QUANDO ACABAR OS VALORES
                                         // VALIDOS O FOR VAI ACABAR, FICANDO PRESENTE NO VETOR FINAL SOMENTE VALORES
                                         // VALIDOS.

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);// ESSE COMANDO VAI PEGAR A STRING LIMPA E COM POSIÇÕES OCUPADAS POR
                                                // VALORES VALIDOS E VAI CONVERTER EM STRING
    this.nome = receber;// AQUI VAI RETORNAR PRA VARIAVEL/OBJ NOME QUE VAI PARA O MÉTODO GETNOME

  }

  // ------------------------------FORMATO------------------------------//

  public String getFormato() {
    return this.formato;
  }

  public void setFormato(String receberFormato) {
    this.formato = receberFormato;
  }

  public void buscaformato() {// BUSCA DA MESMA MANEIRA DO QUE NOME BUSCA

    String buscar = getFormato();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '(' && vetor[k] != ')' && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    this.formato = receber;

  }

  // ------------------------------DURAÇÃO------------------------------//

  public String getDuracao() {
    return this.duracao;
  }

  public void setDuracao(String receberDuracao) {
    this.duracao = receberDuracao;
  }

  public void buscaduracao() {// BUSCA DURAÇÃO TEM UMA DIFERENÇA, LA NO FINAL DO MÉTODO

    String buscar = getDuracao();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    receber = receber.trim();// ESSE COMANDO ELEMINA QUALQUER TIPO DE ESPAÇO PRESENTE NO COMEÇO OU NO FINAL
                             // DA STRING E DEPOIS RETORNA PARA A VARIAVEL DURAÇÃO
    this.duracao = receber;
  }

  // ------------------------------Pais de Origem------------------------------//

  public String getPais() {
    return this.pais;
  }

  public void setPais(String receberPais) {
    this.pais = receberPais;
  }

  public void buscapais() {

    String buscar = getPais();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<' || vetor[k] == '&') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>' && vetor[k] != '&' && vetor[k] != '#' & vetor[k] != '1' && vetor[k] != '6'
          && vetor[k] != '0' && vetor[k] != ';') {// AQUI TEM UMA DIFERENÇA NA LINHA PEGADA QUANDO SE SETA PAIS DE
                                                  // ORIGEM DE CARACTERES INDESEJADOS ENTRE > <, DESSA FORMA COLOQUEI NO
                                                  // IF TODOS ELES PARA SEREM IGNORADOS COMO POR EXEMPLO >&#160;<

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    receber = receber.trim();

    this.pais = receber;
  }

  // ------------------------------Idioma------------------------------//
  public String getIdioma() {
    return this.idioma;
  }

  public void setIdioma(String receberIdioma) {
    this.idioma = receberIdioma;
  }

  public void buscaidioma() {

    String buscar = getIdioma();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    receber = receber.trim();
    this.idioma = receber;
  }

  // ------------------------------Emissora_de_TV------------------------------//
  public String getEmissora() {
    return this.emissora;
  }

  public void setEmissora(String receberEmissora) {
    this.emissora = receberEmissora;
  }

  public void buscaemissora() {

    String buscar = getEmissora();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;
    int receberk = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    /*
     * int tamanhostring = getEmissora().length();
     * 
     * if (tamanhostring <= 300) {
     * 
     * receberk = 0;
     * 
     * }
     * 
     * if (tamanhostring >= 300) { receberk = 620; }
     */

    for (int k = receberk; k < buscar.length(); k++) {

      if (vetor[k] == '<') {

        marcador = false;

      }

      if (vetor[k] == '>') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    receber = receber.trim();
    this.emissora = receber;
  }

  // ------------------------------Transmissao_Original------------------------------//
  public String getTrasmissao() {
    return this.transmissao;
  }

  public void setTrasmissao(String receberTrasmissao) {
    this.transmissao = receberTrasmissao;
  }

  public void buscatrasmissao() {

    String buscar = getTrasmissao();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<' || vetor[k] == '&') {

        marcador = false;

      }

      if (vetor[k] == '>' || vetor[k] == '(') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadorf = 0;

    for (int i = 0; i < vetorreceber.length; i++) {

      if (vetorreceber[i] != 0) {
        contadorf++;
      }

    }

    char[] vetorfinal = new char[contadorf];

    for (int f = 0; f < contadorf; f++) {

      vetorfinal[f] = vetorreceber[f];

    }

    String receber = String.valueOf(vetorfinal);
    receber = receber.trim();
    this.transmissao = receber;
  }

  // ------------------------------Número_de_Temporadas------------------------------//

  // ESSE MÉTODO AQUI É DIFERENTE DOS OUTROS, POIS ELE SE TRATADA DE NUMERO
  // INTEIRO PARA SER RETORNADO, DESSA FORMA, ELE RECEBE A STRING SUJA COM
  // SETNTEMPORADAS E SO PODE SER ACESSADA COM GETNTEMPORADAS, DESSA FORMA FOI
  // CRIADO MAIS UM GETNTEMPORADAS COM VALOR INT, O PQ VAI SER EXPLICADO NO FINAL
  // DO MÉTODO

  public String getNtemporadas() {
    return this.receberntemp;
  }

  public void setNtemporadas(String receberNtemporadas) {
    this.receberntemp = receberNtemporadas;
  }

  public int getNtemporadasINTEIRO() {
    return this.ntemp;
  }

  public void buscaNtemporadas() {// DESSA FORMA ELE VAI FAZER A BUSCA

    String buscar = getNtemporadas();// AQUI VAI SER MANDADO A STRING SUJA
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    // String receber = "";
    // receber = buscar.replaceAll("<.*?>", "");
    // System.out.println(buscar);

    for (int k = 0; k < buscar.length(); k++) {

      if (vetor[k] == '<' || vetor[k] == '&') {// TODO VEZ QUE VETOR NA POSICAO K FOR IGUAL A < OU & ELE VAI PARAR DE
                                               // SALVAR O VALOR CONTIDO LOGO APOS

        marcador = false;

      }

      if (vetor[k] == '>' || vetor[k] == '(') {// TODA VEZ QUE O VETOR FOR IGUAL A > OU ( ELE VAI COMECAR A SALVAR OS
                                               // VALORES QUE VEM EM SEGUIDA (NA VDD ELE BOTA O MARCADOR COMO TRUE,
                                               // DIZENDO ASSIM QUE PODE COMECAR A SALVAR)

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {// PARA EVITAR SALVAR O > COLOQUEI QUE SE O CARACTER PRESENTE NO VETOR
                                                // FOR IGUAL AO > ELE N SALVAR, DESSA FORMA ELE SO VAI COMEÇAR A SALVAR
                                                // NO PROXIMO LOOP. E ELE VAI PEGAR O CARACTER APTO A SER SALVO E SALVAR
                                                // NA PRIMEIRA POSIÇÃO DO VETOR RECEBER, E ASSIM POR DIANTE.

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadu = 0;

    // AQUI É DIFERENTE TAMBÉM

    for (int j = 0; j < 2; j++) {

      if (vetorreceber[j] == '0' || vetorreceber[j] == '1' || vetorreceber[j] == '2' || vetorreceber[j] == '3'
          || vetorreceber[j] == '4' || vetorreceber[j] == '5' || vetorreceber[j] == '6' || vetorreceber[j] == '7'
          || vetorreceber[j] == '8' || vetorreceber[j] == '9') {// PARA RETIRAR AS POSICÕES VAZIAS, JA QUE QUEREMOS
                                                                // SOMENTE UM NUMERO, SE O VETOR RECEBER TIVER ALGUEM
                                                                // NUMERO, O CONTADOR VAI SER ACIONADO

        contadu++;

      }

    }

    char[] vetorfinal = new char[contadu];// ABRI O VETOR FINAL QUE VAI TER O TAMANHO IGUAL A QUANTIDADE DE CARACTERES
                                          // PRESENTE NO VETOR RECEBER QUE FOI SETADO NO FOR ACIMA

    for (int v = 0; v < vetorfinal.length; v++) {// ESSE FOR VAI SER EXECUTADO SÓ ATÉ A QUANTIDADE DE CARACTERES
                                                 // PRESENTE NO VETOR RECEBER QUE FOI CONTADO COM CONTADU

      vetorfinal[v] = vetorreceber[v]; // JA QUE OS CARACTERES ESTÃO NA PRIMEIRA POSICAO EM VETOR RECEBER, VAI PASSAR
                                       // PARA VETOR FINAL TAMBÉM NA PRIMEIRA POSICAO PORÉM VETOR RECEBER ESTÁ COM
                                       // POSICÕES DE TODOS OS CARACTERES DA STRING SUJA, E AGORA QUEREMOS UM VETOR
                                       // SOMENTE COM POSIÇÕES DO CARACTERES DESEJADOS

    }

    String receber = String.valueOf(vetorfinal);// CONVERTER A STRING VETOR FINAL PARA STRING RECEBER
    int intconvertido = Integer.valueOf(receber);// AQUI QUE VEM O DIFERENCIAL, ESSE MÉTODO TEM QUE SER RETORNADO INT,
                                                 // DESSA FORMA PEGAMOS O VALOR PRESENTE NA STRING RECEBER QUE É UM
                                                 // CARACTER NUMERICO E CONVERTEMOS PARA INT, MANDANDO PARA
                                                 // INTCONVERTIDO.
    this.ntemp = intconvertido; // LOGO EM SEGUIDA RETORNARMOS O NUMERO INTEIRO PARA O NTEMP, QUE SO PODE SER
                                // ACESSADO COM GETNTEMPO, POIS É UM ATRIBUTO PRIVADO
  }
  // ------------------------------Número_de_Episodios------------------------------//

  // O NÚMERO DE EP USA A LOGICA EXPLICADA ACIMA, POIS TAMBÉM REQUER UM NUMERO
  // INTEIRO PARA SER RETORNADO.

  public String getNepisodio() {
    return this.recebernepisodio;
  }

  public void setNepisodio(String receberNepisodio) {
    this.recebernepisodio = receberNepisodio;
  }

  public int getNepisodioINTEIRO() {
    return this.nepisodio;
  }

  public void buscaNepisodio() {

    String buscar = getNepisodio();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

    for (int k = 0; k < 54; k++) {

      if (vetor[k] == '<' || vetor[k] == '&') {

        marcador = false;

      }

      if (vetor[k] == '>' || vetor[k] == '(') {

        marcador = true;

      }

      if (marcador == true && vetor[k] != '>') {

        vetorreceber[contador] = vetor[k];
        contador++;
      }

    }

    int contadu = 0;

    for (int j = 0; j < 3; j++) {

      if (vetorreceber[j] == '0' || vetorreceber[j] == '1' || vetorreceber[j] == '2' || vetorreceber[j] == '3'
          || vetorreceber[j] == '4' || vetorreceber[j] == '5' || vetorreceber[j] == '6' || vetorreceber[j] == '7'
          || vetorreceber[j] == '8' || vetorreceber[j] == '9') {

        contadu++;

      }

    }

    char[] vetorfinal = new char[contadu];

    for (int v = 0; v < vetorfinal.length; v++) {

      vetorfinal[v] = vetorreceber[v];

    }

    String receber = String.valueOf(vetorfinal);
    int intconvertido = Integer.valueOf(receber);
    this.nepisodio = intconvertido;
  }

  public void juntar() {

    String ntempconvert;
    String nepconvert;

    juntado = getNome();
    juntado += " ";
    juntado += getFormato();
    juntado += " ";
    juntado += getDuracao();
    juntado += " ";
    juntado += getPais();
    juntado += " ";
    juntado += getIdioma();
    juntado += " ";
    juntado += getEmissora();
    juntado += " ";
    juntado += getTrasmissao();
    juntado += " ";
    ntempconvert = Integer.toString(getNtemporadasINTEIRO());
    juntado += ntempconvert;
    juntado += " ";
    nepconvert = Integer.toString(getNepisodioINTEIRO());
    juntado += nepconvert;

  }

}

public class pilha01v {

  public static void imprimirLixo(String[] Lixo) {

    int qtdELEMENTOS = qtdelementos(Lixo);

    for (int i = 0; i < qtdELEMENTOS; i++) {

      if (Lixo[i] != null) {
        System.out.println(Lixo[i]);
      }

    }

  }

  public static void imprimirLista(String[] lista) {// ESSA FUNCAO IMPRIME DO ULTIMO ELEMENTO AO PRIMEIRO DO ARRAY !!!!
                                                    // NA PILHA É COMO SE FOSSE O PRIMEIRO ELEMENTO O QUE ESTÁ SENDO
                                                    // IMPRESSO

    int qtdELEMENTOS = qtdelementos(lista);

    for (int j = qtdELEMENTOS; j >= 0; j--) {

      if (lista[j] != null) {
        System.out.println(lista[j]);
      }

    }

  }

  public static int qtdelementos(String[] lista) {// ESSA FUNCAO FOI FEITA PARA APOIO PARA QUE EU NAO FIQUE CONTANDO A
                                                  // QUANTIDADE DE ELEMENTOS PRESENTE NA LISTA TODA HORA, DESSA FORMA
                                                  // MANTENDO A QTDE DE ELEMENTOS PRESENTE NA LISTA ATUALIZADA SEMPRE
                                                  // QUE EU CHAMAR ESSA FUNCAO

    int qtdELEMENTOS = 0;

    for (int i = 0; i < lista.length; i++) {

      if (lista[i] != null && lista[i] != "\0") {

        qtdELEMENTOS++;

      } else {
        i = lista.length;
      }

    }

    return qtdELEMENTOS;

  }

  public static String[] montarlixo(String[] lista, String[] lixo, int operacao, int posi) {// FUNCAO PARA CRIAR O ARRAY
                                                                                            // LIXO

    char[] letra = new char[500];// ABRE O VETOR QUE VAI PEGAR A ENTRADA2 E TRANSFORMA EM ARRAY DE CARACTERES
                                 // PARA ANALISAR LETRA POR LETRA

    letra = lista[posi].toCharArray();// TRANSFORMA EM ARRAY DE CARACTERES

    String lixorecebidoString = " ";
    int qtdletra = 0;
    boolean flag = false;
    int contador = 0;

    while (flag == false) {// ESSE WHILE ANALISA A STRING PARA PEGAR SOMENTE O NOME, DEPOIS DE TODO NOME DA
                           // STRING DA CLASSE, É SEMPRE PRESENTE OS NOMES SÉRIE WEBSERIE OU SITCON, SE
                           // ALGUNS DESSES NOMES FOR ENCONTRADO ELE PARA A VERIFICACAO E SALVA O NOME DA
                           // SERIE PRESENTE NA STRING

      if ((letra[contador] == 'S' && letra[contador + 1] == 'é' && letra[contador + 2] == 'r'
          && letra[contador + 3] == 'i' && letra[contador + 4] == 'e')
          || (letra[contador] == 'S' && letra[contador + 1] == 'i' && letra[contador + 2] == 't'
              && letra[contador + 3] == 'c' && letra[contador + 4] == 'o' && letra[contador + 5] == 'm')
          || (letra[contador] == 'W' && letra[contador + 1] == 'e' && letra[contador + 2] == 'b'
              && letra[contador + 3] == 's' && letra[contador + 4] == 'é' && letra[contador + 5] == 'r'
              && letra[contador + 6] == 'i' && letra[contador + 7] == 'e')) {

        flag = true;

      } else {
        qtdletra++;// CONTA A QUANTIDADE DE LETRAS QUE ESTA PRESENTE NO NOME
      }
      contador++;
    }

    qtdletra -= 1;// TIRA O ESPACO PRESENTE ENTRE O NOME E O FORMATO DA SERIE (24 SÉRIE)
    char letraexata[] = new char[qtdletra];// ABRE UM VETOR COM A QUANTIDADE EXATA DE LETRA PRESENTE NO NOME DA SERIE

    for (int k = 0; k < qtdletra; k++) {

      letraexata[k] = letra[k];// SALVA SOMENTE O NOME DA SERIE EM UM VETOR COM TAMANHO EXATO, SEM ESPACO VAZIO

    }

    lixorecebidoString = String.valueOf(letraexata);// TRANSFORMA ARRAY DE CARACTERES EM STRING

    String lixostr = "(R) " + lixorecebidoString;// ACRESCENTA (R) NA STRING COM NOME PRESENTE

    int qtdELEMENTOS = qtdelementos(lixo);// PEGA A QUANTIDADE DE ELEMENTOS PRESENTE NO ARRAY LIXO, CASO JA TENHA
                                          // REMOVIDO OUTRO ELEMENTO

    lixo[qtdELEMENTOS] = lixostr;// COPIA O (R NOME) PARA A ULTIMA POSICAO LIBERADA DO ARRAY LIXO

    return lixo;// RETORNA ARRAY LIXO ATUALIZADO

  }

  public static String[] empilharPilha(String entrada2, String[] lista) {// ESSA FUNCAO PEGA A QUANTIDADE DE ELEMENTOS
                                                                         // PRESENTE NA PILHA, E INSERE NA ULTIMA
                                                                         // POSICAO O ELEMENTO DESEJADO, E RETONA A
                                                                         // PILHA ATUALIZADA

    int qtdELEMENTOS = qtdelementos(lista);

    lista[qtdELEMENTOS] = entrada2;

    return lista;

  }

  public static String[] desempilharPilha(String[] lista) {// FUNCAO PARA FAZER REMOCAO NA PILHA

    int qtdELEMENTOS = qtdelementos(lista);// PEGA A QUANTIDADE DE ELEMENTOS

    lista[qtdELEMENTOS - 1] = null;// JA QUE ARRAY COMECA EM 0, TEM QUE TIRAR UM DA QTD DE ELEMENTOS, REMOVENDO O
                                   // ULTIMO ELEMENTO PRESENTE NA PILHA

    return lista;

  }

  public static void main(String[] args) {

    String entrada;
    String entrada2;
    int operacao = 0;
    int entradanumerica2 = 0;
    int contadorentradanumerica2 = 0;
    String[] lista = new String[50];
    String[] lixo = new String[20];
    int tamanhoentrada2 = 0;
    int contadorarraylist = 0;
    entrada = MyIO.readLine();

    SeriePILHA nt = new SeriePILHA();
    while (!(entrada.equals("FIM"))) {

      try {

        // MEU DIRETORIO
        // "/mnt/d/PASTAS_AREA_DE_TRABALHO/Faculdade_4_Periodo/AEDS2REMAKE/AEDSPRATICO/tp02/series/"

        BufferedReader in = new BufferedReader(new FileReader("/tmp/series/" + entrada));

        String str;
        while ((str = in.readLine()) != null) {

          if (str.contains("firstHeading")) {

            nt.setNome(str);
            nt.buscanome();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Formato</td>")) {// BUSCAR
                                                                                                                     // O
                                                                                                                     // FORMATO
            str = in.readLine();
            nt.setFormato(str);
            nt.buscaformato();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Duração</td>")) {// BUSCAR
                                                                                                                     // A
                                                                                                                     // DURAÇÃO

            str = in.readLine();
            nt.setDuracao(str);
            nt.buscaduracao();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">País de origem</td>")) {// BUSCAR
                                                                                                                            // O
                                                                                                                            // PAIS
                                                                                                                            // DE
                                                                                                                            // ORIGEM
            str = in.readLine();
            nt.setPais(str);
            nt.buscapais();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Idioma original</td>")) {// BUSCAR
                                                                                                                             // O
                                                                                                                             // IDIOMA

            str = in.readLine();
            nt.setIdioma(str);
            nt.buscaidioma();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Emissora de televisão original</td>")) {// BUSCAR
                                                                                                                                            // A
                                                                                                                                            // EMISSORA
            str = in.readLine();
            nt.setEmissora(str);
            nt.buscaemissora();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Transmissão original</td>")) {// BUSCAR
                                                                                                                                  // A
                                                                                                                                  // TRANSMISSAO
            str = in.readLine();
            nt.setTrasmissao(str);
            nt.buscatrasmissao();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de temporadas</td>")) {// BUSCAR
                                                                                                                               // O
                                                                                                                               // NUMERO
                                                                                                                               // DE
                                                                                                                               // TEMPORADAS
            str = in.readLine();
            nt.setNtemporadas(str);
            nt.buscaNtemporadas();

          }

          if (str.contains(
              "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de episódios</td>")) {// BUSCAR
                                                                                                                              // O
                                                                                                                              // NUMERO
                                                                                                                              // DE
                                                                                                                              // EPISODIOS
            str = in.readLine();
            nt.setNepisodio(str);
            nt.buscaNepisodio();

          }

        }
        in.close();

      } catch (IOException e) { // CASO NAO ENCONTRE O ARQUIVO RETORNA O ERRO
        System.out.println("ERROR IOEXCEPTION");
      }

      nt.juntar(); // Esse comando pega a string montada pela classe Serie, e pega todos os
                   // elementos e concatena em uma só string
      lista[contadorarraylist] = nt.juntado; // pega essa string e manda para a posicao da lista
      contadorarraylist++;// soma + 1 na posicao da lista
      // System.out.println(nt.juntado);

      entrada = MyIO.readLine();

    }

    // QUANDO TERMINAR DE ADICIONAR ELEMENTOS NA LISTA VAI COMEÇAR A PESQUISA
    // -------------------------------SEGUNDA PARTE-------------------------//

    entradanumerica2 = MyIO.readInt();// recebe quantidade de oepracoes que vai fazer

    while (contadorentradanumerica2 < entradanumerica2) {

      operacao = 0;// seta a operacao que vai fazer para 0
      entrada2 = MyIO.readLine();// recebe operacao mais entrada

      if (entrada2.contains("I")) {// SE ENCONTRAR O I NA STRING CONSISTEM EM INSERCAO DESSA FORMA TRANSFORMA
                                   // OPERACAO EM 1
        operacao = 1;
      }

      if (entrada2.contains("R")) {// MESMA COISA POREM COM REMOCAO
        operacao = 2;
      }

      if (operacao == 1) {// ESSE IF TRATA A STRING, POIS NA INSERCAO A MESMA STRING CONTEM 2 INFORMACOES,
                          // A OPERACAO E SE FOR INSERCAO O QUE VAI SER INSERIDO, DESSA FORMA (I
                          // ARROW.HTML), DESSA MANEIRA PRA LER A SERIE NA BUSCA2 É NECESSARIO REMOVER O
                          // (I ), FICANDO SÓ O NOME DA SERIE PRA SER PESQUISADA NO DIRETORIO, ESSE IF FAZ
                          // ISSO
        tamanhoentrada2 = entrada2.length();
        char letra2[] = new char[tamanhoentrada2];
        letra2 = entrada2.toCharArray();
        letra2[0] = '\0';
        letra2[1] = '\0';

        entrada2 = String.valueOf(letra2);
        entrada2 = entrada2.trim();
      }

      if (operacao == 1) {// SO VAI FAZER ESSA BUSCA NESSAS SEGUINTES OPERACOES

        try {// AQUI FAZ A SEGUNDA BUSCA, PARA FAZER A INSERCAO DO ELEMENTO DESEJADO, AQUI É
             // A COPIA DA CLASSE DNV, AQUI ELE ACESSA NOVAMENTE A CLASSE JAVA PARA FAZER A
             // BUSCA DO ELEMENTO DESEJADO

          // MEU DIRETORIO
          // "/mnt/d/PASTAS_AREA_DE_TRABALHO/Faculdade_4_Periodo/AEDS2REMAKE/AEDSPRATICO/tp02/series/"

          BufferedReader in2 = new BufferedReader(new FileReader("/tmp/series/" + entrada2));

          String str2;
          while ((str2 = in2.readLine()) != null) {

            if (str2.contains("firstHeading")) {

              nt.setNome(str2);
              nt.buscanome();

            }

            if (str2.contains(
                "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Formato</td>")) {// BUSCAR
                                                                                                                       // O
                                                                                                                       // FORMATO
              str2 = in2.readLine();
              nt.setFormato(str2);
              nt.buscaformato();

            }

            if (str2.contains(
                "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Duração</td>")) {// BUSCAR
                                                                                                                       // A
                                                                                                                       // DURAÇÃO

              str2 = in2.readLine();
              nt.setDuracao(str2);
              nt.buscaduracao();

            }

            if (str2.contains(
                "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">País de origem</td>")) {// BUSCAR
                                                                                                                              // O
                                                                                                                              // PAIS
                                                                                                                              // DE
                                                                                                                              // ORIGEM
              str2 = in2.readLine();
              nt.setPais(str2);
              nt.buscapais();

            }

            if (str2.contains(
                "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Idioma original</td>")) {// BUSCAR
                                                                                                                               // O
                                                                                                                               // IDIOMA

              str2 = in2.readLine();
              nt.setIdioma(str2);
              nt.buscaidioma();

            }

            if (str2.contains(
                "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Emissora de televisão original</td>")) {// BUSCAR
                                                                                                                                              // A
                                                                                                                                              // EMISSORA
              str2 = in2.readLine();
              nt.setEmissora(str2);
              nt.buscaemissora();

            }

            if (str2.contains(
                "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Transmissão original</td>")) {// BUSCAR
                                                                                                                                    // A
                                                                                                                                    // TRANSMISSAO
              str2 = in2.readLine();
              nt.setTrasmissao(str2);
              nt.buscatrasmissao();

            }

            if (str2.contains(
                "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de temporadas</td>")) {// BUSCAR
                                                                                                                                 // O
                                                                                                                                 // NUMERO
                                                                                                                                 // DE
                                                                                                                                 // TEMPORADAS
              str2 = in2.readLine();
              nt.setNtemporadas(str2);
              nt.buscaNtemporadas();

            }

            if (str2.contains(
                "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">N.º de episódios</td>")) {// BUSCAR
                                                                                                                                // O
                                                                                                                                // NUMERO
                                                                                                                                // DE
                                                                                                                                // EPISODIOS
              str2 = in2.readLine();
              nt.setNepisodio(str2);
              nt.buscaNepisodio();

            }

          }
          in2.close();

        } catch (IOException e) { // CASO NAO ENCONTRE O ARQUIVO RETORNA O ERRO
          System.out.println("ERROR IOEXCEPTION PESQUISA 2");
        }

        nt.juntar();// MANDA PARA A FUNCAO DE JUNTAR OS ELEMENTOS DA CLASSE
        entrada2 = nt.juntado;// ATRIBUI A STRING ENTRADA2 OS ELEMENTOS CONCATENADOS
      }

      if (operacao < 0 || operacao > 2) {
        System.out.println("OPERAÇÃO NÃO VALIDA");
      }

      if (operacao == 1) {// SE A OPERACAO FOR INSERCAO VAI DAR TRUE NESSE IF

        lista = empilharPilha(entrada2, lista);// MANDA A ENTRADA E A LISTA, E RETORNA A LISTA ATUALIZADA

      }

      if (operacao == 2) {// QUANDO A OPERACAO É 2 TEM QUE MONTAR O ARRAY DE LIXO REMOVIDO, DESSA FORMA
                          // QTDELEMENTOS PEGA A QUANTIDADE DE ELEMENTOS - 1, QUE CONSISTE ONDE O ULTIMO
                          // ELEMENTO INSERIDO VAI SE ENCONTRAR
        int qtdELEMENTOS = qtdelementos(lista) - 1;
        lixo = montarlixo(lista, lixo, operacao, qtdELEMENTOS);// MANDA PARA A FUNCAO LIXO, O ARRAY LISTA, O ARRAY LIXO,
                                                               // A OPERACAO(NAO IMPORTA NESSE PROGRAMA DE PILHA SO NA
                                                               // LISTA), E A QTDELEMENTOS PRESENTE NA LISTA
        lista = desempilharPilha(lista);// PEGA A PILHA E MANDA PARA FUNCAO E RETORNA A PILHA ATUALIZADA

      }

      contadorentradanumerica2++;

      // System.out.println(operacao);

    }

    imprimirLixo(lixo);// IMPRIME O LIXO NORMALMENTE
    imprimirLista(lista);// MANDA PARA IMPRIMIR (COMENTARIOS NA FUNCAO)

  }

}