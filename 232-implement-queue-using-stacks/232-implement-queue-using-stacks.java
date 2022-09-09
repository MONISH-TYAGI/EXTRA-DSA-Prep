class MyQueue {
int size;
    Stack<Integer> main;
    Stack<Integer> helper;
    public MyQueue() {
        main=new Stack<>();
        helper=new Stack<>();
        size=0;
    }
    
    public void push(int x) {
    main.add(x);
        size++;
    }
    
    public int pop() {
        if(size==0) return -1;
        while(main.size()>0)
            helper.push(main.pop());
        int val=helper.pop();
        while(helper.size()>0)
            main.push(helper.pop());

        size--;
                return val;
    }
    
    public int peek() {
             if(size==0) return -1;
        while(main.size()>0)
            helper.push(main.pop());
        int val=helper.peek();
        while(helper.size()>0)
            main.push(helper.pop());
        return val;   
    }
    
    public boolean empty() {
       return (size==0); 
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */