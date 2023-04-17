class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res=new ArrayList<>();
     int max=0;
     for(int i=0;i<candies.length;i++){
         max=Math.max(max,candies[i]);
     }
      for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }   
     return res; 
    }
}