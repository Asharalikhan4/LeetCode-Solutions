/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(arr) {
    let n = arr.length;
    if(n <= 0){
            return undefined;
        }
        let i = 0;
        for(let j = 0; j < n; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
};