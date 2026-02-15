class Solution {
    public String reverseWords(String s) {
       StringBuilder sb = new StringBuilder("");
      StringBuilder word = new StringBuilder("");

      for(int i=s.length()-1; i>=0; i--){
        char ch = s.charAt(i);

if(ch == ' ' && sb.length() == 0 && word.length() == 0){
    continue;
}
        if(ch != ' '){
            word.insert(0, ch); // 0th e , ue, lue, blue
        }else if(word.length() > 0){
            if(sb.length() > 0 ){
                sb.append(' ');
            }

            sb.append(word);
            word.setLength(0); // Clear the String
        }
      }

      //append last world if String don't end with empty string
      if(word.length() > 0){
        if(sb.length() > 0){
            sb.append(" ");
        }

        sb.append(word);
      }

      return sb.toString();
    }
}