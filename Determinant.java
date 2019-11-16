/**
 * @author Cristian Arias
 */
public class Determinant {

    double matriz_A[][] = {
        {2, 0, 3, 1},
        {0, 1, 4, 2},
        {0, 0, 1, 5},
        {1, 2, 3, 0}
    };


    //Function determinant 2x2. It is used by function determinant_recursive for get out of this function recursive
    public double determinant2x2(double matriz[][]) {
        return (matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0]);
    }
    //Show content of matriz nxn
    public void show_matriz_nxn(String text, double[][] matriz) {
        System.out.println(text);
        for (int j = 0; j < matriz.length; j++) {
            for (int k = 0; k < matriz[0].length; k++) {
                System.out.print((int) (matriz[j][k]) + "\t");
            }
            System.out.println("");
        }
    }
    //Extract sub-matriz of matriz, it is necesary for the process basic of determinant
    public double[][] extract_sub_matriz(double matriz[][], int k) {
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
    //Principal function of determinant
    private double determinant(double matriz[][]) {
        return determinant_recursive(matriz, 0);
    }
    //Recursive function of determinant
    public double determinant_recursive(double matriz[][], double determ) {
        if (matriz.length == 2) {
            determ = determinant2x2(matriz);
            return determ;            
        } else {
            double det_temp = 0;
            for (int i = 0; i < matriz[0].length; i++) {
                double detMjk = determinant_recursive(extract_sub_matriz(matriz, i), determ);
                det_temp += Math.pow(-1, i) * matriz[0][i] * detMjk;
            }
            return det_temp;
        }
    }

    public static void main(String[] args) {
        
        Determinant det = new Determinant();
        det.show_matriz_nxn("Matriz A:", det.matriz_A);
        System.out.println("Determinant = " + det.determinant(det.matriz_A));
        System.out.println("-----------------");


    }

}
