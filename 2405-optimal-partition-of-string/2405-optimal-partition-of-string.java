class Solution {
    public int partitionString(String s) {
        int mask = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            int index = 1 << (s.charAt(i) - 'a');
            if((mask & index) > 0) {
                mask = 0;
                result++;
            }
            mask |= index;
        }
        return result + 1;
    }
}