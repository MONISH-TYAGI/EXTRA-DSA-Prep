class MyStack {
Queue<Integer> a;
    Queue<Integer>b;
    int size;
    int top;
    public MyStack() {
        a=new ArrayDeque<>();
        b=new ArrayDeque<>();
        size=0;
        top=-1;
    }
    
    public void push(int x) {
        
        a.add(x);
        top=x;
        size++;
    }
    
    public int pop() {
        for(int i=1;i<=size;i++)
        {
        if(i!=size)
            {int val=a.remove();
             // System.out.println(val);
           b.add(val);
            }
        }
        int val=a.remove();
        for(int i=1;i<size;i++)
        {
        int ans=b.remove();
            a.add(ans);
            if(i==size-1)top=ans;
        }
        size--;
        if(size==0) top=-1;
        return val;
    }
    
    public int top() {
       return top; 
    }
    
    public boolean empty() {
        return (size==0);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */