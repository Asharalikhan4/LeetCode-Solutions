//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    
    public static boolean isOptr(char c){
        if(c =='+' ||c == '-' || c == '*' || c == '/' || c == '^'){
            return true;
        }
        return false; 
    }
    
    public static int  precedence(char c){
        if(c == '+' || c == '-'){return 1;}
        else if(c == '*' || c == '/'){return 2;}
        return 3;
    }
    
    
    
    public static String infixToPostfix(String s) {
        
        Stack<String>oprd = new Stack<>();
        Stack<Character>optr = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                optr.push('(');
            }
            
            else if((s.charAt(i)>='0' &&s.charAt(i)<='9') || (s.charAt(i) >='A' && s.charAt(i) <='Z') || (s.charAt(i) >='a' && s.charAt(i) <='z' )){
                oprd.push(s.charAt(i)+""); 
            }
            
            else if(s.charAt(i) == ')'){
                while(optr.peek() != '('){  
                    char op = optr.pop();
                    String s2 = oprd.pop();
                    String s1 = oprd.pop();
                    oprd.push(s1+s2+op);
                }
                optr.pop();
            }
            
            else if(isOptr(s.charAt(i))){
                while(optr.size() != 0 && optr.peek() != '(' && precedence(optr.peek()) >= precedence(s.charAt(i))){
                       
                    char op = optr.pop();
                    String s2 = oprd.pop();
                    String s1 = oprd.pop();
                    oprd.push(s1+s2+op);
                        
                }
                optr.push(s.charAt(i));
            }
            
            
            
            
        }
        while(optr.size()!=0){
                    char op = optr.pop();
                    String s2 = oprd.pop();
                    String s1 = oprd.pop();
                    oprd.push(s1+s2+op);
            }
        return oprd.pop();
    }
}