class Solution {
    public int thirdMax(int[] nums) {
        // Use Long so we can handle Integer.MIN_VALUE safely
        Long first = null, second = null, third = null;

        for (int num : nums) {
            long n = num;

            // Skip duplicates
            if ((first != null && n == first) ||
                (second != null && n == second) ||
                (third != null && n == third)) {
                continue;
            }

            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }

        // If 3rd maximum does not exist, return maximum (first)
        return (third == null) ? first.intValue() : third.intValue();
    }
}
