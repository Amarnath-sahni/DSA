class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();

       for(int i=0; i<n; i++){
        char ch = s.charAt(i);
        boolean unique = true;

        for(int j=0; j<n; j++){
          if(i!=j && ch == s.charAt(j)){
            unique = false;
            break;
          } 
        }

        if(unique) return i;
       }
       return -1;
    }
}