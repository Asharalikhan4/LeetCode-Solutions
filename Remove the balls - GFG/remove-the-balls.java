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
            
            
            int[] color = IntArray.input(br, N);
            
            
            int[] radius = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.finLength(N, color, radius);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int finLength(int N, int[] color, int[] radius) {
        // code here
        Stack<Integer> stack = new Stack<>(); // create a stack to store ball indices
    for (int i = 0; i < N; i++) { // iterate over all balls
        if (!stack.isEmpty() && // check if the stack is not empty and
            color[i] == color[stack.peek()] && // the current ball has the same color as the top ball in the stack and
            radius[i] == radius[stack.peek()]) { // the current ball has the same radius as the top ball in the stack
            stack.pop(); // remove the top ball from the stack
        } else {
            stack.push(i); // add the current ball to the stack
        }
    }
    return stack.size(); // return the size of the remaining balls in the stack
    }
}
        
