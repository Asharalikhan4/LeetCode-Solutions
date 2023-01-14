class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        // we check whether it's sorted in ascending order or descending order.
        boolean isAsc = nums[start] < nums[end];
        while(start <= end){
            int mid = start + ( end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target > nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}