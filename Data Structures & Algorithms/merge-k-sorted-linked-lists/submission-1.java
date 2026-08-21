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
        TreeMap<Integer,Integer> mpp=new TreeMap<>();
        for(ListNode l:lists){
            ListNode node=l;
            while(node!=null){
                mpp.put(node.val,mpp.getOrDefault(node.val,0)+1);
                node=node.next;
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            for(int i=0;i<val;i++){
                cur.next=new ListNode(key);
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
