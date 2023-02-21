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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            while (current != null) {
                queue.add(current.val);
                current = current.next;
            }
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        while (queue.size() > 0) {
            temp.next = new ListNode(queue.remove());
            temp = temp.next;
        }
        return head.next;
    }
}