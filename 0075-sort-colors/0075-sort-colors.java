class Solution {
    public void sortColors(int[] arr) {
        int start = 0, mid = 0, end = arr.length-1;
        while(mid <= end){
            if(arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[start];
                arr[start] = temp;
                mid++;
                start++;
            } else if(arr[mid] == 1){
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[end];
                arr[end] = temp;
                end--;
            }
        }
    }
}