class Solution {

    boolean canMake(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int bouquets = 0;

        for (int flower : bloomDay) {

            if (flower <= day) {
                count++;

                if (count == k) {
                    bouquets++;
                    count = 0;
                }

            } else {
                count = 0;
            }
        }

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = bloomDay[0];
        int high = bloomDay[0];

        for (int day : bloomDay) {
            if (day < low) {
                low = day;
            }

            if (day > high) {
                high = day;
            }
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}