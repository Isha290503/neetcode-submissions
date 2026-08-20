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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1=list1;
        ListNode p2=list2;
        ListNode dummy=new ListNode(-1);
        ListNode node=dummy;
        while(p1!=null && p2!=null){
            if(p1.val<=p2.val){
                node.next=p1;
                p1=p1.next;
            }else{
                node.next=p2;
                p2=p2.next;
            }
            node=node.next;
        }
        if(p1!=null) node.next=p1;
        else node.next=p2;
        return dummy.next;
    }
}