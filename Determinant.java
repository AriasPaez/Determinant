/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Determinant;

/**
 *
 * @author Arias
 */
public class Determinant {

    /**
     * @param args the command line arguments
     */
//    double matriz_A[][] = {
//        {4, 7, -2},
//        {3, -5, 1},
//        {-8, 6, 9}
//    };
    double matriz_A[][] = {
        {2, 0, 3, 1},
        {0, 1, 4, 2},
        {0, 0, 1, 5},
        {1, 2, 3, 0}
    };

    double matriz_B[][] = {
        {-6, 8, -5, 0, 0},
        {0, 0, 0, 0, -3},
        {-5, 0, -5, -6, 0},
        {0, -8, 0, 0, 2},
        {0, -7, 0, 2, 1}
    };
    double matriz_C[][] = {
        {1, 3, 5, 2},
        {0, -1, 3, 4},
        {2, 1, 9, 6},
        {3, 2, 4, 8}
    };
//    double matriz_C[][] = {
//        {3, 5, 2},
//        {4, 2, 3},
//        {-1, 2, 4}
//    };

//    double matriz_A[][] = {
//        {4, 7},
//        {3, -5}
//    };
//    
    public double determinante2x2(double matriz[][]) {
        return (matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0]);
    }

    public void show_matriz_nxn(String text, double[][] matriz) {
        System.out.println(text);
        for (int j = 0; j < matriz.length; j++) {
            for (int k = 0; k < matriz[0].length; k++) {
                System.out.print((int) (matriz[j][k]) + "\t");
            }
            System.out.println("");
        }
    }

    public double[][] extraer_sub_matriz(double matriz[][], int k) {
        double sub_matriz[][] = new double[matriz.length - 1][matriz[0].length - 1];
        boolean column_k = false;

        for (int j = 0; j < sub_matriz.length; j++) {
            for (int k2 = 0; k2 < sub_matriz.length; k2++) {
                if (k2 == k || column_k) {
                    sub_matriz[j][k2] = matriz[j + 1][k2 + 1];
                    column_k = true;
                } else {
                    sub_matriz[j][k2] = matriz[j + 1][k2];
                }
            }
            column_k = false;
        }
        return sub_matriz;
    }

    private double determinante(double matriz[][]) {

        return determinante_recursivo(matriz, 0);
    }

    public double determinante_recursivo(double matriz[][], double determ) {
        if (matriz.length == 2) {
            determ = determinante2x2(matriz);
            return determ;
            //System.out.println("det = " + determinante);

        } else {
            double det_temp = 0;
            for (int i = 0; i < matriz[0].length; i++) {
                /*se eleva a i, y no a "i+1" debido a que la matriz se recorre desde cero 
                    y no desde uno como en la prueba de escritorio*/
                double detMjk = determinante_recursivo(extraer_sub_matriz(matriz, i), determ);
                det_temp += Math.pow(-1, i) * matriz[0][i] * detMjk;

            }
            return det_temp;
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Determinant det = new Determinant();
        det.show_matriz_nxn("Matriz A:", det.matriz_A);
        //System.out.println();
        //det.show_matriz_nxn("sub_Matriz: ", det.extraer_sub_matriz(det.matriz_A, 2));
        //System.out.println("");
        System.out.println("det = " + det.determinante(det.matriz_A));
        System.out.println("-----------------");
        det.show_matriz_nxn("Matriz B:", det.matriz_B);
        System.out.println("");
        System.out.println("det = " + det.determinante(det.matriz_B));
        System.out.println("-----------------");
        det.show_matriz_nxn("Matriz C:", det.matriz_C);
        System.out.println("");
        System.out.println("det = " + det.determinante(det.matriz_C));
        System.out.println("-----------------");
        //determinante.show_matriz_nxn("Matriz A", determinante.matriz_A);
        //determinante.show_matriz_nxn("Sub_Matriz", determinante.extraer_sub_matriz(determinante.matriz_A, 0));

    }

}
