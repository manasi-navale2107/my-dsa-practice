class Solution {
    public String reverseWords(String s) {
        String[] result = s.split(" ");

        for(int i=0; i<result.length; i++){
            result[i]=new StringBuilder(result[i]).reverse().toString();
        }
        
        return String.join(" ",result);
    }
}