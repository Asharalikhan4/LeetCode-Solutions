class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int j=0;j<nums.length;j++){
           
            if(map.containsKey(target-nums[j])){
                return new int[]{map.get(target-nums[j]),j};
            }
             map.put(nums[j],j);
        }
        return new int[]{0,0};
    }
}