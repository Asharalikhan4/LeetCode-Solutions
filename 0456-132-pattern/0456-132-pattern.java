class Solution {
    public boolean find132pattern(int[] nums) {
        int secondNum = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack();
        int n = nums.length;
        for(int i = n-1; i>=0; i--){
            if (nums[i]< secondNum)
                return true;
            while(!stack.isEmpty() && nums[i]>stack.peek())
                secondNum=Math.max(secondNum, stack.pop());
            stack.push(nums[i]);
        }
        return false; 
    }
}