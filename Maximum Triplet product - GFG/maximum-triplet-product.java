//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class pair{

    long max,min;

    pair(){

        this.max=1;

        this.min=1;

    }

}

class Solution {

    Long maxTripletProduct(Long arr[], int n)

    {

        if(n==3)return (arr[0]*arr[1]*arr[2]);

        int z=0;

        int neg=0;

        for(int i=0; i<n; i++){

            if(arr[i]==0)z++;

            if(arr[i]<0)neg++;

        }if(neg+z==n && z>0)return 0l;

        if(neg+z==n){

            Arrays.sort(arr);

            long x=arr[n-1]*arr[n-2]*arr[n-3];

            return x;

        }

        

        // Initialize DP

        pair prev[]=new pair[4];

        for(int ind=0; ind<4; ind++)prev[ind]=new pair();

        

        for(int ind=n-1; ind>=0; ind--){

            pair curr[]=new pair[4];

            curr[3]=new pair();

            for(int count=2; count>=0; count--){

                pair x=new pair();

                pair tc=prev[count+1];

                pair ntc=prev[count];

                x.max=Math.max(Math.max(tc.max*arr[ind],tc.min*arr[ind]),ntc.max);

                x.min=Math.min(Math.min(tc.min*arr[ind],tc.max*arr[ind]),ntc.min);

                curr[count]=x;

            }prev=curr;

        }

       return prev[0].max;

    }

    

}



//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends