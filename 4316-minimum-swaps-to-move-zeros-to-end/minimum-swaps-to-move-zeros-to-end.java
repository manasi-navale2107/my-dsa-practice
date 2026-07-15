class Solution {
    public int minimumSwaps(int[] nums) {

        int zero = 0;
        for(int num:nums){
            if(num == 0){
                zero++;
            }
        }

        int swap = 0;
        int nonZero = nums.length - zero;

        for(int i=0; i<nonZero; i++){
            if(nums[i] == 0){
                swap++;
            }
        }

        return swap;
        
    }
}