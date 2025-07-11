class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //if not equals to the return 
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }

        //GCD
        int gdgLen = GDG(str1.length() , str2.length());
        return str1.substring(0,gdgLen);
    }
    private static int GDG(int a, int b){
        if(b==0)return a;
        return GDG(b, a%b);
    }
}