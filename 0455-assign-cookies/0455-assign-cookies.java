class Solution {
    public int findContentChildren(int[] g, int[] s) {
         Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, i = 0, j = 0, m = g.length, n = s.length;
        while (i < m && j < n) {
            if (g[i] > s[j]) j++;  // find next larger cookie
            else {  // assign the min content to the min cookie;
                res++;
                i++;
                j++;
            }
        }
        return res;
    }
}