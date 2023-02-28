class MinStack {
    class Pair {
        int value;
        int minvalue;
        Pair(int value,int minvalue){
            this.value = value;
            this.minvalue = minvalue; 
        }
    }
    Stack<Pair> s;
    public MinStack() {
        s = new Stack<>();
    }
    //O(1) O(1)
    public void push(int val) {
        if(s.size()==0){  
            s.push(new Pair(val,val));
        }else{
            int prevmin = s.peek().minvalue;
            s.push(new Pair(val , Math.min(prevmin,val)));
        }  
    }
    
    public void pop() {
        if(s.size()==0){
            return;
        }else{
            s.pop();
        }    
    }
    
    public int top() {
        if(s.size()==0){
            return -1;
        }else{
            return s.peek().value;
        }
        
    }
    
    public int getMin() {
         if(s.size()==0){
            return -1;
        }else{
            return s.peek().minvalue;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */