class Solution {
    public String removeOuterParentheses(String s) {        
        StringBuilder ans = new StringBuilder();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0) ans.append(c);
            if (c == ')' && opened-- > 1) ans.append(c);
        }
        return ans.toString();
    }
}