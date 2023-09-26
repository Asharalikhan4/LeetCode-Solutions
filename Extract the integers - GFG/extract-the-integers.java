//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            ArrayList<String> ans = ob.extractIntegerWords(s);
            if(ans.size()==0)
                System.out.println("No Integers");
            else{
                for(int i=0;i<ans.size();i++)
                    System.out.print(ans.get(i)+" ");
                System.out.println();
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    ArrayList<String> extractIntegerWords(String s) 
    { 
        // code here
        ArrayList <String> ans = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                currentNumber.append(c);
            } else if(currentNumber.length() > 0){
                ans.add(currentNumber.toString());
                currentNumber.setLength(0); // this will reset the string builder.
            }
        }
        if(currentNumber.length() > 0){
            ans.add(currentNumber.toString());
        }
        return ans;
    }
} 