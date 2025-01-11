class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        // Prefix Sum
        long[] candiesCountPrefixSum = new long[candiesCount.length];
        candiesCountPrefixSum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            candiesCountPrefixSum[i] = candiesCountPrefixSum[i-1] + candiesCount[i];
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int favType = queries[i][0];
            long favDay = queries[i][1];
            long dailyCap = queries[i][2];

            long candiesToBeEatenBefore = (favType == 0) ? 0 : candiesCountPrefixSum[favType - 1];

            // Candies before the fav candies are more, so fav candies don't even get a chance to be eaten at our fav day.
            if (candiesToBeEatenBefore >= (favDay + 1) * dailyCap) { 
                ans[i] = false;
            } 

            // Candies are less, so all the fav candies are consumed before the fav day.
            else if (candiesCountPrefixSum[favType] < favDay + 1) { 
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }
        return ans;
    }
}
