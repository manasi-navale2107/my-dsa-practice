class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int sec = -1;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                int num = ch - '0';

                if(num>first){
                    sec = first;
                    first = num;
                }else if(num > sec && num != first){
                    sec = num;
                }
            }
        }

        return sec;
        
    }
}