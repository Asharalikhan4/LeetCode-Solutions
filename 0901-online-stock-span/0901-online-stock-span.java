class StockSpanner {

    int index;
    Stack<Pair>  s;
    public StockSpanner() {
            s = new Stack<>();
            index=0;
    }
    
    public int next(int price) {
        int ans;

        //iterating till the nearest greater in the left
        while (!s.empty()&&(int)s.peek().getValue()<=price) {     
            s.pop();
        }

        if(s.empty()){
            ans =  index+1;              
        }else{
            ans = index - (int)s.peek().getKey();       
        }

        s.push(new Pair(index,price));	
        index++;	
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */