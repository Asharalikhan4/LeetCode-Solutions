//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    
    void func(int ind, int sum, ArrayList<Integer> arr,int N, ArrayList<Integer> sumSubset){
        if(ind == N){
            sumSubset.add(sum);
            return;
        }
        
        // Pick the element
        func(ind + 1, sum + arr.get(ind), arr, N, sumSubset);
        
        // Do not pick the element
        func(ind + 1, sum, arr, N, sumSubset);
    }
    
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> sumSubset = new ArrayList<Integer>();
        func(0,0,arr,N,sumSubset);
        return sumSubset;
    }
}