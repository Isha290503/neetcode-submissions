class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length()!=endWord.length()) return 0;
        Set<String> set=new HashSet<>(wordList);
        Queue<Pair> q=new LinkedList<>();
        int mini=Integer.MAX_VALUE;
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p=q.poll();
            StringBuilder cur=new StringBuilder(p.s);
            int len=p.len;
            if(cur.toString().equals(endWord)) mini=Math.min(mini,len);
            for(int i=0;i<cur.length();i++){
                char ch=cur.charAt(i);
                for(char c='a';c<='z';c++){
                    cur.setCharAt(i,c);
                    if(set.contains(cur.toString())){
                        q.offer(new Pair(cur.toString(),len+1));
                        set.remove(cur.toString());
                    }
                    cur.setCharAt(i,ch);
                }
            }
        }
        return mini==Integer.MAX_VALUE?0:mini;
    }
}
class Pair{
    String s;
    int len;
    Pair(String s,int len){
        this.s=s;
        this.len=len;
    }
}
