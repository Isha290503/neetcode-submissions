class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> st=new Stack<>();
        int[] res=new int[temp.length];
        for(int i=0;i<temp.length;i++){
            if(st.isEmpty() || temp[i]<=st.peek()[0]){
                st.push(new int[]{temp[i],i});
                continue;
            }
            while(!st.isEmpty() && st.peek()[0]<temp[i]){
                int[] cur=st.pop();
                res[cur[1]]=i-cur[1];
            }
            st.push(new int[]{temp[i],i});
        }
        return res;
    }
}
