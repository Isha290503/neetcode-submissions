class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxi=0;
        for(int i=0;i<=heights.length;i++){
            int cur=(i==heights.length)?0:heights[i];
            while(!st.isEmpty() && (heights[st.peek()]>=cur)){
                int h=heights[st.pop()];
                int right=i;
                int left=st.isEmpty()?-1:st.peek();
                int w=right-left-1;
                maxi=Math.max(maxi,h*w);
            }
            st.push(i);
        }
        return maxi;
    }
}
