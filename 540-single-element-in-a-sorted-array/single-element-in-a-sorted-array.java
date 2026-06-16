
public class Solution {
    // Function to find the single non-duplicate element
    public int singleNonDuplicate(int[] arr) {
        // Get the size of the array
        int n = arr.length;

        // If array has only one element, return it
        if (n == 1) return arr[0];

        // Loop through the array
        for (int i = 0; i < n; i++) {

            // Check if it's the first element and not equal to the next
            if (i == 0) {
                if (arr[i] != arr[i + 1])
                    return arr[i];
            }

            // Check if it's the last element and not equal to the previous
            else if (i == n - 1) {
                if (arr[i] != arr[i - 1])
                    return arr[i];
            }

            // Check if the current element is not equal to both neighbors
            else {
                if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1])
                    return arr[i];
            }
        }

        // Dummy return if no element found
        return -1;
    }
}