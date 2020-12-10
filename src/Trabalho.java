import java.io.FileNotFoundException;
import java.util.Scanner;
public class Trabalho {
    static Scanner ler = new Scanner(System.in);

    static final String fILE1 = "textFile.txt";
    static final String fILE2 = "textFile2.txt";
    static final int MAX_ROWS = 20;
    static final int MAX_COLUMNS = 20;


    public static void main(String[] args) throws FileNotFoundException {

        String [] textoDiscrito = new String [MAX_ROWS];
        int [] dimensaoImagem = new int[MAX_ROWS];
        int [][] matriz = new int [MAX_ROWS][MAX_COLUMNS];

        
       /* System.out.println("Quadro com numeros");

        int n; //n = ordem da matriz (ex 4x4)
        do{
            n=ler.nextInt();
        }while(n<=0);

        int [][] matriz = new int [n][n];
        alineaA(matriz,n);
        alineaB(matriz,n);

        */
    }



    public static void alineaA (int [][] matriz,int n){

        for(int i=0; i < n ; i++) {
            int num = ler.nextInt();
            /*int caracteres = String.valueOf(num).length();
            while (caracteres > n){
                num = ler.nextInt();
                caracteres = String.valueOf(num).length();
            }*/
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
        }
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
