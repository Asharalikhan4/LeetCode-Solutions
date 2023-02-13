//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution

{

    //Function to find the smallest window in the string s consisting

    //of all the characters of string p.

    public static String smallestWindow(String s, String p){

      

     if(s.length() < p.length()) return "-1";

      

   HashMap<Character, Integer> patternmap =new HashMap<Character, Integer>(); 

   

   char arr[] = s.toCharArray(); String result = "";

   

   int patternlength = p.length(); int minwindowlength = s.length(); int have = 0;

      

      for(char ele : p.toCharArray()) patternmap.put(ele, patternmap.getOrDefault(ele,0)+1);

   

  int windowstart = 0;

  

   HashMap<Character, Integer> smap =new HashMap<Character, Integer>(); 

   

  for(int windowend = 0; windowend < s.length(); windowend++){

      

      char ch = arr[windowend]; smap.put(ch,smap.getOrDefault(ch,0)+1);

      

      if(patternmap.containsKey(ch) && smap.get(ch) <= patternmap.get(ch)) have++;

      

      while(have == patternlength){

          

             if(minwindowlength > windowend -windowstart +1){

                 

                    minwindowlength = windowend -windowstart +1;

                    

                    result = s.substring(windowstart , windowend+1);

             }

             

             char chartoremove = arr[windowstart];

             

             if(smap.get(chartoremove) == 1) smap.remove(chartoremove);

             

             else smap.put(chartoremove,smap.get(chartoremove)-1); 

             

             windowstart++;

             

    if(patternmap.containsKey(chartoremove) 

     && smap.getOrDefault(chartoremove,0) < patternmap.get(chartoremove)) have--;         

      }

  }

      return (result.length() == 0) ? "-1" : result;

    }

}