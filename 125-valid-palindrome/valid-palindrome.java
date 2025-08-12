class Solution {
    public boolean isPalindrome(String s) {

        s=s.toLowerCase();
        int s1=0;
        int s2=s.length()-1;

        while(s1<s2){
            char ch1=s.charAt(s1);
            char ch2=s.charAt(s2);

            if(!(ch1>='a' && ch1<='z'|| ch1>='0' && ch1<='9')){
                s1++;
                continue;
            }

             if(!(ch2>='a' && ch2<='z'|| ch2>='0' && ch2<='9')){
                s2--;
                continue;
            }

            if(ch1!=ch2) return false;
                
            s1++;
            s2--;
           
        }

        return true;
        
    }
}