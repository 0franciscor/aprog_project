import com.sun.jdi.ClassObjectReference;

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
        alineaG(matrizFiltro);
        alineaH(matrizFiltro);
        alineaI(matrizFiltro);
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
        int Q1[] = new int[4];
        int Q2[] = new int[4];
        int Q3[] = new int[4];
        int Q4[] = new int[4];

        int k = 0; //PRIMEIRO QUADRANTE
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                Q1[k] = matrizFiltro[i][j];
                k++;
            }
        }

        k = 0; //SEGUNDO QUADRANTE
        for(int i = 0; i < 2; i++){
            for(int j = (matrizFiltro.length-2); j < matrizFiltro.length; j++){
                Q2[k] = matrizFiltro[i][j];
                k++;
            }
        }

        k=0; //TERCEIRO QUADRANTE
        for(int i = (matrizFiltro.length-2); i < matrizFiltro.length; i++){
            for(int j = 0; j < 2; j++){
                Q3[k] = matrizFiltro[i][j];
                k++;
            }
        }

        k=0; //QUARTO QUADRANTE
        for(int i = (matrizFiltro.length-2); i < matrizFiltro.length; i++){
            for(int j = (matrizFiltro.length-2); j <matrizFiltro.length; j++){
                Q4[k] = matrizFiltro[i][j];
                k++;
            }
        }
        System.out.println("e)");
        System.out.print(alineaEaux(Q1));
        System.out.println(alineaEaux(Q2));
        System.out.print(alineaEaux(Q3));
        System.out.println(alineaEaux(Q4));

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
            } while (i < quadrante.length && aux<=2);

            if(aux>=2)
                return temp;
            else
                return menor;
        }
    }

    public static int [] alineaF (int [][] matrizFiltro){
        int arr [] = new int [16];

        int aux=0,cor=0;
        boolean flag = true;

        for (int i=0; i< matrizFiltro.length;i++){
            for(int j=0; j<matrizFiltro.length;j++){
                cor=matrizFiltro[i][j];
                for(int k=0; k<Math.pow(matrizFiltro.length, 2); k++){
                    if (cor == arr[k]){
                        flag = false;
                    }
                }
                if(flag) {
                    arr[aux] = cor;
                    aux++;
                    flag = true;
                }
            }
        }
        for(int i=0; i < arr.length ; i++){
            System.out.print(arr[i]);
        }
        return arr;
    }

    public static int[][] alineaG (int [][] matrizFiltro){
        System.out.println("g)");
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
        return matrizFiltro;
    }

    public static int[][] alineaH (int [][] matrizFiltro){

        System.out.println("h)");
        for (int i = 0; i < matrizFiltro.length; i++) {
            if (i != 0)
                System.out.println();
            for (int j = matrizFiltro.length-1; j >=0; j--)
                System.out.print(matrizFiltro[i][j]);
        }
        return matrizFiltro;
    }

    public static int alineaI (int [][] matrizFiltro){

        int numLinha=0, soma=0,aux=0,aux1=0,aux2=0,aux3=0,menor=0;

        System.out.println("\ni)");
        for(int i=0; i< matrizFiltro.length; i++){
            aux1=soma;
            soma=0;
            for (int j=0; j< matrizFiltro.length; j++){
                soma += matrizFiltro[i][j];

            }
            System.out.println(soma);
        }
        return numLinha;
    }
}
