class Solution {
    public int maxSubArray(int[] numbers) {
        int currentSum =0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<numbers.length; i++){
            currentSum += numbers[i];
            maxSum = Math.max(maxSum, currentSum);

            if(currentSum <0){
                currentSum = 0;
            }
        }
       return maxSum; 
    }

}