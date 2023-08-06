//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        int maxOfKadanesSubarraySum = kadanesSubarraySum(a, n);
        int total = 0;
        
        if (maxOfKadanesSubarraySum < 0) return maxOfKadanesSubarraySum;
        
        for (int i = 0; i<n; i++) {
            total += a[i];
            a[i] = -a[i]; 
        }
        
        int minOfKadanesSubarraySum = kadanesSubarraySum(a, n);
        int max2 = total + minOfKadanesSubarraySum;
        
        return Math.max(maxOfKadanesSubarraySum, max2);
          
    }
    
    static int kadanesSubarraySum(int a[], int n) {
        int maxOfSubArray = a[0];
        int currentSum = a[0];
        
        for (int i = 1; i < n; i++) {
            
            currentSum = Math.max(currentSum + a[i], a[i]);
            maxOfSubArray = Math.max(currentSum, maxOfSubArray);
        }
        
        return maxOfSubArray;
    }
    
}

