class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0;
        int windowSum = 0;
        int minimumSize = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            while (windowSum >= target) {
                minimumSize = Math.min(minimumSize, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++; 
            }
        }

        return minimumSize == Integer.MAX_VALUE ? 0 : minimumSize;
    }
}
