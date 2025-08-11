class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
        
    }
}

/*class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0; // empty needle → index 0

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // mismatch, move to next position
                }
            }
            if (j == m) return i; // found full match
        }
        return -1; // not found
    }
}
*/