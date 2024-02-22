/**
 Do not return anything, modify nums in-place instead.
 */
function sortColors(arr: number[]): void {
    let start: number = 0, mid: number = 0, end: number = arr.length - 1;
    while (mid <= end) {
        if(arr[mid] == 0){
            let temp = arr[mid];
            arr[mid] = arr[start];
            arr[start] = temp;
            mid++;
            start++;
        } else if(arr[mid] == 1){
            mid++;
        } else {
            let temp = arr[mid];
            arr[mid] = arr[end];
            arr[end] = temp;
            end--;
        }
    }
};