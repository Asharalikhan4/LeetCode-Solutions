/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getSize(l1);
        int size2 = getSize(l2);
        if(size2>size1){
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;

            int t = size1;
            size1 = size2;
            size2 = t;
        }
        int carry = logic(l1, l2, size1, size2, 0);
        if(carry!=0)
            return new ListNode(carry, l1);
        return l1;
    }

    private int logic(ListNode l1, ListNode l2, int size1, int size2, int idx1) {
        if(l1==null || l2==null)
            return 0;
        if(size1-idx1>size2){
            int carry = logic(l1.next, l2, size1, size2, idx1+1);
            int sum = l1.val+carry;
            l1.val = sum%10;
            return sum/10;
        } else{
            int carry = logic(l1.next, l2.next, size1, size2, idx1+1);
            int sum = l1.val+l2.val+carry;
            l1.val = sum%10;
            return sum/10;
        }
    }

    private int getSize(ListNode l1) {
        int len=0;
        while(l1.next!=null){
            len++;
            l1=l1.next;
        }
        return len;
    }
}