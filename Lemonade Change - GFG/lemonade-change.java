//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        int cO5 = 0; // count of 5 dollar bills
        int cO10 = 0;
        for(int i=0;i<N;i++){
            //int calc  = Math.abs(5-bills[i]);
            if(bills[i] != 5){
                if(bills[i] == 10){
                    cO10++;
                    if(cO5 == 0)
                    return false;
                    else{
                        cO5--;
                    }
                }
                else{  // when bill is 20 $
                    if((cO10>=1 && cO5>=1)){
                        cO10--;
                        cO5--;
                    }
                    else if(cO5>=3){
                        cO5 -= 3;
                    }
                    else return false;
                }
            }
            else{
                cO5++;
            }
        }
        return true;
    }
}
