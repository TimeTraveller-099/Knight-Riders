class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] countParkingPoints = new int[102];
        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            int start = nums.get(i).get(0);
            int end = nums.get(i).get(1);

            countParkingPoints[start] += 1;
            countParkingPoints[end + 1] -= 1;
        }

        for (int i = 1; i < countParkingPoints.length; i++) {
            // Prefix Sum
            countParkingPoints[i] += countParkingPoints[i-1];

            if (countParkingPoints[i] != 0) {
                count++;
            }
        }

        return count;
    }
}
