//Aluno: Vinícius Henrique Giovanini
//Matricula: 692225
//Matéria: AEDS2

//RESULTADO DO PROGRAMA: O PROGRAMA DEU APENAS 3 ERROS, QUE FORAM ERROS DE ESPAÇO,
//QUE CONSISTE QUE O PUB.OUT REQUER EM ALGUNS CASOS
// 2 ESPAÇOS DIVIDINO CADA ATRIBUTO DA STRING, NA QUAL NÃO FOI
//RESOLVIDO. Os erros estão presente na Serie Greys Anatomy, no país de origem. 
//House of Cards no Formato. E Once Upon a Time, também no Formato.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Serieps {

  private String nome;

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

}

public class pesquisasequencial {

  public static void pesquisaSequencial(String nome, int contador, String[] seq) {

    seq[contador] = nome;

  }

  public static void main(String[] args) {

    // StringBuilder entradapasta = new StringBuilder("series/");

    String entrada;
    String entrada2;
    entrada = MyIO.readLine(); // Faz a entrada do nome do arquivo. (EX 24.html)
    String[] seq = new String[100];
    int contadorseq = 0;
    // entradapasta.append(entrada);
    // System.out.println(entradapasta);

    Serieps nt = new Serieps();// Faz a ligacao com a classe
    while (!(entrada.equals("FIM"))) {// roda até entrada ser digitado FIM

      try {

        // MEU DIRETORIO
        // "/mnt/d/PASTAS_AREA_DE_TRABALHO/Faculdade_4_Periodo/AEDS2REMAKE/AEDSPRATICO/tp02/series/"

        BufferedReader in = new BufferedReader(new FileReader("/tmp/series/" + entrada));
        // aqui as series estão localizadas na pasta series, a entrada é o nome do
        // arquivo que será adicionado ao diretório serie/(NOME_DO_ARQUIVO)
        String str;
        while ((str = in.readLine()) != null) {

          // System.out.println(str);

          // NESSA PARTE CADA CONTAIS ESTA SETADO PARA IDENTIFICAR A LINHA QUE EU QUERO
          // BUSCAR O NOME, FORMATO ETC, ALGUMAS LINHA TEM QUE PARAR NELAS E LER MAIS UMA
          // ONDE ESTÁ LOCALIZADO A MINHA LINHA DESEJADA, QUANDO ELE ENCONTRA A LINHA, ELE
          // ACIONA A CLASSE E MANDA A STRING ENCONTRADA PRA CLASSE, E LOGO EM SEGUIDA ELE
          // ACIONA O MÉTODO BUSCAR DA LINHA ENCONTRADA, QUE VAI TER A FUNÇÃO DE LIMPAR A
          // LINHA QUE ESTÁ COM VÁRIOS ELEMENTOS HTML, SOBRANDO ASSIM SOMENTE A STRING
          // DESEJADA COMO O NOME DA SÉRIE, O FORMATO ETC

          if (str.contains("firstHeading")) {// buscar o nome

            nt.setNome(str);// enviar a string
            nt.buscanome();// fazer a busca e filtro na string enviada

          }

        }
        in.close();
        // System.out.println(nt.getNome());
        pesquisaSequencial(nt.getNome(), contadorseq, seq);
        contadorseq++;

      } catch (IOException e) { // CASO NAO ENCONTRE O ARQUIVO RETORNA O ERRO
        System.out.println("ERROR IOEXCEPTION");
      }

      entrada = MyIO.readLine();// E PEDE PRA ESCREVER O NOME DO NOVO ARQUIVO, SE FOR "FIM" ELE TERMINA O
                                // PROGRAMA

    }

    entrada2 = MyIO.readLine();

    while (!(entrada2.equals("FIM"))) {

      boolean marcador3 = false;

      for (int cd = 0; cd < seq.length; cd++) {

        if (entrada2.equals(seq[cd])) {
          System.out.println("SIM");
          cd = seq.length;
          marcador3 = false;

        } else {
          marcador3 = true;
        }

      }

      if (marcador3 == true) {
        System.out.println("NÃO");
      }

      entrada2 = MyIO.readLine();

    }

  }

}