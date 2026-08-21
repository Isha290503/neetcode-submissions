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
    public void reorderList(ListNode head) {
        if(head==null) return;
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        int mid=(count+1)/2;
        ListNode cur=head;
        ListNode before=null;
        while(mid>0){
            before=cur;
            cur=cur.next;
            mid--;
        }
        before.next=null;
        ListNode prev=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        temp=head;
        for(int i=0;i<count/2;i++){
            ListNode next=temp.next;
            ListNode last=prev.next;
            temp.next=prev;
            prev.next=next;
            temp=next;
            prev=last;
        }
    }
}
