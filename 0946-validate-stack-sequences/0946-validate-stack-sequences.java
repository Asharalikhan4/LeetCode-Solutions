class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length) return false;
     int j=0;
     Stack<Integer> st=new Stack<Integer>();
     for(int i=0;i<pushed.length;i++){
         st.push(pushed[i]);
         while(!st.isEmpty() && st.peek() == popped[j]){
             st.pop();
             j++;
         }  
     }
    return st.isEmpty();
    }
}