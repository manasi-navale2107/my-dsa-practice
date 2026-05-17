class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        boolean[] visited = new boolean[strs.length];

        for(int i=0; i<strs.length; i++){
            if(visited[i]){
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for(int j=i+1; j<strs.length; j++){
                if(!visited[j] && isAnagram(strs[i],strs[j])){
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }

            result.add(group);

        }

        return result;
    }

        public boolean isAnagram(String s, String t){

            if(s.length() != t.length()){
                return false;
            }

            char[] arr1 = s.toCharArray();
            char[] arr2 = t.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            return Arrays.equals(arr1, arr2);
            
        
    }
}