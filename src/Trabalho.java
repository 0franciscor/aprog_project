import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Trabalho {

    static final int COR = 1;
    static final int COR2 = 5;

    public static void main(String[] args) throws FileNotFoundException {
        int[][] matriz = alineaA();
        if(matriz.length<=1)
            System.out.println("Não foi possível realizar as operações.");
        else {
            System.out.println("b)");
            alineaB(matriz);
            int[][] matrizFiltro = alineaC(matriz);
            System.out.println("\nd)\n" + alineaD(matriz, matrizFiltro));
            alineaE(matrizFiltro);
            alineaF(matrizFiltro);
            alineaG(matrizFiltro);
            int[][] matrizInvertida = alineaH(matrizFiltro);
            alineaJ(matrizInvertida, alineaI(matrizInvertida));
        }
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
                    matriz[colunaCorrente][i] = Integer.valueOf(String.valueOf(String.valueOf(input).charAt(i))); //Obtém os algarimos da string, um a um, e converte-os para inteiros. Estes inteiros são adicionados a uma matriz
                colunaCorrente++;
            }
        }
        return matriz;
    }

    public static void alineaB(int[][] matriz){ //=========IMPRESSAO DA MATRIZ ORIGINAL=========
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
                    matrizFiltro[i][j] = (matriz[i][j] + matriz[i][j - 1] + matriz[i][j + 1] + matriz[i - 1][j] + matriz[i + 1][j]) / 5;
                }
            }
            System.out.println("\nc)");
            alineaB(matrizFiltro);

        }else {
            System.out.println("\nc)");
            System.out.print("Não foi possível aplicar o filtro.");
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

        System.out.println("e)");
        alineaEaux1(matrizFiltro, 0, (matrizFiltro.length/2),0, (matrizFiltro.length/2));
        alineaEaux1(matrizFiltro, 0, (matrizFiltro.length/2),(matrizFiltro.length- matrizFiltro.length/2), matrizFiltro.length);
        System.out.println();
        alineaEaux1(matrizFiltro, (matrizFiltro.length - matrizFiltro.length/2), (matrizFiltro.length),0, (matrizFiltro.length/2));
        alineaEaux1(matrizFiltro, (matrizFiltro.length-matrizFiltro.length/2), (matrizFiltro.length), (matrizFiltro.length- matrizFiltro.length/2), (matrizFiltro.length));

    }

    public static void alineaEaux1(int[][] matrizFiltro, int a, int b, int c, int d){
        int Q[] = new int[(matrizFiltro.length/2)*(matrizFiltro.length/2)];
        int aux=0;

        for(int i=a; i< b; i++){
            for(int j=c; j< d; j++){
                Q[aux] = matrizFiltro[i][j];
                aux++;
            }
        }
        System.out.print(alineaEaux2(Q));
    }

    public static int alineaEaux2(int[] quadrante) {
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
        if (quantidadeMenores >= (quadrante.length/2))
            return menor;

        else{
            int i = 0, maior=-1, aux, indiceMaior=0;
            do {
                aux=0;
                if (quadrante[i] != menor) { //Tenta encontrar um num no array que seja diferente do menor
                    temp = quadrante[i];
                    flag = true;
                }

                if(flag) {
                    for (int j = 0; j < quadrante.length; j++) { //Verifica se o num encontrado tem mais do que uma repetição
                        if (quadrante[j] == temp)
                            aux++;
                    }
                    if(aux>maior) {
                        indiceMaior = i;
                        maior = aux;
                    }
                }
                i++;
            } while (i < quadrante.length && aux<(quadrante.length)/2);

            if(maior>quantidadeMenores)
                return quadrante[indiceMaior];
            else
                return menor;
        }
    }

    public static void alineaF (int [][] matrizFiltro){
        System.out.println("\nf)");

        int cores [] = new int [10]; //ou tamanho=10, visto os numeros variarem de 0 a 9 ou (matrizFiltro.length)*(matrizFiltro.length)

        int aux=1,cor, j;
        boolean flag = true;

        cores[0]=matrizFiltro[0][0];

        for (int i=0; i< matrizFiltro.length;i++){
            if(i==0)
                j=1;
            else
                j=0;
            for(; j<matrizFiltro.length;j++) {
                cor = matrizFiltro[i][j];
                for(int k=0; k< aux; k++){
                    if(cor==cores[k])
                        flag = false;
                }
                if(flag) {
                    cores[aux] = cor;
                    aux++;
                }
                flag = true;
            }
        }

        for(int k = 0; k<aux; k++){
            int menor =10; //SEGUINTE INSTANCIA A SEGUIR AO ZERO ou 10
            for(int i =0; i<aux; i++) {
                if (cores[i]<menor && cores[i]!=-1){
                    menor = cores[i];
                }
            }
            System.out.print("[" + menor + "]");//Print do menor
            for(int i = 0; i<aux; i++){
                if(cores[i] == menor)
                    cores[i] = -1;
            }
        }
    }

    public static void alineaG (int [][] matrizFiltro){
        System.out.println("\ng)");
        for(int i=0; i<matrizFiltro.length;i++){ //ciclo que percorre a matriz e substitui uma cor por uma outra pretendida
            for(int j=0;j<matrizFiltro.length;j++){
                if(matrizFiltro[i][j]== COR)
                    matrizFiltro[i][j]=COR2;
            }
        }
        alineaB(matrizFiltro);
        System.out.println();
    }

    public static int[][] alineaH (int [][] matrizFiltro){
        int[][] matrizInvertida = new int[matrizFiltro.length][matrizFiltro.length];
        for (int i = 0; i < matrizFiltro.length; i++) {
            int aux=0;
            for (int j = matrizFiltro.length-1; j >=0; j--) {//Inverte a ordem das linhas, ou seja, um print invertido
                matrizInvertida [i][aux] =matrizFiltro[i][j];
                aux++;
            }
        }
        System.out.println("h)");
        alineaB(matrizInvertida);
        return matrizInvertida;
    }

    public static int alineaI (int [][] matrizInvertida){
        System.out.println("\ni)");

        int soma=0, menor=0, maiorLinha=0;
        for(int i=0; i< matrizInvertida.length; i++){ //Ciclo para realizar as somas das linhas
            for (int j=0; j< matrizInvertida.length; j++) {
                soma += matrizInvertida[i][j];
            }
            if (i==0){ //Estabelece a primeira linha como a menor para poder comparar com as restantes linhas da matriz
                menor = soma;
                maiorLinha=i+1;
            }else{ //Define a linha com a menor soma, à medida que executa o ciclo.
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

    public static void alineaJ (int [][] matrizInvertida, int maiorLinha){

        System.out.println("j)");
        for(int i=0; i<matrizInvertida.length; i++)
            matrizInvertida[maiorLinha-1][i]=9;  //Pinta a linha com o indice obtido na alinea anterior com 9

        alineaB(matrizInvertida);
    }
}