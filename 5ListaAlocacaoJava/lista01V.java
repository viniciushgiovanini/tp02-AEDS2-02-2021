//Aluno: Vinícius Henrique Giovanini
//Matricula: 692225
//Matéria: AEDS2

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Serielista {

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

public class lista01V {

  public static void imprimirLista(String[] lista) {

    int qtdELEMENTOS = 0;

    for (int i = 0; i < lista.length; i++) {

      if (lista[i] != null) {
        qtdELEMENTOS++;
      } else {
        i = lista.length;
      }

    }

    for (int j = 0; j < qtdELEMENTOS; j++) {

      System.out.println(lista[j]);

    }

  }

  public static String[] inserirInicio(String entrada, String[] lista) {

    int qtdELEMENTOS = 0;

    for (int i = 0; i < lista.length; i++) {

      if (lista[i] != null) {

        qtdELEMENTOS++;

      } else {
        i = lista.length;
      }

    }

    for (int j = qtdELEMENTOS - 1; j >= 0; j--) {

      lista[j + 1] = lista[j];

    }

    lista[0] = entrada;

    return lista;

  }

  public static String[] inserirFim(String entrada, String[] lista) {

    int qtdELEMENTOS = 0;

    for (int i = 0; i < lista.length; i++) {

      if (lista[i] != null) {

        qtdELEMENTOS++;

      } else {
        i = lista.length;
      }

    }

    lista[qtdELEMENTOS] = entrada;

    return lista;

  }

  public static String[] inserirPosi(String entrada, String[] lista, int posi) {

    int qtdELEMENTOS = 0;

    for (int i = 0; i < lista.length; i++) {

      if (lista[i] != null) {
        qtdELEMENTOS++;
      } else {
        i = lista.length;
      }

    }

    int qtdELEMENTOSOF = qtdELEMENTOS - 1;

    for (int j = qtdELEMENTOSOF; j >= posi; j--) {

      lista[j + 1] = lista[j];

    }

    lista[posi] = entrada;

    return lista;

  }

  public static String[] removerInicio(String[] lista) {

    int qtdELEMENTOS = 0;
    int qtdreduzida = 0;

    for (int i = 0; i < lista.length; i++) {

      if (lista[i] != null) {

        qtdELEMENTOS++;

      } else {
        i = lista.length;
      }

    }

    qtdreduzida = qtdELEMENTOS - 1;

    for (int j = 0; j < qtdELEMENTOS; j++) {

      if (j == 0) {

        lista[0] = "\0";
      }

      if (j < qtdreduzida) {
        lista[j] = lista[j + 1];
      }

    }

    lista[qtdELEMENTOS - 1] = null;

    return lista;

  }

  public static String[] removerFinal(String[] lista) {

    int qtdELEMENTOS = 0;

    for (int i = 0; i < lista.length; i++) {

      if (lista[i] != null) {

        qtdELEMENTOS++;

      } else {
        i = lista.length;
      }

    }

    lista[qtdELEMENTOS - 1] = null;

    return lista;

  }

  public static void main(String[] args) {

    String entrada;
    String entrada2;
    int operacao = 0;
    int entradanumerica2 = 0;
    int contadorentradanumerica2 = 0;
    String[] lista = new String[50];
    int fullconvert = 0;
    int tamanhoentrada2 = 0;
    int contadorarraylist = 0;
    entrada = MyIO.readLine();

    Serielista nt = new Serielista();
    while (!(entrada.equals("FIM"))) {

      try {

        // MEU DIRETORIO
        // "/mnt/d/PASTAS_AREA_DE_TRABALHO/Faculdade_4_Periodo/AEDS2REMAKE/AEDSPRATICO/tp02/series/"

        BufferedReader in = new BufferedReader(new FileReader(
            "/mnt/d/PASTAS_AREA_DE_TRABALHO/Faculdade_4_Periodo/AEDS2REMAKE/AEDSPRATICO/tp02/series/" + entrada));

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

      nt.juntar();
      lista[contadorarraylist] = nt.juntado;
      contadorarraylist++;
      // System.out.println(nt.juntado);

      entrada = MyIO.readLine();

    }

    // -------------------------------SEGUNDA PARTE-------------------------//

    entradanumerica2 = MyIO.readInt();// recebe quantidade de oepracoes que vai fazer
    entrada2 = MyIO.readLine();// recebe operacao mais entrada

    // se a string da operacao + entrada tiver algumas dessas entrada muda a
    // variavel operacao
    if (entrada2.contains("II")) {
      operacao = 1;
    }

    if (entrada2.contains("I*")) {
      operacao = 2;
    }

    if (entrada2.contains("IF")) {
      operacao = 3;
    }

    if (entrada2.contains("RI")) {
      operacao = 4;
    }

    if (entrada2.contains("R*")) {
      operacao = 5;
    }

    if (entrada2.contains("RF")) {
      operacao = 6;
    }

    // se a variavel nao for mudada vai dar erro no programa
    if (operacao == 0) {

      System.out.println("OPERACAO NÃO VALIDA");

    }

    if (operacao == 1 || operacao == 3) {// SO VAI FAZER ESSE TRATAMENTO NESSAS SEGUINTE OPERACOES
      // essa parte agora vai tratar para que a entrada possa ser buscada no arquivo,
      // dessa forma tem que ser removido a operacao da string entrada2
      tamanhoentrada2 = entrada2.length();// pega o tamanho da entrada + operacao
      char letra[] = new char[tamanhoentrada2];// abre um vetor com a quantidade de letras presente no array
      letra = entrada2.toCharArray();// transforma a string em array de caracteres
      // A operacao sempre vai estar nas 3 primeiras casas então eu limpo elas
      letra[0] = '\0';
      letra[1] = '\0';
      letra[2] = '\0';

      entrada2 = String.valueOf(letra);// converte o char de array para string
      entrada2 = entrada2.trim();// As 3 primeiras posicoes ficaram vazias, dessa forma usei trim para tirar os
                                 // espaços presentes nas posições
    }

    if (operacao == 2) {

      tamanhoentrada2 = entrada2.length();
      char letra3[] = new char[tamanhoentrada2];
      String inteiroCONVERT;
      letra3 = entrada2.toCharArray();
      boolean marcador = false;

      if (letra3[4] == '0' || letra3[4] == '1' || letra3[4] == '2' || letra3[4] == '3' || letra3[4] == '4'
          || letra3[4] == '4' || letra3[4] == '6' || letra3[4] == '7' || letra3[4] == '8' || letra3[4] == '9') {

        int qtd = 0;
        inteiroCONVERT = Character.toString(letra3[3]);
        inteiroCONVERT += Character.toString(letra3[4]);

        fullconvert = Integer.parseInt(inteiroCONVERT);
        marcador = true;

        qtd = entrada2.length() - 1;
        qtd -= 5;

        char letraentrada[] = new char[qtd];
        int contletra = 6;
        for (int i = 0; i < qtd; i++) {

          letraentrada[i] = letra3[contletra++];

        }

        entrada2 = String.valueOf(letraentrada);

      }

      if (marcador == false
          && (letra3[3] == '0' || letra3[3] == '1' || letra3[3] == '2' || letra3[3] == '3' || letra3[3] == '3'
              || letra3[3] == '3' || letra3[3] == '6' || letra3[3] == '7' || letra3[3] == '8' || letra3[3] == '9')) {

        inteiroCONVERT = Character.toString(letra3[3]);
        fullconvert = Integer.parseInt(inteiroCONVERT);

        int qtd = entrada2.length() - 1;
        qtd -= 4;

        char letraentrada2[] = new char[qtd];
        int contletra2 = 5;

        for (int i = 0; i < qtd; i++) {

          letraentrada2[i] = letra3[contletra2++];

        }

        entrada2 = String.valueOf(letraentrada2);

      }

    }

    while (contadorentradanumerica2 < entradanumerica2) {

      if (operacao == 1 || operacao == 3 || operacao == 2) {// SO VAI FAZER ESSA BUSCA NESSAS SEGUINTES OPERACOES

        try {// AQUI FAZ A SEGUNDA BUSCA, PARA

          // MEU DIRETORIO
          // "/mnt/d/PASTAS_AREA_DE_TRABALHO/Faculdade_4_Periodo/AEDS2REMAKE/AEDSPRATICO/tp02/series/"

          BufferedReader in2 = new BufferedReader(new FileReader(
              "/mnt/d/PASTAS_AREA_DE_TRABALHO/Faculdade_4_Periodo/AEDS2REMAKE/AEDSPRATICO/tp02/series/" + entrada2));

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

        nt.juntar();
        entrada2 = nt.juntado;
      }

      if (operacao <= 0 || operacao >= 7) {
        System.out.println("OPERAÇÃO NÃO VALIDA");
      }

      if (operacao == 1) {

        lista = inserirInicio(entrada2, lista);

      }

      if (operacao == 3) {

        lista = inserirFim(entrada2, lista);

      }

      if (operacao == 4) {
        lista = removerInicio(lista);
      }

      if (operacao == 6) {

        lista = removerFinal(lista);

      }

      if (operacao == 2) {
        lista = inserirPosi(entrada2, lista, fullconvert);
      }

      contadorentradanumerica2++;

      // System.out.println(operacao);

      if (contadorentradanumerica2 < entradanumerica2) {
        operacao = 0;
        entrada2 = MyIO.readLine();

        if (entrada2.contains("II")) {
          operacao = 1;
        }

        if (entrada2.contains("I*")) {
          operacao = 2;
        }

        if (entrada2.contains("IF")) {
          operacao = 3;
        }

        if (entrada2.contains("RI")) {
          operacao = 4;
        }

        if (entrada2.contains("R*")) {
          operacao = 5;
        }

        if (entrada2.contains("RF")) {
          operacao = 6;
        }

        if (operacao == 1 || operacao == 3) {
          tamanhoentrada2 = entrada2.length();
          char letra2[] = new char[tamanhoentrada2];
          letra2 = entrada2.toCharArray();
          letra2[0] = '\0';
          letra2[1] = '\0';
          letra2[2] = '\0';

          entrada2 = String.valueOf(letra2);
          entrada2 = entrada2.trim();
        }

        if (operacao == 2) {

          tamanhoentrada2 = entrada2.length();
          char letra33[] = new char[tamanhoentrada2];
          String inteiroCONVERT;
          letra33 = entrada2.toCharArray();
          boolean marcador = false;

          if (letra33[4] == '0' || letra33[4] == '1' || letra33[4] == '2' || letra33[4] == '3' || letra33[4] == '4'
              || letra33[4] == '4' || letra33[4] == '6' || letra33[4] == '7' || letra33[4] == '8'
              || letra33[4] == '9') {

            int qtd = 0;
            inteiroCONVERT = Character.toString(letra33[3]);
            inteiroCONVERT += Character.toString(letra33[4]);

            fullconvert = Integer.parseInt(inteiroCONVERT);
            marcador = true;

            qtd = entrada2.length() - 1;
            qtd -= 5;

            char letraentrada[] = new char[qtd];
            int contletra = 6;
            for (int i = 0; i < qtd; i++) {

              letraentrada[i] = letra33[contletra++];

            }

            entrada2 = String.valueOf(letraentrada);

          }

          if (marcador == false && (letra33[3] == '0' || letra33[3] == '1' || letra33[3] == '2' || letra33[3] == '3'
              || letra33[3] == '3' || letra33[3] == '3' || letra33[3] == '6' || letra33[3] == '7' || letra33[3] == '8'
              || letra33[3] == '9')) {

            inteiroCONVERT = Character.toString(letra33[3]);
            fullconvert = Integer.parseInt(inteiroCONVERT);

            int qtd = entrada2.length() - 1;
            qtd -= 4;

            char letraentrada2[] = new char[qtd];
            int contletra2 = 5;

            for (int i = 0; i < qtd; i++) {

              letraentrada2[i] = letra33[contletra2++];

            }

            entrada2 = String.valueOf(letraentrada2);

          }

        }

      }

    }

    imprimirLista(lista);

  }

}