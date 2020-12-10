import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;
public class Trabalho {

    public static void main(String[] args) throws FileNotFoundException {
        alineaA();
        //alineaB();
    }

    public static void alineaA () throws FileNotFoundException {
        File inputMatriz = new File("Imagem.txt");
        Scanner ler = new Scanner(inputMatriz);
        int numLinhas = 0;
        while (ler.hasNext()) {
            String readLinhas = ler.nextLine();
            numLinhas++;
        }
        ler.close();

        int[][] matriz = new int[(numLinhas - 2)][(numLinhas - 2)];

        Scanner read = new Scanner(inputMatriz);
        int aux = 0;
        int aux2 = 0;
        while (read.hasNext()) {
            aux++;
            String input = read.nextLine();
            System.out.println(input);
            if (aux > 2) {
                for (int j = 0; j < matriz.length; j++)
                    matriz[aux2][j] = Integer.valueOf(String.valueOf(String.valueOf(input).charAt(j)));
                aux2++;
            }
        }

        System.out.println("");
        for (int i = 0; i < matriz.length; i++) {
            if (i != 0)
                System.out.println();
            for (int j = 0; j < matriz.length; j++)
                System.out.print(matriz[i][j]);

        }
    }

        //Integer.valueOf(String.valueOf(String.valueOf(num).charAt(j)));

        /*for(int i=0; i < n ; i++) { LEITURA DE CADA FILA DE STRING
            int num = ler.nextInt();
            int caracteres = String.valueOf(num).length();  //Outra maneira de converter os alagarismos
            while (caracteres > n){
                num = ler.nextInt();
                caracteres = String.valueOf(num).length();
            }
                // matriz[i][j]= Integer.valueOf(String.valueOf(String.valueOf(num).charAt(j))); precisa do ciclo for em função de j
            int aux1 = num;
            int aux2 = n;
            do {
                int dig = aux1 % 10;
                int aux = dig;
                aux2--;
                matriz[i][aux2]=aux;
                aux1 = aux1 / 10;
            }while (aux1>0);
        }*/

    /*==========================================================*/
    public static void alineaB(int [][] matriz, int n){
        for(int i=0; i < n ; i++){
            if (i!=0)
                System.out.println();
            for(int j=0; j < n; j++)
                System.out.print(matriz[i][j]);
        }
    }
}