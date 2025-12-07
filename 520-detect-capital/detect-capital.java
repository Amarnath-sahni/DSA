class Solution {
    public boolean detectCapitalUse(String word) {
      return allLowerCase(word) || titleWord(word);
    }

    private static boolean allLowerCase(String wordLow){
        int count = 0;
        int upperCase = 0;
        for(int i =0;  i<wordLow.length(); i++){
            char ch = wordLow.charAt(i);

            if(Character.isLowerCase(ch)){
                count++;
            }else if(Character.isUpperCase(ch)){
                upperCase++;
            }
        }

        if(wordLow.length() == count  || upperCase == wordLow.length()){
            return true;
        }

        return false;
    }

    private static boolean titleWord(String titleW){
       int ch = titleW.charAt(0);

       String sub_word = titleW.substring(1);
       int count=0;

       for(int i=0; i<sub_word.length(); i++){
         char c = sub_word.charAt(i);

        if(Character.isLowerCase(c)){
            count++;
        }
       }

       if(count == sub_word.length()){
        return true;
       }
       return false;
    }
}