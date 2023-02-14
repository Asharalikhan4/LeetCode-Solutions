class Solution {
    public int beautySum(String s) {
        int result = 0;
        int[] frequencies = new int[26];
        for(int i=0;i<s.length();i++) {
            frequencies[s.charAt(i)-'a']++;
            result += helper(frequencies);
        }
        if(s.length()>1) result += beautySum(s.substring(1));
        return result;
    }
    private int helper(int[] frequencies) {
        int max =0, min =Integer.MAX_VALUE;
        for(int i=0;i<26;i++) {
            max = Math.max(max, frequencies[i]);
            if(frequencies[i]!=0) min = Math.min(min, frequencies[i]);
        }
        return max - min;
    }
}