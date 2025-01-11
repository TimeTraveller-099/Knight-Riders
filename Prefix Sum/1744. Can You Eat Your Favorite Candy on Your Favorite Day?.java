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

            // Case 1
            // if (Candies to be eaten before >= Maximum Candies that I can eat, 
            // including the candies eaten on my fav day)
            // Because if candiesToBeEatenBefore < than the max candies that I can eat, 
            // then I can obviously eat my fav candy because there is still some candy 
            // capacity left to be filled in my fav day.
            if (candiesToBeEatenBefore >= (favDay + 1) * dailyCap) { 
                ans[i] = false;
            } 

            // Case 2
            // Check if all candies of the favorite type would have been consumed before the given day
            else if (candiesCountPrefixSum[favType] < favDay + 1) { 
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }
        return ans;
    }
}
