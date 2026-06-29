public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1. Establish the boundaries
        int low = 1;
        int high = 0;
        
        // Find the maximum pile size to set our upper boundary
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int answer = high; // Variable to store our best working speed
        
        // 2. Binary Search Loop
        while (low <= high) {
            int mid = low + (high - low) / 2; // Guess the middle speed
            
            // 3. Test the middle speed using your logic
            if (canEatAll(piles, h, mid)) {
                answer = mid;       // This speed works! Save it.
                high = mid - 1;     // Try to find a slower speed in the left half
            } else {
                low = mid + 1;      // Too slow! Look for faster speeds in the right half
            }
        }
        
        return answer; // Return the absolute minimum working speed found
    }
    
    // Your exact logic to calculate hours and check if it fits under h
    private boolean canEatAll(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + k - 1) / k; // Rounding up division
        }
        return totalHours <= h;
    }
}
