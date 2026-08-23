class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        recurse(n,0,0,new StringBuilder());
        return res;
    }
    public void recurse(int n,int open,int close,StringBuilder sb){
        if(open==close && open==n){
            res.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append('(');
            recurse(n,open+1,close,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            recurse(n,open,close+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
