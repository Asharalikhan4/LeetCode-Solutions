//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        double [] my = new double[n+m];
        int k =0;
        int i =0;
        int j = 0;
        while(i<n && j<m){
            if(a[i]<=b[j]){
                    my[k] = a[i];
                    i++;
                    k++;
                }
                else{
                    my[k]=b[j];
                    j++;
                    k++;
            }
        }
        while(i<n){
            my[k] = a[i];
                    i++;
                    k++;
        }
        while(j<m){
            my[k]=b[j];
                    j++;
                    k++;
        }
        int x = my.length;
        
            if(x%2==0){
                return (my[x/2 -1] + my[x/2]) /2 ;
            }
            else{
                return my[x/2];
            }
    }
}