//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int [] arr = new int[N];
			String [] str = br.readLine().trim().split(" ");
			for(int i= 0; i < N; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution obj = new Solution();
			System.out.println(obj.no_of_subarrays(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	long no_of_subarrays(int N, int [] arr) {
		//Write your code here
		long ans=0;
	    
	    int count=0,i=0;
	    while(i<arr.length){
	        if(arr[i]==0){
	            count++;
	            i++;
	        }else{
	            if(count>0){
	                long a=fibo(count);
	                ans+=a;
	            }
	            count=0;
	            i++;
	        }
	    }
	    if(count>0){
	        long a=fibo(count);
	        ans+=a;
	    }
	    return ans;
	}
	private long fibo(int start){
	   long r=1;
	   for(int i=2;i<=start;i++){
	       r+=i;
	   }
	   return r;
	}
}