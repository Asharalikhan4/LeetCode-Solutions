class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int right = 0;
        while(right < len/2){
            String subStr = s.substring(0, right+1);
            int subStrLen = subStr.length();
            if (len % subStrLen == 0){
                int count = len / subStrLen;
                if(s.equals(subStr.repeat(count)))
                    return true;
            }
            right++;
        }
        return false;
    }
}