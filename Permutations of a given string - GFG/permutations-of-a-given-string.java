//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        Set<String> result = new HashSet<>();
        char[] arr = S.toCharArray();
        recur(0, arr, result);
        List<String> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult); // Sort the list lexicographically
        return sortedResult;
    }
    
    void recur(int index, char[] arr, Set<String> result) {
        if (index == arr.length) {
            result.add(String.valueOf(arr));
            return;
        }
        
        for (int i = index; i < arr.length; i++) {
            swap(i, index, arr);
            recur(index + 1, arr, result);
            swap(i, index, arr);
        }
    }
    
    void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}