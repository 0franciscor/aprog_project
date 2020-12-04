import java.util.Scanner;
public class Trabalho {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        int n; //n = ordem da matriz (ex 4x4)
        do{
            n=ler.nextInt();
        }while(n<=0);

        int [][] matriz = new int [n][n];
        alineaA(matriz,n);
        alineaB(matriz,n);

    }




    public static void alineaA (int [][] matriz,int n){

        for(int i=0; i < n ; i++)
            for(int j=0; j < n; j++){
                matriz [i][j]= ler.nextInt();
            }



    }
    /*==========================================================*/
    public static void alineaB(int [][] matriz, int n){

        for(int i=0; i < n ; i++){
            System.out.println();
            for(int j=0; j < n; j++)
                System.out.print(matriz[i][j]);
        }

    }

}
