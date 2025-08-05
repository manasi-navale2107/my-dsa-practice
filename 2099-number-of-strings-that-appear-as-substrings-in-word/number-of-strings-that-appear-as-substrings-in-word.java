class Solution {
    public int numOfStrings(String[] patterns, String word) {
         int count=0;
        for(String Pattern: patterns){
            if(word.contains(Pattern)){
                count++;
            }
        }

        return count;
        
    }
}