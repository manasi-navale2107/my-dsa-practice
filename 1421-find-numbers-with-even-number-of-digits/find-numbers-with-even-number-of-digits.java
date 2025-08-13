class Solution {
    public int findNumbers(int[] nums) {

        int count=0;

        for(int num:nums){
            int numofdigits=(int) Math.log10(num)+1;

            if(numofdigits %2 == 0){
                count++;
            }
        }

        return count;
        
    }
}

