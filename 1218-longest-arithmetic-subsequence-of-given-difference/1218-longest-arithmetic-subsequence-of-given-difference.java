class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
    //val, count
    final Map<Integer, Integer> map = new HashMap<>();
    int result = 1;
    for(int i = 0; i < n; i++) {
        int prev = arr[i] - difference;
        if(map.containsKey(prev)) {
            final int current = map.get(prev) + 1;
            final int another = map.getOrDefault(arr[i], 1);
            map.put(arr[i], Math.max(current, another));
            result = Math.max(result, current);
        } else {
            map.put(arr[i], 1);
        }
    }
    return result;
    }
}