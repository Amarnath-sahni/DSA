class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);
        return result;
    }

    private static void backtrack(String s, int open,int close,int max, List<String>result){
        if(s.length()==max*2){
            result.add(s);
            return;
        }

        if(open<max){
            backtrack(s+"(", open+1, close, max, result);
        }

        if(close < open){
            backtrack(s+")", open, close+1, max, result);
        }
    }
}