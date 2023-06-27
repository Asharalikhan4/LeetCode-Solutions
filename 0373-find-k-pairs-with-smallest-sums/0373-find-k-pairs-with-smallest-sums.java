class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> nums1[p1[0]] + nums2[p1[1]] - (nums1[p2[0]] + nums2[p2[1]]));
        
        pq.add(new int[]{0, 0});

        int i = 0;

        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Set<Integer>> takenMap = new HashMap<>();
        takenMap.put(0, new HashSet<>());
        takenMap.get(0).add(0);

        while(i < k && !pq.isEmpty()){
            int[] pair = pq.remove();
            
            ans.add(List.of(nums1[pair[0]], nums2[pair[1]]));
            
            if(pair[0] + 1 < nums1.length && !(takenMap.containsKey(pair[0] + 1) && takenMap.get(pair[0] + 1).contains(pair[1]))){
                pq.add(new int[]{pair[0] + 1, pair[1]});
                if(!takenMap.containsKey(pair[0] + 1)){
                    takenMap.put(pair[0] + 1, new HashSet<>());
                }
                takenMap.get(pair[0] + 1).add(pair[1]);
            }
            if(pair[1] + 1 < nums2.length && !(takenMap.containsKey(pair[0]) && takenMap.get(pair[0]).contains(pair[1] + 1))){
               pq.add(new int[]{pair[0], pair[1] + 1});
               if(!takenMap.containsKey(pair[0])){
                   takenMap.put(pair[0], new HashSet<>());
               }
               takenMap.get(pair[0]).add(pair[1] + 1);
            }

            i++;
        }

        return ans;
    }
}