class Solution {
    public int pivotIndex(int[] arr) {
        int totalSum = 0;
        for(int num:arr){
            totalSum+=num;
        }

        int left = 0;
        for(int i=0; i<arr.length;i++){
            totalSum -=arr[i];

            if(left == totalSum){
                return i;
            }

            left +=arr[i];
        }
        return -1;
        
    }
}