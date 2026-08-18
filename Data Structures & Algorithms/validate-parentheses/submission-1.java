class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int ind=0;
        for(char c:s.toCharArray()){
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else{
                if(st.isEmpty()) return false;
                if((st.peek()=='[' && c==']') || (st.peek()=='(' && c==')') ||(st.peek()=='{' && c=='}')) st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}
