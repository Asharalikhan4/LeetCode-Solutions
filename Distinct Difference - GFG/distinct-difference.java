//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
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
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getDistinctDifference(N, A);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        // code here
        // Initialize an empty ArrayList to store the results
    ArrayList<Integer> ans = new ArrayList<>();
    
    /*Initialize an empty HashSet to store the distinct elements on the right 
    side of each index */
    Set<Integer> rightSet = new HashSet<>();
    
    /*Initialize integer array used to store the number of distinct elements on 
    the right side of each index*/
    int[] distSize = new int[N];
    
    // Calculate the number of distinct elements on the right side of each index
    for (int i = N-1; i >= 0; i--) {
        distSize[i] = rightSet.size();
        rightSet.add(A[i]);
    }
    
    /* Initialize an empty HashSet to store the distinct elements on the left side of 
    each index*/
    Set<Integer> leftSet = new HashSet<>();
    
    /* Calculate the difference in the number of distinct elements on the left 
    and right sides of each index */
    for (int i = 0; i < N; i++) {
        int diff = leftSet.size() - distSize[i];
        leftSet.add(A[i]);
        ans.add(diff);
    }
    
    // Return the ArrayList containing the results
    return ans;
    }
}
        
