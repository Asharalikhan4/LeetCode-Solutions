//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ob.gfSeries(N);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static void gfSeries(int N){
        // code here
        System.out.print("0"+" "+"1"+" ");
        calculateGF(0,1,N-2);
        System.out.println();
    }
    static void calculateGF(long N1,long N2,int count){
        if(count>0){
            long N = (N1*N1) - N2;
            N1 = N2;
            N2 = N;
            System.out.print(N+" ");
        }
        else if(count==0){
            return ;
        }
        calculateGF(N1,N2,count-1);
    }
}