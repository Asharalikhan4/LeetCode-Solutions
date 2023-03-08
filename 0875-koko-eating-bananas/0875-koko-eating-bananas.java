class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length;i++)   hi = Math.max(hi, piles[i]);
        while(lo < hi)
        {
            int mid = lo + (hi - lo) / 2;
            if(canEatBananas(piles, mid, h)) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }
    boolean canEatBananas(int[] piles, int mid, int h)
    {
        int actualHours = 0;
        for(int bananas : piles)
        {
            int hours = bananas/ mid;  // no. of hours
                actualHours = actualHours + hours;
                if(bananas % mid != 0) actualHours++; 
        }
            return actualHours <= h;
    }
}