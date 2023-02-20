class Solution {
    public String longestPalindrome(String s) {
        int max=0;
        String sub = String.valueOf(s.charAt(0));
        
        for(int i=0; i<s.length()-1; i++){
            for(int j=i+1; j<s.length(); j++){
                if(j-i < max){
                    continue;
                }
                if(isPalindrome(s, i, j)){
                    int length = j-i;
                    if(length > max){
                        max=length;
                        sub = s.substring(i, j+1);
                    }
                }
            }
        }
        return sub;
    }


        boolean isPalindrome(String s, int left, int right){
            while(left < right){
                if(s.charAt(left) == s.charAt(right)){
                    left++;
                    right--;
                }
                else{
                    return false;
                }
            }
            return true;
    }
}