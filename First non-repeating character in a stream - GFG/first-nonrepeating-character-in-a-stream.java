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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        char ch[] = A.toCharArray();
	    int len=A.length();
	    
	    //using List as order of characters is required. If there are many characters that have appeared only once, you have to tell which one of them was the first one to appear.
          //uniAlpha will store the alphabets which are present uniquely in the input
          //allAlpha will store the alphabets which are present uniquely in the input
        List<Character> uniAlpha = new ArrayList<>();
        List<Character> allAlpha = new ArrayList<>();
        
        uniAlpha.add(ch[0]);
        allAlpha.add(ch[0]);
        
        
        for(int i=1; i<len; i++){
            
            //if the character is scanned previously
            if(allAlpha.contains(ch[i])){
                
                //Important: read the NOTE at line 53.
                Character c = ch[i];
                
                //remove the character from unique character list
                uniAlpha.remove(c);
                /*
                NOTE:
                uniAlpha.remove(ch[i]); won't run/give the necessary input.
                remove() is overloaded where in one it accepts an int and removes the element present at the specified index. 
                Secondly, it accepts an Object paramter and deletes the first occurance from the list.
                when we pass char, internally it gets converted to int and tries to delete the correcponding element. For eg, if 'a' is passed, it will get converted to 97 (Ascii) and will try to delete the element present at 97 index (which will throw ArrayIndexOutOfBoundExcpetion).
                Therefore, it needs to explicitly stored in a Character type variable and pass it to remove() method.
                */
            }
            
            //else store the character in both unique and all character list
            else{
                uniAlpha.add(ch[i]);
                allAlpha.add(ch[i]);
            }
            
            //if unique character list is NOT empty, then print the first unique character from the list.
            if(!uniAlpha.isEmpty())
                ch[i]=uniAlpha.get(0);
            
            //else print '#' for the corresponding element
            else
                ch[i]='#';
        }
        
        //converting the character array back to String
        A=A.valueOf(ch);
	    return A;
    }
}