/*class Solution {
    public String freqAlphabets(String s) {
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2)); 
                result.append((char) ('a' + num - 1)); 
                i += 3; 
            } else {
                int num = s.charAt(i) - '0';
                result.append((char) ('a' + num - 1));  
                i++;
            }
        }
        
        return result.toString();
    }
}*/

class Solution {
    public String freqAlphabets(String s) {
        return decode(s, 0);
    }

    private String decode(String s, int i) {
        if (i >= s.length()) return "";

        if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
            int num = Integer.parseInt(s.substring(i, i + 2));
            char letter = (char) ('a' + num - 1);
            return letter + decode(s, i + 3);
        } else {
            int num = s.charAt(i) - '0';
            char letter = (char) ('a' + num - 1);
            return letter + decode(s, i + 1);
        }
    }
}

        
  