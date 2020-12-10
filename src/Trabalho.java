import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Trabalho {

    public static void main(String[] args) throws FileNotFoundException {
        alineaB(alineaA());
    }

    public static int[][] alineaA () throws FileNotFoundException {
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
        read.close();
        return matriz;
    }

    public static void alineaB(int [][] matriz){
        System.out.println("\nb)");
        for(int i=0; i < matriz.length ; i++){
            if (i!=0)
                System.out.println();
            for(int j=0; j < matriz.length ; j++)
                System.out.print(matriz[i][j]);
        }
    }
}