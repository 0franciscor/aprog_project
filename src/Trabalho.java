import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Trabalho {

    static final int COR = 1;
    static final int COR2 = 5;

    public static void main(String[] args) throws FileNotFoundException {
        int[][] matriz = alineaA();
        alineaB(matriz);
        int[][]matrizFiltro = alineaC(matriz);
        System.out.println("\nd)\n" + alineaD(matriz,matrizFiltro));
        alineaE(matrizFiltro);
        alineaF(matrizFiltro);
        alineaG(matrizFiltro);
        alineaH(matrizFiltro);
        alineaJ(matrizFiltro,alineaI(matrizFiltro));
    }

    public static int[][] alineaA () throws FileNotFoundException { //=========LEITURA E ARMAZENAMENTO DE DADOS=========
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

    public static void alineaB(int[][] matriz){ //=========IMPRESSAO DA MATRIZ ORIGINAL=========
        System.out.println("b)");
        for(int i=0; i < matriz.length ; i++){
            if (i!=0)
                System.out.println();
            for(int j=0; j < matriz.length ; j++)
                System.out.print(matriz[i][j]);
        }
    }

    public static int[][] alineaC(int[][] matriz) { //=========CRIAÇÃO DA MATRIZ FILTRO=========
        int[][] matrizFiltro = new int[matriz.length][matriz.length];
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
            for (int i = 0; i < matrizFiltro.length; i++) {
                if (i != 0)
                    System.out.println();
                for (int j = 0; j < matrizFiltro.length; j++)
                    System.out.print(matrizFiltro[i][j]);
            }
        }
        return matrizFiltro;
    }

    public static boolean alineaD(int[][] matriz, int[][] matrizFiltro){ //=========COMPARAÇÃO DA MATRIZ ORIGINAL E DA MATRIZ FILTRO=========
        for(int i = 0; i<matriz.length; i++){
            for(int j = 0; j< matriz.length; j++){
                if (matriz[i][j] != matrizFiltro[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void alineaE(int[][] matrizFiltro){
        int Q[] = new int[4];
        System.out.println("e)");
        if((matrizFiltro.length%2)==0){
            for(int i=0; i< matrizFiltro.length; i+=2){
                if(i!=0 && (i%2)==0)
                    System.out.println();
                for(int j=0; j< matrizFiltro.length; j+=2){
                    Q[0] = matrizFiltro[i][j];
                    Q[1] = matrizFiltro[i][j+1];
                    Q[2] = matrizFiltro[i+1][j];
                    Q[3] = matrizFiltro[i+1][j+1];
                    System.out.print(alineaEaux(Q));
                }
            }
        }
        else if(matrizFiltro.length==2) {
            Q[0] = matrizFiltro[0][0];
            Q[1] = matrizFiltro[0][1];
            Q[2] = matrizFiltro[1][0];
            Q[3] = matrizFiltro[1][1];
            System.out.print(alineaEaux(Q));
        }
        else if((matrizFiltro.length/2)%2 == 0){
            for(int i=0; i< (matrizFiltro.length/2); i+=2){
                if(i!=0 && (i%2)==0)
                    System.out.println();
                for(int j=0; j< (matrizFiltro.length/2); j+=2){
                    Q[0] = matrizFiltro[i][j];
                    Q[1] = matrizFiltro[i][j+1];
                    Q[2] = matrizFiltro[i+1][j];
                    Q[3] = matrizFiltro[i+1][j+1];
                    System.out.print(alineaEaux(Q));
                }
            }
        }
        else if((matrizFiltro.length/2)%2 != 0){

        }
    }

    public static int alineaEaux(int[] quadrante) {
        int menor = quadrante[0], temp = -1, quantidadeMenores = 0;
        boolean flag = false;

        for (int i = 1; i < quadrante.length; i++) {
            if (menor > quadrante[i])
                menor = quadrante[i];
        }
        for (int i = 0; i < quadrante.length; i++) {
            if (menor == quadrante[i])
                quantidadeMenores++;
        }
        if (quantidadeMenores >= 2)
            return menor;

        else{
            int i = 0, aux;
            do {
                aux=0;
                if (quadrante[i] != menor) { //tenta encontrar um num no array que seja diferente do menor
                    temp = quadrante[i];
                    flag = true;
                }

                if(flag) {
                    for (int j = 0; j < quadrante.length; j++) { //verifica se o num encontrado tem mais do que uma repetição
                        if (quadrante[j] == temp)
                            aux++;
                    }
                }
                i++;
            } while (i < quadrante.length && aux<2);

            if(aux>=2)
                return temp;
            else
                return menor;
        }
    }

    public static void alineaF (int [][] matrizFiltro){
        System.out.println("\nf)");

        int arr [] = new int [(matrizFiltro.length)*(matrizFiltro.length)];

        int aux=1,cor, j;
        boolean flag = true;

        arr[0]=matrizFiltro[0][0];

        for (int i=0; i< matrizFiltro.length;i++){
            if(i==0)
                j=1;
            else
                j=0;
            for(; j<matrizFiltro.length;j++) {
                cor = matrizFiltro[i][j];
                for(int k=0; k< aux; k++){
                    if(cor==arr[k])
                        flag = false;
                }
                if(flag == true) {
                    arr[aux] = cor;
                    aux++;
                }
                flag = true;
            }
        }

        for(int k = 0; k<aux; k++){
            int menor =10; //SEGUINTE INSTANCIA A SEGUIR AO ZERO
            for(int i =0; i<aux; i++) {
                if (arr[i]<menor && arr[i]!=-1){
                    menor = arr[i];
                }
            }
            System.out.print("[" + menor + "]");
            for(int i = 0; i<aux; i++){
                if(arr[i] == menor)
                    arr[i] = -1;
            }
        }
    }

    public static void alineaG (int [][] matrizFiltro){
        System.out.println("\ng)");
        for(int i=0; i<matrizFiltro.length;i++){
            for(int j=0;j<matrizFiltro.length;j++){
                if(matrizFiltro[i][j]== COR)
                    matrizFiltro[i][j]=COR2;
            }
        }
        for (int i = 0; i < matrizFiltro.length; i++) {
            if (i != 0)
                System.out.println();
            for (int j = 0; j < matrizFiltro.length; j++)
                System.out.print(matrizFiltro[i][j]);
        }
        System.out.println();
    }

    public static void alineaH (int [][] matrizFiltro){

        System.out.println("h)");
        for (int i = 0; i < matrizFiltro.length; i++) {
            if (i != 0)
                System.out.println();
            for (int j = matrizFiltro.length-1; j >=0; j--)
                System.out.print(matrizFiltro[i][j]);
        }

    }

    public static int alineaI (int [][] matrizFiltro){
        System.out.println("\ni)");

        int soma=0, menor=0, maiorLinha=0, aux1;
        for(int i=0; i< matrizFiltro.length; i++){
            for (int j=0; j< matrizFiltro.length; j++) {
                soma += matrizFiltro[i][j];
            }
            if (i==0){
                menor = soma;
                maiorLinha=i+1;
            }else{
                if (soma<=menor){
                    menor = soma;
                    maiorLinha=i+1;
                }
            }
            soma=0;
        }
        System.out.println(maiorLinha);
        return maiorLinha;
    }

    public static void alineaJ (int [][] matrizFiltro, int maiorLinha){

        System.out.println("j)");
        for(int i=0; i<matrizFiltro.length; i++)
            matrizFiltro[maiorLinha-1][i]=9;

        for (int i = 0; i < matrizFiltro.length; i++) {
            if(i!=0)
                System.out.println();
            for (int j = 0; j < matrizFiltro.length; j++)
                System.out.print(matrizFiltro[i][j]);
        }
    }
}