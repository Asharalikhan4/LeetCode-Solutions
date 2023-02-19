class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
        return false;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Arrays.sort(hand);
        for(int card:hand){
            if(map.containsKey(card)){
                for(int i=0;i<groupSize;i++){
                    if(map.containsKey(card+i)){
                        map.put(card+i,map.get(card+i)-1);
                        if(map.get(card+i)==0)
                        map.remove(card+i);
                    }
                    else
                    return false;
                }
            }
        }
        return true;
    }
}