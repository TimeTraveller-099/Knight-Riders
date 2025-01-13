class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0;
        int longestLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() != (windowEnd - windowStart + 1)) {
                char leftChar = s.charAt(windowStart);
                windowStart++;
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
            }
            longestLength = Math.max(longestLength, windowEnd - windowStart + 1);
        }
        return longestLength;
    }
}
