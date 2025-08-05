class Solution {
    public String restoreString(String s, int[] indices) {
       char[] target = new char[s.length()];  

        for (int i = 0; i < indices.length; i++) {
            target[indices[i]] = s.charAt(i);  
        }

        return new String(target);
    }
}