class Solution {
    public int minimizeArrayValue(int[] nums) {
        int left = 0;
        int right = Arrays.stream(nums).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;

            long sum = 0;

            for (int x : nums) {
                if (x <= mid) {
                    sum += mid - x;
                } else {
                    sum -= x - mid;
                    if (sum < 0) {
                        break;
                    }
                }
            }

            if (sum >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}