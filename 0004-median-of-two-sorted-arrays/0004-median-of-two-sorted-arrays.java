class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          List<Integer> list1 = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();

        for(int i =0 ;i<nums1.length;i++){
            list1.add(nums1[i]);
        }

        for(int j=0;j<nums2.length;j++){
            list2.add(nums2[j]);
        }

       
        List<Integer> ans = new ArrayList<>();

        for(int i =0;i<list1.size();i++){
            ans.add(list1.get(i));
        }

         for(int i =0;i<list2.size();i++){
            ans.add(list2.get(i));
        }
Collections.sort(ans);

        if(ans.size() %2 !=0){
            return (double)ans.get((0 + ans.size()-1) /2);
        }

else{
    return ((double)ans.get((0 + ans.size()-1) /2) + (double)ans.get(ans.size()/2) )/2;
}
    }
}