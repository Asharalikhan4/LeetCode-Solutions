//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    static boolean isPossible(int [][] board,int row,int col, int dig){
        for(int i=0;i<9;i++){
            //check in row
            if(board[row][i]==dig)return false;
            //check in col
            else if(board[i][col]==dig)return false;
            //check in box
            //get details of origin of box 
            int ogrow = (row/3)*3,ogcol = (col/3)*3;
            if(board[ogrow+i/3][ogcol+i%3]==dig)return false;
        }
        return true;
    }
    static boolean SolveSudoku(int grid[][])
    {
        //iterate the loop and find the empty block
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                //empty block is represented by 0
                if(grid[i][j]==0){
                    //fill this block with 1 to 9 digit
                    for(int digit =1;digit<=9;digit++){
                        //if it is possible to fill
                        if(isPossible(grid,i,j,digit)){
                            //fill this block
                            grid[i][j]= digit;
                            //after filling this block is it valid
                            if(SolveSudoku(grid))return true;
                            //if not then remove
                            else grid[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static void printGrid (int grid[][])
    {
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}