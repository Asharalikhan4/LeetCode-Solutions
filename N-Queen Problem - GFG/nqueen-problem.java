//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int board[][];
    static int N;
    static ArrayList<ArrayList<Integer>>result;
    static void createSolution(){
        //Save the current board state in a 1D ArrayList.
        ArrayList<Integer>temp=new ArrayList<>();
        for(int i=0;i<N;i++){//fixate columns
            for(int j=0;j<N;j++){
                if(board[j][i]==1){
                    temp.add(j+1);
                }
            }
        }
        result.add(temp);
    }
    static boolean isSafe(int row,int col){
        int i,j;
        for(i=0;i<col;i++){//columns->fixate row, increase columns(if none of the columns in the current row has previously seen a queen)
            if(board[row][i]==1)
                return false;
        }
        for(i=row,j=col;i>=0&&j>=0;i--,j--){//upper left diagonal->decrease both rows and columns
            if(board[i][j]==1)
                return false;
        }
        for(i=row,j=col;i<N&&j>=0;i++,j--){//lower left diagonal->decrease columns increase rows
            if(board[i][j]==1)
                return false;
        }
        return true;
    }
    static void recurse(int col){
        if(col>=N){
            createSolution();
            return;
        }
        for(int i=0;i<N;i++){//change rows 
            if(isSafe(i,col)){
                board[i][col]=1;
                recurse(col+1);//change columns
                board[i][col]=0;//because we need all the solutions.
            }
        }
    }
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        board=new int[n][n];
        N=n;
        result=new ArrayList<>();
        recurse(0);//starting from column number 0.
        return result;
    }
    
}