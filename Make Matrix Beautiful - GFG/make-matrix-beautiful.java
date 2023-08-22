//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        ArrayList<Integer> arrRowSum = new ArrayList<>();
        ArrayList<Integer> arrColSum = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            int rowSum = 0;
            int colSum = 0;
            for(int j=0; j<N; j++){
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            arrRowSum.add(rowSum);
            arrColSum.add(colSum);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arrRowSum.size(); i++){
            if(arrRowSum.get(i) > max) max = arrRowSum.get(i);
            
            if(arrColSum.get(i) > max) max = arrColSum.get(i);
        }
        int count = 0;
        for(int i=0; i<N; i++){
            count += Math.abs(max-arrRowSum.get(i));
        }
        
        return count; 
    }
}
        
