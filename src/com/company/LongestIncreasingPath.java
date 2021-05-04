package com.company;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        List<List<Integer>> neighbors = new ArrayList();

        for(int i=0; i< matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.println("I am at matrix " + matrix[i][j]);
                neighbors =  getAllNeighbors(i, j, matrix);
                System.out.println("My Neighbors are " + neighbors);
                System.out.println("*****************");
            }
        }
        return 0;
    }

    private static List<List<Integer>> getAllNeighbors(int row, int col, int[][] matrix) {

        int max_rows = matrix.length;
        int max_col= matrix[row].length;

        List<List<Integer>> matrixList = new ArrayList();
        List<Integer> neighbors = new ArrayList();
        //Get Left neighbor
        if(col-1>=0) neighbors.add(matrix[row][col-1]);
        //Get Right neighbor
        if(col + 1 < max_col)  neighbors.add(matrix[row][col+1]);
        //Get Top Neighbor
        if(row-1>=0) neighbors.add(matrix[row-1][col]);
        //Get Bottom Neighbor
        if(row+1 < max_rows) neighbors.add(matrix[row+1][col]);

        matrixList.add(neighbors);
        return matrixList;
    }



}
