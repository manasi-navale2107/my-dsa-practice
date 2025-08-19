

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);   
        Arrays.sort(nums2);

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
           
            if (i > 0 && nums1[i] == nums1[i - 1]) continue;

            
            if (binarySearch(nums2, nums1[i])) {
                resultList.add(nums1[i]);
            }
        }

        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

   
    private boolean binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) return true;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}