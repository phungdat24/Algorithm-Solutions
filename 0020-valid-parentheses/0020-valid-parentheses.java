class Solution {
    private char[] stack = new char[10005];
    private int N = 0;
    public void push(char item){
        stack[N++] = item;
    }
    public char pop(){
        return stack[--N];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public boolean isValid(String s){
        for(char c : s.toCharArray()){
            if( c == '(' || c == '[' || c == '{'){
                push(c);
            }
            else{
                if(isEmpty()) return false;
                else{
                    if( c ==')' && pop() != '(') 
                        return false;
                    if(c ==']' && pop() != '[')
                        return false;
                    if(c =='}' && pop() != '{')
                        return false;
                }
            }
        }
        return isEmpty();
    }
}
