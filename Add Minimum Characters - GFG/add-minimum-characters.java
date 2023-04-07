//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
		//code here
		/* Step 1: Create a new string by concatenating the original string with its reverse 
    and separating them with a special character*/
    String concatStr = str + "#" + new StringBuilder(str).reverse().toString();

    // Step 2: Compute the LPS array of the concatenated string using the KMP algorithm
    int[] lps = computeLPS(concatStr);

    /*Step 3: The minimum number of characters to be added at the front of the 
    original string to make it a palindrome is equal to the length of the original string 
    minus the value at the last index of the LPS array*/
    return str.length() - lps[lps.length - 1];
    }

   private static int[] computeLPS(String str) {
    /*// Create an array to store the LPS values for each prefix of the string*/
    int[] lps = new int[str.length()]; 
    // Initialize pointers for traversing the string
    int i = 1, j = 0; 
    // Loop through the string
    while (i < str.length()) { 
        if (str.charAt(i) == str.charAt(j)) { // If the characters at the current positions match
            lps[i++] = ++j; // Increment i and j, and store the length of the matching prefix/suffix
        } else {
            if (j != 0) { // If there is a non-zero LPS value for the previous position of j
                j = lps[j - 1]; // Update j to the LPS value of the previous position of j
            } else {
                /* If j is 0, the current character does not match any prefix/suffix, so store 0 
                and move to the next character*/
                lps[i++] = 0; 
            }
        }
    }

    return lps; // Return the LPS array
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends