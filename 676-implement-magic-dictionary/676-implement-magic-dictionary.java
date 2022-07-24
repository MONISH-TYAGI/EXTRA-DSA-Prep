class MagicDictionary {
      public static class Node {
        private Node[] children = new Node[26];
        private boolean isTerminal = false;

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public boolean isTerminal() {
            return isTerminal;
        }

        public void setTerminal() {
            isTerminal = true;
        }

        public void add(char ch) {
            children[ch - 'a'] = new Node();
        }

        public boolean contains(char ch) {
            return (children[ch - 'a'] != null);
        }
    }
    Node root;
    public MagicDictionary() {
        root=new Node();
    }
        public void insert(String word,Node curr)
    {
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(curr.contains(ch)==false)
                curr.add(ch);
            curr=curr.get(ch);
        }
        curr.setTerminal();
    }
    public void buildDict(String[] dictionary) {
        Node curr=root;
     for(String word:dictionary)
         insert(word,curr);
        
    }
    
    public boolean isPossible(String word,boolean change,int idx,Node curr)
    {
        if(idx==word.length())
        {
            if(change==true&&curr.isTerminal()==true)
                return true;
            return false;
        }
       // Node curr=root;
        char ch=word.charAt(idx);
        // System.out.println(word+""+ch);
        if(curr.contains(ch)==true)
        {
            if(isPossible(word,change,idx+1,curr.get(ch)))
                return true;
        }
        if(change==true )return false;
       for(char chN='a';chN<='z';chN++)
        {
            if(ch==chN) continue;
            if(curr.contains(chN))
            {
                if(isPossible(word,true,idx+1,curr.get(chN)))
                return true;
            }
        }    
        
        return false;
    }
    public boolean search(String searchWord) {
    Node curr=root;
   return isPossible(searchWord,false,0,curr);     
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */