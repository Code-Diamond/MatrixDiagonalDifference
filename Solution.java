import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) 
    {
        //Create a scanner object for receiveMatrix function
    	Scanner scan = new Scanner(System.in);
        System.out.print("Enter the value denoting the number of rows and columns in the matrix (N X N)\nN: ");
        //n refers to dimension of matrix
        int n = scan.nextInt();
        System.out.println("\nNext, enter each line of the matrix seperating values with spaces..\n"
        		+ "\nFor example:"
        		+ "\nN: 3\n"
        		+ "\n1 2 3"
        		+ "\n4 5 6"
        		+ "\n7 8 9\n"
        		+ "\nIs a valid matrix returning a diagonal difference of \"0\".\n\nMatrix:\n");
        
        //Create a 2d list of integers for the matrix
        List<List<Integer>> matrixRows = receiveMatrix(n, scan);
        
        //Create first result value
        int firstDiagonalSum = 0;
        
        //calculate first diagonal sum
        for(int i = 0; i<n; i++)
        {
            firstDiagonalSum += matrixRows.get(i).get(i);
        }
        //Create second result value
        int secondDiagonalSum = 0;
        int startAtTop = 0;
        for(int j = (n-1); j>-1; j--)
        {
            secondDiagonalSum += matrixRows.get(startAtTop).get(j);
            startAtTop++;
        }
        
        //Determine abs difference
        int absoluteDifference = Math.abs(firstDiagonalSum - secondDiagonalSum);

        //Print out the matrix's diagonal difference
        System.out.println(absoluteDifference);
    }
    
    //Creates a 2d list of integers for a matrix
    public static List<List<Integer>> receiveMatrix(int n, Scanner scan)
    {
        List<List<Integer>> matrixRows = new ArrayList<List<Integer>>();      
        int nextInt;
        for(int i = 0; i<n; i++)
        {
            List<Integer> row = new ArrayList<Integer>(); 
            for(int j = 0; j<n; j++)
            {
                nextInt = scan.nextInt();
                row.add(nextInt);
            }
            matrixRows.add(row);
        }       
        
        return matrixRows;
    }
}