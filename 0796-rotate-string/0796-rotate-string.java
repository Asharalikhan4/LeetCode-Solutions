class Solution {
    public boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) {
            return false;
        }
        
        int n = s.length();
        
        // Iterate through each possible shift
        for (int shift = 0; shift < n; shift++) {
            boolean match = true;
            
            // Compare characters after shifting
            for (int i = 0; i < n; i++) {
                if (s.charAt((i + shift) % n) != goal.charAt(i)) {
                    match = false;
                    break;
                }
            }
            
            if (match) {
                return true;
            }
        }
        
        return false;
    
    }
}