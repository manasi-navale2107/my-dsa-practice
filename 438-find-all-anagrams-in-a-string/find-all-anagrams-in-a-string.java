class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length())
            return ans;

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // Frequency of pattern
        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        int window = p.length();

        for (int i = 0; i < s.length(); i++) {

            // Add current character
            sCount[s.charAt(i) - 'a']++;

            // Remove left character if window exceeded
            if (i >= window) {
                sCount[s.charAt(i - window) - 'a']--;
            }

            // Compare frequencies
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i - window + 1);
            }
        }

        return ans;
    }
}