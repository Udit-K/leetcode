package com.company;

public class RotateImage {


    public void rotate(int[][] matrix) {

        int rowLen = matrix.length, colLen = matrix[0].length;
        int[] temp = new int[rowLen];
        for(int row=0; row<rowLen; row++) {
            int rowDecrease = colLen-1;
            for (int col = 0; col<colLen; col++) {

                temp[row] = matrix[row][col];
                matrix[row][col] = matrix[rowDecrease][row];
                matrix[rowDecrease][row] = temp[row];

                rowDecrease--;
            }
        }
        for(int i=0; i< matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
