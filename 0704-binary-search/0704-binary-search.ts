function search(arr: number[], target: number): number {
    let low: number = 0, high: number = arr.length - 1, mid: number;
    while (low <= high) {
        mid = Math.floor((low + high) / 2);
        if (arr[mid] === target) {
            return mid;
        } else if (target > arr[mid]) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
};