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
    HashMap<Node,Node> mpp=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        if(mpp.containsKey(head)) return mpp.get(head);
        Node copy=new Node(head.val);
        mpp.put(head,copy);
        copy.next=copyRandomList(head.next);
        copy.random=mpp.get(head.random);
        return copy;
    }
}
