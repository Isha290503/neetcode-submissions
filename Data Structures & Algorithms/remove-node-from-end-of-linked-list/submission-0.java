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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        if(count==n) return head.next;
        ListNode prev=null;
        ListNode cur=head;
        for(int i=1;i<=count-n;i++){
            prev=cur;
            cur=cur.next;
        }
        prev.next=cur.next;
        return head;
    }
}
