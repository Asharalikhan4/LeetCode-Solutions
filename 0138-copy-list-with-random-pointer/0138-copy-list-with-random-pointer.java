/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        HashMap<Node,Node> map = new HashMap<>();
        Node temp = head;
        
        while(temp != null){
            //Put temp --> temp'
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }
        
        temp = head;
        
        while(temp != null){
            // Retrieve temp'
            Node newTempNode = map.get(temp);
            newTempNode.next = map.get(temp.next);
            newTempNode.random = map.get(temp.random);
            temp = temp.next;
        }
        
        return map.get(head);
    }
}