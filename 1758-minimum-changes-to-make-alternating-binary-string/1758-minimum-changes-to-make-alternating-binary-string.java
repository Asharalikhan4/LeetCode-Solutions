class Solution {
    public int minOperations(String s) {
        int f1 = 1, f0 = 0, cnt1 = 0, cnt2 = 0;
    for (int i = 0; i < s.length(); ++i) {
        cnt1 += s.charAt(i) - '0' != f1 ? 1 : 0;
        cnt2 += s.charAt(i) - '0' != f0 ? 1 : 0;
        f1 = f1 == 1 ? 0 : 1;
        f0 = f0 == 1 ? 0 : 1;
    }
    return Math.min(cnt1, cnt2);
    }
}