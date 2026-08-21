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
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode dummy=new ListNode(-1);
        ListNode cur = dummy;
        int carry=0;
        while(p1!=null && p2!=null){
            int sum=p1.val+p2.val+carry;
            int val=sum%10;
            carry=sum/10;
            cur.next=new ListNode(val);
            cur=cur.next;
            p1=p1.next;
            p2=p2.next;
        }
        while(p1!=null){
            int val=p1.val+carry;
            carry=val/10;
            val=val%10;
            cur.next=new ListNode(val);
            cur=cur.next;
            p1=p1.next;
        }
        while(p2!=null){
            int val=p2.val+carry;
            carry=val/10;
            val=val%10;
            cur.next=new ListNode(val);
            cur=cur.next;
            p2=p2.next;
        }
        if(carry>0) cur.next=new ListNode(carry);
        return dummy.next;
    }
}
