/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @version 1.0
 * @author Duvan Poveda, David Jimenez
 */
import java.util.Scanner;
public class multiMatriz {
    public static void crearMatriz(){              //metodo para crear la matriz
    byte fila1, fila2, columna1, columna2, error = 0;
    Scanner teclado= new Scanner(System.in);          //llamamos el scanner para recibir por teclado
    System.out.print("ingrese el numero de filas de la primera matriz: ");          //pedimos el tamaño de las matrices a operar
    fila1 = teclado.nextByte();
    System.out.print("ingrese el numero de columnas de la primera matriz: "); 
    columna1 = teclado.nextByte();
    do{                                                                    //validamos que la columna 1 y fila 2 sean iguales
    System.out.print("ingrese el numero de filas de la segunda matriz: "); 
    fila2 = teclado.nextByte();
    if(columna1!=fila2){
        error=1;
        System.out.println("el numero de columnas de la matriz 1 y las filas de la matriz 2 son diferentes");
    }else{
        break;
    }
    }while(error==1);
    System.out.print("ingrese el numero de columnas de la segunda matriz: "); 
    columna2 = teclado.nextByte();
    int [][] matriz1 = new int[fila1][columna1];                                //creamos las matrices
    int [][] matriz2 = new int[fila2][columna2]; 
    rellenarMatri(matriz1,matriz2);                                             //llamamos el metodo para rellenarlas
    }
    public static void rellenarMatri(int matriz1[][], int matriz2[][]){         //creamos el metodo para rellenarlas
        Scanner teclado= new Scanner(System.in);
        byte i, j;
        for(i=0; i<matriz1.length; i++){                                           //recorremos las matrices pidiendo que asignen los valores
            for(j=0; j<matriz1[i].length; j++){
                System.out.print("ingrese el valor de la matriz 1 en la posicion "+ i + j +": ");
                matriz1[i][j] = teclado.nextInt();
            }
        }
        System.out.println("matriz 1 completada ingrese los datos de la matriz 2");
        for(i=0; i<matriz2.length; i++){
            for(j=0; j<matriz2[i].length; j++){
                System.out.print("ingrese el valor de la matriz 2 en la posicion "+ i + j +": ");
                matriz2[i][j] = teclado.nextInt();
            }
        }
        imprimirMatri(matriz1, matriz2);                                        //llamamos el metodo para imprimirlas
    }
    public static void imprimirMatri(int matriz1[][], int matriz2[][]){
        byte i, j;
        System.out.println("esta es la matriz 1: ");                            //recorremos las matrices para imprimirlas
        for(i=0; i<matriz1.length; i++){
            for(j=0; j<matriz1[i].length; j++){
                System.out.print(" "+ matriz1[i][j] +" ");
            }
            System.out.print("\n");
        }
        System.out.println("esta es la matriz 2: ");
        for(i=0; i<matriz2.length; i++){
            for(j=0; j<matriz2[i].length; j++){
                System.out.print(" "+ matriz2[i][j] +" ");
            }
            System.out.print("\n");
        }
        multipliMatri(matriz1,matriz2);                                         //llamamos el metodo para multiplicarlas
    }
    public static void multipliMatri(int matriz1[][], int matriz2[][]){           //creamos el metodo para multiplicar las matrices
        byte i, j, k;
        int [][] matriz3 = new int[matriz1.length][matriz2[0].length];          //creamos una matriz de tamaño fila1 por columna2
        for ( i=0; i < matriz3.length; i++) {                                   //recorremos la nueva matriz para ir asignando valores
            for ( j=0; j < matriz3[0].length; j++) {
                for ( k=0; k<matriz2.length; k++) {                             //acumulamos la multiplicacion entre las filas y columans de la matriz 1 y 2
                    matriz3[i][j] += matriz1[i][k]*matriz2[k][j];               //guardamos el respectivo resultado en las posiciones de la matriz 3
                }
               }
        }
        System.out.println("esta es la matriz resultante: ");                   //imprimimos el resultado de la multiplicacion
        for(i=0; i<matriz3.length; i++){
            for(j=0; j<matriz3[i].length; j++){
                System.out.print(" "+ matriz3[i][j] +" ");
            }
            System.out.print("\n");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       crearMatriz();                                               //llamamos el metodo para crear las matrices en nuestro metodo principal
    }
    
}
