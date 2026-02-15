class Solution {
    public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder("");

    int i =  s.length()-1;
    while(i >= 0){

        //if space from right side then skip
        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        }
        if(i<0){
            break;
        }

        //ending of word
        int j = i;

        while(i >=0 && s.charAt(i) != ' '){
            i--;
        }

        if(sb.length() > 0){
            sb.append(' '); 
        }

        sb.append(s.substring(i+1, j+1));
    }

      return sb.toString();
    }
}