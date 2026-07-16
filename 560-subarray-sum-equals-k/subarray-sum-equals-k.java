class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,1);

        int count = 0;
        int prefixSum = 0;

        for(int num: nums){
            prefixSum +=num;

            int requiredSum = prefixSum - k;

            if(map.containsKey(requiredSum)){
                count += map.get(requiredSum);
            }

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }

        return count;
        
    }
}