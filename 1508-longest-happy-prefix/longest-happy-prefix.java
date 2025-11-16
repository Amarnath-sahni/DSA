class Solution {
    public String longestPrefix(String s) {
       int n = s.length();
       int ps[] = new int[n];

       int i =1; 
       int len = 0; 
       while(n>i){
        if(s.charAt(i)==s.charAt(len)){
            len++;
            ps[i] = len;
            i++;
        }else{
            if(len!=0){
                len = ps[len-1];
            }else{
                ps[i] = 0;
                i++;
            }
        }
       }

       int lastval = ps[n-1];
        return s.substring(0,lastval);
    }
}