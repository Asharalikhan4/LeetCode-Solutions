class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int[] arr = new int[persons.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < flowers.length; i++){
            pq.offer(new int[]{flowers[i][0],0});
            pq.offer(new int[]{flowers[i][1],2});
        }
        for(int i = 0; i < persons.length; i++){
            pq.offer(new int[]{persons[i],1,i});
        }
        int count = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            if(temp[1] == 0)    count++;
            else if(temp[1] == 2)   count--;
            else{
                arr[temp[2]] = count;
            }
        }
        return arr;
    }
}