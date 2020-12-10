import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Trabalho {

    public static void main(String[] args)throws FileNotFoundException {
        /* System.out.println("Quadro com numeros");

        int n; //n = ordem da matriz (ex 4x4)
        do{
            n=ler.nextInt();
        }while(n<=0);

        int [][] matriz = new int [n][n];
        alineaB(matriz,n);

        */
        alineaA();
    }

    public static void alineaA () throws FileNotFoundException {
        File inputMatriz = new File("Imagem.txt");
        Scanner ler = new Scanner(inputMatriz);
        int aux = 1;
        int ordem=0;
        while (ler.hasNext()) {
            String input = ler.nextLine();
            System.out.println(input);
            if(aux == 2){
                ordem = ler.nextInt();
            }
            aux++;
        }
        int[][] matriz = new int[ordem][ordem]; //Integer.valueOf(String.valueOf(String.valueOf(num).charAt(j)));
        System.out.println(matriz.length);

        /*for(int i=0; i < n ; i++) {
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
    }
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
