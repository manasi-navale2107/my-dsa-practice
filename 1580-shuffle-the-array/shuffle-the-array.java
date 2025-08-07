class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[i + n] += nums[i] * 10000; // Use 10000 for safety
        }

        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i + n] / 10000;    // x_i
            result[2 * i + 1] = nums[i + n] % 10000; // y_i
        }

        return result;
    }
}