//Aluno: Vinícius Henrique Giovanini
//Matricula: 692225
//Matéria: AEDS2
//Pesquisa Sequêncial

//Esse Programa faz igual a classezinha, porém esse faz somente com o atributo nome, pega o atributo nome e coloca dentro de um array,
//pega outro atributo nome e coloca na posicao do array mais um, depois que for digita FIM, ele passa para pesquisa, vc escreve a serie
//e ele pesquisa posicao por posicao, se for encontrado o nome ele imprime SIM se não ele imprime NÃO, isso posição por posição, faz isso para 
//cada nome digitado. 

//RESULTADO, 98% DEU UM ERRO NA SERIE HOUSE OF CARDS, NAO CONSEGUI SABER O PQ DO ERRO

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Seriepsf {

  private String nome;

  // ------------------------------NOME------------------------------//

  public String getNome() {
    return this.nome;
  }

  public void setNome(String recebernome) {
    this.nome = recebernome;
  }

  public void buscanome() {

    String buscar = getNome();
    char[] vetor = buscar.toCharArray();
    char[] vetorreceber = new char[buscar.length()];
    boolean marcador = false;
    int contador = 0;

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

      if (vetor[k] == '/') {

        k = buscar.length() - 1;

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

    this.nome = receber;

  }

}

public class pesquisasequencialemfuncao { // Essa função pega o nome limpado e coloca na posicao do array + 1

  public static void pesquisaSequencial(String nome, int contador, String[] seq) {// pega o nome e coloca no vetor + 1

    seq[contador] = nome;

  }

  public static void fazerPesquisa(String[] seq, boolean marcador3, int cd, String entrada2) {// essa função pega o nome
                                                                                              // digitado e compara
                                                                                              // posicao por posicao, se
                                                                                              // for encontrado a serie
                                                                                              // ele imprime TRUE se nao
                                                                                              // for encontrado imprime
                                                                                              // FALSE

    while (cd < seq.length) {

      if (entrada2.equals(seq[cd])) {

        System.out.println("SIM");
        cd = seq.length;
        marcador3 = true;
      }

      cd++;
    }

    if (marcador3 == false) {

      System.out.println("NÃO");

    }

  }

  public static void main(String[] args) {

    String entrada;
    String entrada2;
    entrada = MyIO.readLine();
    String[] seq = new String[100];
    int contadorseq = 0;

    Seriepsf nt = new Seriepsf();
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

        }
        in.close();
        pesquisaSequencial(nt.getNome(), contadorseq, seq);// pega o nome e manda para a funcao para acrescentar no
                                                           // array
        contadorseq++;

      } catch (IOException e) {
        System.out.println("ERROR IOEXCEPTION");
      }

      entrada = MyIO.readLine();

    }

    entrada2 = MyIO.readLine();// pega a segunda entrada

    while (!(entrada2.equals("FIM"))) {// vai mandando entrada2 para a funcao pesquisar, e faz a pesquisa

      boolean marcador3 = false;
      int cd = 0;
      fazerPesquisa(seq, marcador3, cd, entrada2);
      entrada2 = MyIO.readLine();
    }

  }

}