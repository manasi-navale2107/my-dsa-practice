import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  
        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {

            
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            Set<Integer> set = new HashSet<>();

            for(int j = i + 1; j < nums.length; j++) {

                int target = -(nums[i] + nums[j]);

                if(set.contains(target)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], target);
                    Collections.sort(triplet); 
                    result.add(triplet);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}