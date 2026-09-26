class Solution {
    private char[] stack;
    private int N = 0;
    private void push(char item){
        stack[N++] = item;
    }
    public char pop(){
        return stack[--N];
    }
    public String makeGood(String s) {
        int len = s.length();
        stack = new char[len];
        N= 0;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if (N > 0 && Math.abs(stack[N - 1] - c) == 32) {
                pop();
            } else {
                push(c); 
            }
        }
        return new String(stack, 0, N);       
    }
}