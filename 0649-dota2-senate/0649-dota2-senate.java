class Solution {
    public String predictPartyVictory(String senate) {
      Queue<Integer> radi=new LinkedList<>();
      Queue<Integer> dire=new LinkedList<>();
      int n = senate.length();
      for(int i=0;i<senate.length();i++){
          if(senate.charAt(i)=='R') radi.add(i);
          else dire.add(i);
      }
         for(;!radi.isEmpty() && !dire.isEmpty();){
            int r_i = radi.poll();
            int d_i = dire.poll();
            if(r_i < d_i) radi.add(r_i + n);
            else dire.add(d_i + n);
        }
        return radi.size() > dire.size() ? "Radiant" : "Dire";
    }
}