//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            
            String inputLine1[] = br.readLine().trim().split(" "); 
            int i=0;
            int N = Integer.parseInt(inputLine1[i++]);
            int leaves = Integer.parseInt(inputLine1[i++]);
            
            int frogs[] = new int[(int)(N)];
            
            String inputLine2[] = br.readLine().trim().split(" ");
            for ( i = 0; i < N; i++) {
                frogs[i] = Integer.parseInt(inputLine2[i]);
            }
        
            Solution ob = new Solution();
            System.out.println(ob.unvisitedLeaves(N, leaves, frogs));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        BitSet visited = new BitSet(leaves + 1);

    // Loop through the frogs array
    for (int frog : frogs) {
        // If the frog is within the range of leaves and has not been visited yet
        if (frog <= leaves && !visited.get(frog)) {
            // Loop through every multiple of the frog and mark it as visited
            for (int j = frog; j <= leaves; j += frog) {
                visited.set(j);
            }
        }
    }

    // Count the number of unvisited leaves
    int unvisited = leaves- visited.cardinality();
   
    // Return the number of unvisited leaves
    return unvisited;
    }
}
