class Solution {
    private char[] stack;
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
        int len = s.length();
        if (len % 2 != 0) return false;
        stack = new char[len];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
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
