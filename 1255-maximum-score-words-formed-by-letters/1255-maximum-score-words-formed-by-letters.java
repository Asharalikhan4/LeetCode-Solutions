class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // Combinations: 2^14
        // See if combo is possibe, game the system?
        int[] charfreq = new int['z' - 'a' + 1];
        
        for(int i = 0; i < letters.length; i++) {
            charfreq[letters[i] - 'a']++;
        }
        
        int[][] wordcharfreq = new int[words.length]['z' - 'a' + 1];
        
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                wordcharfreq[i][words[i].charAt(j) - 'a']++;
            }
        }
        
        int n = 0;
        int maxsofar = 0;
        while(n < Math.pow(2, words.length)) {
            //System.out.println(n);
            int[] charfreq2 = new int['z' - 'a' + 1];
            StringBuilder conv2 = new StringBuilder(Integer.toBinaryString(n));
            
            while(conv2.length() < words.length) {
                conv2.insert(0, 0);
            }
            String conv = conv2.toString();
            
            for(int i = 0; i < wordcharfreq.length; i++) {            
                if(conv.charAt(i) == '1') {
                    for(int j = 0; j < wordcharfreq[0].length; j++) {
                        charfreq2[j] += wordcharfreq[i][j];
                    }
                }
            }
            
            int total = 0;
            boolean flag = false;
            for(int i = 0; i < charfreq2.length; i++) {
                if(charfreq2[i] > charfreq[i]) {
                    flag = true;
                }
                total += charfreq2[i]*score[i];
            }
            
            if(!flag) {
                maxsofar = Math.max(maxsofar, total);
            }
            
            n++;
        }
        return maxsofar;
    }
}