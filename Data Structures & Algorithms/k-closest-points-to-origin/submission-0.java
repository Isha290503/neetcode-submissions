class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(a.dis,b.dis));
        int[][] ans=new int[k][2];
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            double dis=Math.sqrt((x*x)+(y*y));
            pq.offer(new Pair(x,y,dis));
        }
        for(int i=0;i<k;i++){
            Pair cur=pq.poll();
            ans[i][0]=cur.x;
            ans[i][1]=cur.y;
        }
        return ans;
    }
}
class Pair{
    int x;
    int y;
    double dis;
    Pair(int x,int y,double dis){
        this.x=x;
        this.y=y;
        this.dis=dis;
    }
}
