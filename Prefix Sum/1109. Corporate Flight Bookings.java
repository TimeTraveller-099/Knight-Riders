class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int[] bookedFlightsSeatsCount = new int[n + 1];

        // Setting total no. of bookings in each flight
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];

            bookedFlightsSeatsCount[first - 1] += seats;
            bookedFlightsSeatsCount[last] -= seats;
        }

        // Prefix Sum
        for (int i = 0; i < n; i++) {
            bookedFlightsSeatsCount[i + 1] += bookedFlightsSeatsCount[i];
            ans[i] = bookedFlightsSeatsCount[i];
        }
        return ans;
    }
}
