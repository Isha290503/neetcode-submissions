class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer,Node> mpp;
    int cap;
    public LRUCache(int capacity) {
        cap=capacity;
        mpp=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    public void add(Node node){
        Node next=head.next;
        node.next=next;
        node.prev=head;
        next.prev=node;
        head.next=node;
    }
    public void delete(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
    public int get(int key) {
        if(mpp.containsKey(key)){
            Node node=mpp.get(key);
            int val=node.val;
            delete(node);
            mpp.remove(key);
            add(new Node(key,val));
            mpp.put(key,head.next);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mpp.containsKey(key)){
            Node node=mpp.get(key);
            int val=node.val;
            delete(node);
            mpp.remove(key);
        }
        if(mpp.size()==cap){
            Node prev=tail.prev;
            delete(prev);
            mpp.remove(prev.key);
        }
        add(new Node(key,value));
        mpp.put(key,head.next);
    }
}
class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
