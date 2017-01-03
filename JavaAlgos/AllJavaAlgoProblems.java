import java.io.*;
import java.util.*;
import java.lang.*;

public class AllJavaAlgoProblems
{
    
    // -----------------------------------------------------------------------------------
    // Problem 1.
    // Print all possilbe steps down a ladder
    // -----------------------------------------------------------------------------------
    public static void printLadderPaths(int numSteps, String path)
    {
        if (numSteps == 0)
        {
            System.out.println(path);
            return;
        }

        if (numSteps >= 1)
        {
            path  += '1';
            printLadderPaths(numSteps - 1, path);
            path = path.substring(0, path.length()-1);
        }

        if (numSteps >= 2)
        {
            path  += '2';
            printLadderPaths(numSteps - 2, path);
        }
    }

    // -----------------------------------------------------------------------------------
    // Problem 2.
    // Print matrix diagonally
    // -----------------------------------------------------------------------------------
    public static void printDiagonally(int[][] matrix)
    {
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0, k=i; j<=i; j++,k--)
            {
                if(j<0)
                {
                    break;
                }

                if (k >= 0 && k <matrix.length && j >= 0 && j < matrix[0].length)
                {
                    System.out.print(matrix[k][j] + ", ");
                }
            }

            System.out.println();
        }

        for(int j=1; j<matrix[0].length; j++)
        {
            for(int i=matrix.length-1, k=j; k<=matrix[0].length; i--,k++)
            {
                if(k>=matrix[0].length)
                {
                    break;
                }

                if (i >= 0 && i < matrix.length && k >= 0 && k < matrix[0].length)
                {
                    System.out.print(matrix[i][k] + ", ");
                }
            }

            System.out.println();
        }
    }

    // -----------------------------------------------------------------------------------
    // Problem 3.
    // Print matrix spirally
    // -----------------------------------------------------------------------------------
    public static void printMatrixSpirally(int[][] twoDMat)
    {
        int topBoundary = 0;
        int leftBoundary = 0;
        int bottomBoundary = twoDMat.length-1;
        int rightBoundary = twoDMat[0].length-1;
        
        while(topBoundary < bottomBoundary && leftBoundary < rightBoundary) {

            for(int i=leftBoundary; i<=rightBoundary; i++) {
                System.out.print(twoDMat[topBoundary][i]+" " );
            }
            System.out.println();
            topBoundary++;
            
            for(int i=topBoundary; i<=bottomBoundary; i++) {
                System.out.print(twoDMat[i][rightBoundary]+" " );
            }
            System.out.println();
            rightBoundary--;

            for(int i=rightBoundary; i>=leftBoundary; i--) {
                System.out.print(twoDMat[bottomBoundary][i]+" " );
            }
            System.out.println();
            bottomBoundary--;

            for(int i=bottomBoundary; i>=topBoundary; i--) {
                System.out.print(twoDMat[i][leftBoundary]+" " );
            }
            System.out.println();
            leftBoundary++;
        }
    }

    // -----------------------------------------------------------------------------------
    // Problem 4.
    // Given a string of 1s and 0s with '?' in between. A '?' can be either one or zero.
    // -----------------------------------------------------------------------------------
    public static void printCombinationOnesZerosRec(StringBuilder str, int stIdx, int lastQMarkPos)
    {
        if (stIdx == lastQMarkPos)
        {
            System.out.println(str);
            return;
        }

        for (int i = stIdx; i < str.length(); i++)
        {
            if (str.charAt(i) == '?')
            {
                str.setCharAt(i, '0');
                printCombinationOnesZerosRec(str, i, lastQMarkPos);

                str.setCharAt(i, '1');
                printCombinationOnesZerosRec(str, i, lastQMarkPos);
            }
        }
    }

    public static void printCombinationOnesZeros(String str)
    {
        int lastQMarkPos = str.length();
        for (int i = str.length()-1; i >=0; i--)
        {
            if (str.charAt(i) == '?')
            {
                lastQMarkPos = i;
            }
        }

        if (lastQMarkPos < str.length())
        {
            // Convert the string to string builder so that it can be changed in place
            StringBuilder strBuilder = new StringBuilder(str);

            printCombinationOnesZerosRec(strBuilder, 0, lastQMarkPos);

        }
        else
        {
            System.out.println(str);
        }
    }


    // -----------------------------------------------------------------------------------
    // Main Function
    // -----------------------------------------------------------------------------------
    public static void main(String[] args)
    {
        System.out.println("All Algo Problems");

        // Problem 1.
        // Print all steps down a ladder
        {
            System.out.println("\nProblem 1. Print All Steps down a ladder");
            String str = "";
            int [][] twoDMat = new int[5][3];
            printLadderPaths(4, str);
        }

        // Problem 2.
        // Print the matrix in diagonal order
        {
            System.out.println("\nProblem 2. Print Matrix Diagonally");
            int[][] matrix1 = {{1, 2, 3, 4, 5},
                              {6, 7, 8, 9, 10},
                              {11, 12, 13, 14, 15},
                              {16, 17, 18, 19, 20},
                              {21, 22, 23, 24, 25} };

             int[][] matrix2 = {{1, 2, 3, 4, 5},
                              {6, 7, 8, 9, 10},
                              {16, 17, 18, 19, 20} };
                
            printDiagonally(matrix2);
        }

        // Problem 3.
        // Print a matrix in Spiral order
        {
            System.out.println("\nProblem 3. Print Matrix Spirally");
            int[][] twoDMatrix = {{1, 2, 3, 4},
                                  {5, 6, 7, 8},
                                  {9, 10, 11, 12},
                                  {13, 14, 15, 16},
                                  {17, 18, 19, 20}};


            printMatrixSpirally(twoDMatrix);
        }

        // Problem 4.
        // Given a string of 1s and 0s with '?' in between. A '?' can be either one or zero.
        {
            System.out.println("\nProblem 4. Replace ? with 0s and 1s");
            String str = "0?0?1";
            printCombinationOnesZeros(str);
        }
    }
}
