//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
         int last = 1, secondLast=1, nth = 0, mod= 1000000007;
        if(n==1){
            return last;
        }else if(n==2){
            return secondLast;
        }else{
            while(n>2){
                nth = last%mod + secondLast%mod;
                last = secondLast;
                secondLast = nth;
                n--;
            }
            return nth%mod;
        }
    }
}