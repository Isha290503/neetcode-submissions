class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(Character.isDigit(s.charAt(0)) || (s.length()>1 && s.charAt(0)=='-')) st.push(Integer.parseInt(s));
            else{
                int b=st.pop();
                int a=st.pop();
                if(s.charAt(0)=='+') st.push(a+b);
                else if(s.charAt(0)=='-') st.push(a-b);
                else if(s.charAt(0)=='*') st.push(a*b);
                else st.push(a/b);
            }
        }
        return st.pop();
    }
}
