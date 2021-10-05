//Aluno: Vinícius Henrique Giovanini
//Matricula: 692225
//Matéria: AEDS2
//Pesquisa Binária

//OBS esse programa deu 98.3% pois deu o mesmo erro contido na pesquisa sequencial.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Serie {

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

public class pbinario {

  public static void fazerPesquisa(String[] seq, boolean marcador3, int cd, String entrada2) { // Esse função pega o
                                                                                               // array e marca a
                                                                                               // posicao mais a
                                                                                               // esquerda mais a
                                                                                               // direita e o meio,
                                                                                               // dessa forma ele avalia
                                                                                               // se a string esta no
                                                                                               // meio, se tiver acaba o
                                                                                               // programa,se não tiver
                                                                                               // ele testa na parte da
                                                                                               // direta do array, do
                                                                                               // meio até o ultimo
                                                                                               // elemento a direita, se
                                                                                               // não encontrar ele
                                                                                               // testa do
                                                                                               // elemento(string) mais
                                                                                               // a esquerda até o
                                                                                               // elemento do meio, se
                                                                                               // encontrar em algum
                                                                                               // desses casos o
                                                                                               // programa acaba, se não
                                                                                               // encontrar em nenhum
                                                                                               // desses casos ele
                                                                                               // imprime NÃO e termina
                                                                                               // o programa

    boolean marcadorarray = false;
    int dir = seq.length - 1;
    int esq = 0;
    int meio;

    meio = (esq + dir) / 2;

    while (marcadorarray == false) {

      if (entrada2.equals(seq[meio])) {

        System.out.println("SIM");
        marcadorarray = true;
      }

      if (marcadorarray == false) {

        esq = meio + 1;

        while (esq <= dir) {

          if (entrada2.equals(seq[esq])) {
            System.out.println("SIM");
            marcadorarray = true;
            esq = dir;
          }

          esq++;
        }
      }

      if (marcadorarray == false) {

        esq = 0;

        while (esq <= meio) {

          if (entrada2.equals(seq[esq])) {

            System.out.println("SIM");
            marcadorarray = true;
            esq = meio;
          }

          esq++;

        }

      }

      if (marcadorarray == false) {
        System.out.println("NÃO");
        marcadorarray = true;
      }

    }

  }

  public static void main(String[] args) {

    String entrada;
    String entrada2;
    entrada = MyIO.readLine();
    String[] seq = new String[100];
    int contadorseq = 0;

    Serie nt = new Serie();
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
        seq[contadorseq] = nt.getNome();
        contadorseq++;

      } catch (IOException e) {
        System.out.println("ERROR IOEXCEPTION");
      }

      entrada = MyIO.readLine();

    }

    String[] seqoficial = new String[contadorseq];// abre um vetor com a quantidade exata de posicoes ocupadas, no vetor
                                                  // seq foi aberto 100 casas, no vetor seqoficial no vai abrir a
                                                  // quantidade gasta no vetor seq, na qual sera mandado para a funcao
                                                  // pesquisar

    for (int j = 0; j < contadorseq; j++) {

      seqoficial[j] = seq[j];

    }

    entrada2 = MyIO.readLine();// pega a segunda entrada

    while (!(entrada2.equals("FIM"))) {// vai mandando entrada2 para a funcao pesquisar, e faz a pesquisa

      boolean marcador3 = false;
      int cd = 0;
      fazerPesquisa(seqoficial, marcador3, cd, entrada2);
      entrada2 = MyIO.readLine();
    }

  }

}
