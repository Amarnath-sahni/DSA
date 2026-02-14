class Solution {
    public String removeStars(String s) {
        String ans = "";
        Stack<Character>stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '*'){

            if(!stack.isEmpty()){
            stack.pop();
             }

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