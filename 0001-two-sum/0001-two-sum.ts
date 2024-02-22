function twoSum(arr: number[], target: number): number[] {
    const myMap: Map<number, number> = new Map();
    for (let i = 0; i < arr.length; i++) {
        const left = target - arr[i];
        if (myMap.has(left)) {
            return [myMap.get(left), i];
        }
        myMap.set(arr[i], i);
    }
    return [];
};