class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {        
        int windowStart = 0;
        int windowSum = 0;
        int count = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k-1) {
                if ((windowSum / k) >= threshold) {
                    count++;
                }
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return count;
    }
}
