class Solution {
    public int singleNumber(int[] nums) {
        long pow = 1;

        long num = 0;

        for(int b = 0; b <= 31; b++){
            int bitsum = 0;
            for(int x: nums){
                bitsum += (x & (1 << b)) != 0 ? 1: 0;
            }

            if(bitsum % 3 != 0){
                
                if(b == 31) num -= pow;
                else num += pow;
            }
            pow = pow * 2;
        }

        return (int)num;
    }
}