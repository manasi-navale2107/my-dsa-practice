class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }


        HashSet<Integer> numset = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            numset.add(nums[i]);
        }

        int longestSub = 1;

        for(int Set : numset){
            if(numset.contains(Set -1)){
                continue;
            }else{
                int currentNum = Set;
                int currentSub = 1;
                while(numset.contains(currentNum + 1)){
                    currentNum ++;
                    currentSub++;
                }
                longestSub = Math.max(longestSub,currentSub);

            }
        }
        return longestSub++;
    }
}
