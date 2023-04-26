//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int test = Integer.parseInt(in.readLine().trim());
        while(test-- > 0){
            int n = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);
            
            String _result_val = (res) ? "Yes" : "No";
            out.println(_result_val);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] arr) {
        // code here
         int prev = -10;
        int ans =0;
        if(n==0){
            return true;
        }
        if(m==1){
            
            if(arr[0] == 0){
                return true;
            }else{
                return false;
            }
            
        }
        for(int i = 0 ; i < m-1 ; i++){
            if(arr[i] == 1){
                prev = i;
            }else if(arr[i] == 0 && arr[i+1] != 1 && prev < i-1){
                ans++;
                arr[i] = 1;
                prev = i;
                if(ans == n){
                    return true;
                    
                }
            }
        }
        if(arr[m-1] == 0 && arr[m-2] == 0 ){
            arr[m-1] = 1;
            ans++;
        }
        if(ans == n){
            return true;
        }else{
            return false;
        }
    }
}
        
