//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int N, String S, int X) 
    { 
        // code here
        int st = 0;
        while (st < N && S.charAt(st) != '1') {
            st += 1;
        }
        if (st == N || st > X) {
            return false;
        }
        int last = st;
        for (int i = st; i < N; i++) {
            if (i - last + 1 > 2 * (X + 1)) {
                //System.out.println(last + " and " + i);
                return false;
            }
            if (S.charAt(i) == '1') {
                last = i;
            }
        }
        if (N - last > X + 1) {
            return false;
        }
        return true;
    }
} 