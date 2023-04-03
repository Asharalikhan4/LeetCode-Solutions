class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats=0;
        int start=0, end=people.length-1;
        while(start<=end){
            if(people[start]+people[end]<=limit){
                start++;
                end--;
                boats++;
            }
            else if(people[end]<=limit)
            {
                boats++;
                end--;
            }
            else if(people[start]<=limit){
                boats++;
                start++;
            }
        }
        return boats;
    }
}