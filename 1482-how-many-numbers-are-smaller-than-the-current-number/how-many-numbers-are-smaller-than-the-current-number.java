class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        /* Brute force approach
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] < nums[i]) {
                    temp++;
                }
            }
            ans[i] = temp;
        }

        return ans;*/
        int n = nums.length;
        int[] res = new int[n];
        int[] temp = new int[101];
        
        //frequency calculated
        for(int i=0; i<n; i++){
            temp[nums[i]]++;
        }

        //running sum
        for(int i=1; i<101; i++){
            temp[i]+=temp[i-1];
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
            res[i]=0;
            }

            else{
                res[i]=temp[nums[i]-1];
            }
        }

        return res;
        
    }
}