class Solution {
    public String removeDuplicates(String s) {
       Stack<Character>stack = new Stack<>();
       String ans = "";

       for(int i=0; i<s.length(); i++){
        char ch = s.charAt(i);

        if(!stack.isEmpty() && ch == stack.peek()){
            stack.pop();
        }else{
            stack.push(ch);
        }
       }

       while(!stack.isEmpty()){
        ans = stack.pop() + ans;
       }

       return ans;
    }
}