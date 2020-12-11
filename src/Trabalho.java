import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Trabalho {

    public static void main(String[] args) throws FileNotFoundException {
        int[][] matriz = alineaA();
        alineaB(matriz);
        int [][] matrizFiltro = alineaC(matriz);
        System.out.println("\nd)\n" + alineaD(matriz, matrizFiltro));
    }

    public static int[][] alineaA () throws FileNotFoundException {
        File inputMatriz = new File("Imagem.txt");
        Scanner ler = new Scanner(inputMatriz);

        int linhaCorrente = 0;
        int colunaCorrente = 0;
        int[][] matriz = null;

        while (ler.hasNext()) {
            linhaCorrente++;
            String input = ler.nextLine();
            System.out.println(input);
            if(linhaCorrente == 2){
                int numLinhas = Integer.valueOf(input);
                matriz = new int[numLinhas][numLinhas];
            }
            if (linhaCorrente > 2) {
                for (int i = 0; i < matriz.length; i++)
                    matriz[colunaCorrente][i] = Integer.valueOf(String.valueOf(String.valueOf(input).charAt(i)));
                colunaCorrente++;
            }
        }
        return matriz;
    }

    public static void alineaB(int[][] matriz){
        System.out.println("b)");
        for(int i=0; i < matriz.length ; i++){
            if (i!=0)
                System.out.println();
            for(int j=0; j < matriz.length ; j++)
                System.out.print(matriz[i][j]);
        }
    }

    public static int[][] alineaC(int[][] matriz) {
        int[][] matrizFiltro = matriz;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matrizFiltro[i][j] = matriz[i][j];
            }
        }
        if (matriz.length > 2) {
            for (int i = 1; i < (matrizFiltro.length - 1); i++) {
                for (int j = 1; j < (matrizFiltro.length - 1); j++) {
                    matrizFiltro[i][j] = (matriz[i][j] + matriz[i][j - 1] + matriz[i][j + 1] + matriz[i - 1][j] + matriz[i + 1][j]) / 5; //requer mais teste
                }
            }
            System.out.println("\nc)");
            for (int i = 0; i < matriz.length; i++) {
                if (i != 0)
                    System.out.println();
                for (int j = 0; j < matriz.length; j++)
                    System.out.print(matriz[i][j]);
            }
        }
            return matrizFiltro;
    }

    public static boolean alineaD(int[][] matriz, int[][] matrizFiltro){
        boolean flag = true;
        for(int i = 0; i<matriz.length; i++){
            for(int j = 0; j< matriz.length; j++){
                if (matriz[i][j] != matrizFiltro[i][j])
                    flag = false;
            }
        }
        return flag;
    }
}

