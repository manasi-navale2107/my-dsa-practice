class Solution {
    public boolean halvesAreAlike(String s) {
       /* int n = s.length();
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2);

        return countVowels(a) == countVowels(b);
    }

    private int countVowels(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1; */

        int count = 0;
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) count++;
            if (isVowel(s.charAt(i + n / 2))) count--;
        }
        return count == 0;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}

 

        
  