class MyStack {
public:
             queue<int> q;   
    MyStack() {

    }

    void push(int x) {
        q.push(x);
    }
    
    int pop() {
        int s=q.size();
        while(s>1)
        {
          int temp=q.front();
            q.pop();
            q.push(temp);
            s--;
        }
        int temp=q.front();
        q.pop();
        return temp;
    }
    
    int top() {
        return q.back();
    }
    
    bool empty() {
        if(q.size()==0) return true;
        return false;
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */