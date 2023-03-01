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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode currHead = head;
        if(currHead == null || currHead.next == null){
            return head;
        }
        while(currHead.next != null){
            if(currHead.val == currHead.next.val){
                currHead.next = currHead.next.next;
            } else {
                currHead = currHead.next;
            }
        }
        return head;
    }
}