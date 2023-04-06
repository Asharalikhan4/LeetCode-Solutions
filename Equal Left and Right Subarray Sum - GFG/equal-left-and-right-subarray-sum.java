//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int [] A = new int[N];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++)
				A[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			System.out.println(ob.equalSum(A, N));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int equalSum(int [] A, int N) {
		//Write your code here
		if(N==1) return 1;
		int i=0,j=N-1;
		int lsum=A[i],rsum=A[j];
		while(i<=j){
		    if(i==j && lsum==rsum) {
		        return i+1;
		    }
		    else if(lsum<rsum){
		            i++;
		            lsum+=A[i];
		        }
		        else{
		            j--;
		            rsum+=A[j];
		        }
		}
		return -1;
	}
}