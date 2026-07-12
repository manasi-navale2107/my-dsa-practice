class Solution {
    public int dominantIndex(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int index = -1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>first){
                second = first;
                first = arr[i];
                index = i;
            }
            else if(arr[i] > second && arr[i] != first){
                second = arr[i];
            }
        }

        if(first >= 2*second){
            return index;
        }

        return -1;
        
    }
}