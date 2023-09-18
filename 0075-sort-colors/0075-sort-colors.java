class Solution {
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length-1;
        while(mid <= end){
            if(nums[mid] == 0){
                int temp = nums[start];
                nums[start] = nums[mid];
                nums[mid] = temp;
                mid++;
                start++;
            } else if(nums[mid] == 1){
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            }
        }
    }
}