class Solution {
    public boolean checkString(String s) {
        int a  =0;
        int b =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'b'){
                b++;
            }else{
                a++;
            }

            if(s.charAt(i) == 'a'  && b>0){
                return false;
            }
        }

        return true;
    }
}