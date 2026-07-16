class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> position = new ArrayList<>();

        for(int i=0; i<nums.length;i++){
            if(nums[i] == x){
                position.add(i);
            }
        }

        int[] answer = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int occurenceIndex = queries[i] - 1;

            if(occurenceIndex < position.size()){
                answer[i] = position.get(occurenceIndex);
            }else{
                answer[i] = -1;
            }
        }

        return answer;
        
    }
}