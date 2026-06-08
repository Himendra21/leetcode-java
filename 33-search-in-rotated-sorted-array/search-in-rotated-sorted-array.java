class Solution {
    // Function to search target in rotated sorted array using brute force
    public int search(int[] nums, int target) {

        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {

            // If current element matches target, return index
            if (nums[i] == target) {
                return i;
            }
        }

        // If not found, return -1
        return -1;
    }
}
