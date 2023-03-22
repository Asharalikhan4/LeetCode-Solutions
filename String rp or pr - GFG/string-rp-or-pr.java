//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S) {

    // get the length of input string S
    int l = S.length();
    // substrings that can be removed to earn amounts X and Y
    String str1 = "pr", str2 = "rp";
    // if Y is greater than X, we swap the substrings str1 and str2 and the amounts X and Y
    if (Y > X) {
        str1 = "rp";
        str2 = "pr";
        int temp = X;
        X = Y;
        Y = temp;
    }
    // While substring str1 is found in S, remove it using replaceAll() method
    while (S.indexOf(str1) != -1) {
        S = S.replaceAll(str1, "");
    }
    
    /*Calculate the number of times str1 was removed by subtracting the length of S 
    after removal of str1 from the original length of S, and divide by 2*/
    long x = (l - S.length()) / 2;
    // Update length of S after removal of str1
    l = S.length();
    // While substring str2 is found in S, remove it using replaceAll() method
    while (S.indexOf(str2) != -1) {
        S = S.replaceAll(str2, "");
    }
    /*Calculate the number of times str1 was removed by subtracting the length of S 
    after removal of str1 from the original length of S, and divide by 2*/
    long y = (l - S.length()) / 2;
    // return the total amount earned by removing str1 and str2 substrings respectively
    return x * X + y * Y;
    
}
} 
