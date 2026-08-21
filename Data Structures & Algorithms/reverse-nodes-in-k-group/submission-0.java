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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        if(k>count) return head;
        if(count==k){
            return reverse(head,k);
        }
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        dummy.next=head;
        ListNode cur=head;
        while(count>=k){
            ListNode next=cur;
            for(int i=0;i<k;i++) next=next.next;
            ListNode node=reverse(cur,k);
            prev.next=node;
            prev=cur;
            cur=next;
            count-=k;
        }
        prev.next=cur;
        return dummy.next;
    }
    public ListNode reverse(ListNode start,int k){
        ListNode prev=null;
        while(k>0){
            ListNode next=start.next;
            start.next=prev;
            prev=start;
            start=next;
            k--;
        }
        return prev;
    }
}
