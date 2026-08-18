class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;
    public MinStack() {
        st=new Stack<>();
        minst=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty() || val<=minst.peek()){
            minst.push(val);
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        int top=st.pop();
        if(minst.peek()==top) minst.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}
