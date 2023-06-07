//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        // code here
        int[] arr= new int[n+1];
        for(int i=1;i<=n;i++){
            
            if(i<=3) arr[i]=i;
            else if(i%2==0) arr[i]=2;
            else if(i%3==0) arr[i]=3;
            else{
                for(int j=5; j*j <= i; j=j+6){
                    
                    if(i%j==0){
                        arr[i]=j;
                        break;
                    } 
                    else if(i%(j+2)==0) {
                        arr[i]=j+2;
                        break;
                    }
                }
                if(arr[i]==0) arr[i]=i;
            }
        }
        
        return arr;
    }
}