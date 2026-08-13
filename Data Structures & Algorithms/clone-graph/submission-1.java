/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Queue<Node> q=new LinkedList<>();
        Map<Node,Node> mpp=new HashMap<>();
        Node root=new Node(node.val);
        mpp.put(node,root);
        q.offer(node);
        while(!q.isEmpty()){
            Node cur=q.poll();
            for(Node adj:cur.neighbors){
                if(!mpp.containsKey(adj)){
                    mpp.put(adj,new Node(adj.val));
                    q.add(adj);
                }
                mpp.get(cur).neighbors.add(mpp.get(adj));
            }
        }
        return mpp.get(node);
    }
}